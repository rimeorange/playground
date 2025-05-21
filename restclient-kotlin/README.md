# REST Client Example (Spring Boot + Kotlin)

이 프로젝트는 [Agify API](https://agify.io)를 연동하여 이름을 기반으로 예상 나이를 추정하는 간단한 Spring Boot 애플리케이션입니다.  

외부 RestApi를 호출할 프로젝트가 있었는데 RestTemplate 대신 

Spring 6에서 도입된 `RestClient`를 사용하여 프로젝트를 진행 했었는데 그때는 java로 구현하였고

이번에 kotlin으로 연습하고자 예제 프로젝트를 만들어 봤다.

---

## 기술 스택

- Kotlin 1.9
- Spring Boot 3.2+
- RestClient (Spring 6+)
- Gradle (Kotlin DSL)

---

## 주요 기능

- `/agify?name=이름`으로 요청 시 → `https://api.agify.io/?name=이름` 호출
- 응답(JSON)을 DTO로 매핑하여 반환
- 외부 API 호출을 `RestClient`로 객체지향적으로 구성

---

## 프로젝트 구조

```
src/main/kotlin/com/example/agify/
├── config/
│   └── RestClientConfig.kt          # RestClient.Builder Bean 등록
├── client/
│   └── RestClient.kt                # Agify API 호출 책임
├── controller/
│   └── AgifyController.kt           # REST API 엔드포인트
├── dto/
│   └── AgifyResponse.kt             # 응답 매핑 DTO
└── RestclientKotlinApplication.kt              # 메인 클래스
```

---

## 구조 설명: RestClientConfig.kt 와 AgifyClient.kt의 관계

- `RestClientConfig.kt`는 **공통 설정**을 가진 `RestClient.Builder`를 **Spring Bean으로 등록**합니다.
- `AgifyClient.kt`는 해당 Builder를 **주입받아** `build()`로 `RestClient` 인스턴스를 생성합니다.
- 이렇게 나누는 이유는 **설정의 재사용**과 **객체지향적 책임 분리(SRP)**를 위해서입니다.
- Builder는 공장처럼 동작하고, `AgifyClient`는 호출 로직을 책임지는 서비스입니다.

---

## 왜 RestClient는 매번 build() 해서 새로 만드는가?

- `RestClient`는 내부 상태가 **불변(immutable)**이므로 thread-safe합니다.
- 하지만 `RestClient.Builder`는 **mutable(변경 가능)**하며, 설정(baseUrl 등)을 바꿀 수 있습니다.
- 여러 클라이언트가 Builder를 동시에 공유하면 설정이 꼬일 수 있으므로,
  → **호출 시마다 `builder.build()`로 새로운 인스턴스를 생성**하는 것이 안전합니다.

예를 들어,
```kotlin
val builder = RestClient.builder()
val client1 = builder.baseUrl("https://api.agify.io").build()
val client2 = builder.baseUrl("https://api.other.com").build() // client1에도 영향 줄 수 있음
```

- 위처럼 `builder`를 공유하면서 설정을 바꾸면, 이전에 생성된 클라이언트(client1)도 영향을 받을 수 있어요.
- 그래서 **매번 새 인스턴스를 만드는 것이 설정 충돌을 방지하는 가장 안전한 방법**입니다.

만약 매번 생성하기 싫다면 외부 url 별로 RestClient를 각자 생성하고

```
@Service
class RestClient(
    private val builder: RestClient.Builder
) {

    private val client: org.springframework.web.client.RestClient = builder
        .baseUrl("https://api.agify.io")  //  baseUrl 명시적으로 지정
        .build()

    fun getAgePrediction(name: String): AgifyResponse {
        return client.get()
            .uri { uriBuilder -> uriBuilder.queryParam("name", name).build() }
            .retrieve()
            .body(AgifyResponse::class.java)!!
    }
}
```
이렇게 생성하면 매번 인스턴스를 만들지 않아도 된다.



---


### 3. 테스트

```http
GET http://localhost:8080/agify?name=emma
```

응답 예시:
```json
{
  "name": "emma",
  "age": 36,
  "count": 123456
}
```

---

## 학습 포인트

- Spring 6의 `RestClient.Builder`를 활용한 외부 API 클라이언트 구성
- DTO를 통한 응답 파싱
- Controller-Service 구조 분리
- 객체지향 원칙(SRP, 재사용성) 적용

---

## 참고 자료

- Spring RestClient 공식 문서: [https://docs.spring.io/spring-framework/reference/integration/rest-clients.html](https://docs.spring.io/spring-framework/reference/integration/rest-clients.html)

---

## 예제 프로젝트

> [👉 GitHub 예제 링크](https://github.com/rimeorange/playground/tree/main/restclient-kotlin)

