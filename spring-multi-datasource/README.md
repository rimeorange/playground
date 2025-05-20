# 🌐 Spring Boot : MySQL + Oracle 멀티 데이터소스 구성 (feat. SSH 터널링,)

프로젝트 설계중에 멀티 데이터 소스를 구성할 일이 있었다.

`Spring Boot`를 기반으로 MySQL, Oracle 두 디비 접속 소스를 구성하고.

Local에서 ssh 터널링 까지 추가한 구성을 하였기에 브로그에 간단한 기록을 남겨본다.

---

## 📌 목차

1.  [멀티 데이터소스가 필요한 이유](#%EB%A9%80%ED%8B%B0-%EB%8D%B0%EC%9D%B4%ED%84%B0%EC%86%8C%EC%8A%A4%EA%B0%80-%ED%95%84%EC%9A%94%ED%95%9C-%EC%9D%B4%EC%9C%A0)
2.  [시스템 구성도](#%EC%8B%9C%EC%8A%A4%ED%85%9C-%EA%B5%AC%EC%84%B1%EB%8F%84)
3.  [application.yml 설정](#applicationyml-%EC%84%A4%EC%A0%95)
4.  [SSH 터널이란?](#ssh-%ED%84%B0%EB%84%90%EC%9D%B4%EB%9E%80)
5.  [MySQL 설정 클래스 (@Primary)](#mysql-%EC%84%A4%EC%A0%95-%ED%81%B4%EB%9E%98%EC%8A%A4-primary)
6.  [Oracle 설정 클래스 (보조)](#oracle-%EC%84%A4%EC%A0%95-%ED%81%B4%EB%9E%98%EC%8A%A4-%EB%B3%B4%EC%A1%B0)
7.  [JPA 설정 분리 및 적용](#jpa-%EC%84%A4%EC%A0%95-%EB%B6%84%EB%A6%AC-%EB%B0%8F-%EC%A0%81%EC%9A%A9)
8.  [실습 결과 및 주의사항](#%EC%8B%A4%EC%8A%B5-%EA%B2%B0%EA%B3%BC-%EB%B0%8F-%EC%A3%BC%EC%9D%98%EC%82%AC%ED%95%AD)
9.  [마무리 및 실무 팁](#%EB%A7%88%EB%AC%B4%EB%A6%AC-%EB%B0%8F-%EC%8B%A4%EB%AC%B4-%ED%8C%81)

---

## 1\. 멀티 데이터소스가 필요한 이유

-   **이기종 DB 연동** (예: MySQL + Oracle or MySQL + MySQL -> 서로 접속정보가 다른경우)
-   **레거시 시스템 데이터 활용**
-   **데이터 분산 및 샤딩 처리**
-   **데이터 적재/분석 분리 목적**

---

## 2\. 시스템 구성도

```
[Spring Boot]
├── MySQL (기본)
│   └── jdbc:mysql://localhost:3308/sampledb
│       └── SSH Tunnel → Bastion → 내부망 DB
│
├── Oracle (보조)
│   └── jdbc:oracle:thin:@localhost:1521/XEPDB1
│       └── SSH Tunnel → Bastion → 내부망 DB
```

---

## 3\. `application.yml` 설정

```
spring:
  datasource:
    hikari:
      driver-class-name: com.mysql.cj.jdbc.Driver
      jdbc-url: ENC(jdbc:mysql://localhost:3308/sampledb)
      username: ENC(mysql_user)
      password: ENC(mysql_password)
  datasource-second:
    hikari:
      driver-class-name: oracle.jdbc.OracleDriver
      jdbc-url: ENC(jdbc:oracle:thin:@//localhost:1521/XEPDB1)
      username: ENC(oracle_user)
      password: ENC(oracle_password)
  ssh:
    tunnel:
      ssh-host: bastion.example.com
      ssh-port: 22
      ssh-username: devuser
      ssh-password: your-secure-password
      local-port: 3308
      remote-host: 10.0.0.101
      remote-port: 3306
    tunnel-second:
      ssh-host: bastion.example.com
      ssh-port: 22
      ssh-username: devuser
      ssh-password: your-secure-password
      local-port: 3307
      remote-host: 10.0.0.102
      remote-port: 3306
  jpa:
    database-platform: org.hibernate.dialect.MySQL8Dialect
    show-sql: true
```

---

## 4\. SSH 터널이란?

SSH 터널링은 외부에서 직접 접근할 수 없는 내부망 DB에 접근할 수 있도록 **보안 통로**를 만드는 방식입니다.

---

## 5\. MySQL 설정 클래스 (`@Primary`)

```
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  basePackages = "com.example.mysql.repository",
  entityManagerFactoryRef = "mysqlEntityManagerFactory",
  transactionManagerRef = "mysqlTransactionManager"
)
public class DataSourceConfiguration { ... }
```

---

## 6\. Oracle 설정 클래스 (보조)

```
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  basePackages = "com.example.oracle.repository",
  entityManagerFactoryRef = "oracleEntityManagerFactory",
  transactionManagerRef = "oracleTransactionManager"
)
public class DataSourceSecondConfiguration { ... }
```

---

## 7\. JPA 설정 분리 및 적용

-   각 EntityManagerFactory에서 `packagesToScan`으로 엔티티 위치 지정
-   Hibernate Dialect도 필요 시 각 DB에 맞게 분리 설정

---

---

## 8\. 실습 결과 및 주의사항

✅ 성공적으로 MySQL과 Oracle 양쪽에서 JPA Repository 조회 및 저장 가능  
⚠️ `@Primary` 설정 누락 시 충돌 발생  
⚠️ SSH 터널 연결이 실패하면 DB 접속 불가 → 자동화 스크립트 추천

---

## 9\. 마무리 및 실무 팁

-   커넥션 풀 설정은 환경에 따라 튜닝이 필요할듯.
-   `@Transactional` 사용 시 트랜잭션 매니저를 명확히 구분해야 충돌 방지
-   도메인 분리가 필요한 경우 각 DB Entity를 패키지별로 나누어야 합니다.

---

## 🔗 예제 프로젝트

> [👉 GitHub 예제 링크](https://github.com/rimeorange/playground/tree/main/spring-multi-datasource)

---

작성자: `rimeorange`  
실무에서 직접 활용한 내용을 바탕으로 구성했습니다.