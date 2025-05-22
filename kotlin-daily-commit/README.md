# 📘 Kotlin 1일 1커밋 스터디 로드맵 (총 60일)

> Kotlin 초보자를 위한 실전 중심 로드맵입니다. 하루 1커밋으로 Kotlin 실력을 키워봅시다!

---

## ✅ 목표
- 하루에 하나씩 Kotlin 실력을 쌓자
- GitHub에 매일 커밋하여 포트폴리오화
- Kotlin 문법 + Spring Boot 백엔드 실습

---

## 📦 1주차 (Day 1 ~ 7) – Kotlin 기초 문법

| Day | 주제 | 설명 |
|-----|------|------|
| 1 | Hello Kotlin | println("Hello, Kotlin!") |
| 2 | 변수와 타입 | val, var, 타입추론 |
| 3 | 문자열 템플릿 | "Hello, $name!" |
| 4 | 조건문 | if, when |
| 5 | 반복문 | for, while, forEach |
| 6 | 함수 정의 | 매개변수, 기본값, 반환 |
| 7 | null 안전 | ?. !! ?: let 등 |

---

## 🧰 2주차 (Day 8 ~ 14) – 컬렉션과 클래스

| Day | 주제 | 설명 |
|-----|------|------|
| 8 | List/Set/Map | 기본 컬렉션 생성 및 반복 |
| 9 | filter/map | 함수형 스타일 컬렉션 처리 |
| 10 | data class | 자동 생성 메서드 활용 |
| 11 | 클래스 & 생성자 | 클래스 구조 이해 |
| 12 | 상속 | open, override |
| 13 | object & companion | 싱글턴과 정적 메서드 |
| 14 | enum class | 상태 표현 및 when 활용 |

---

## 🧪 3주차 (Day 15 ~ 21) – Kotlin 활용 예제

| Day | 주제 | 예제 |
|-----|------|------|
| 15 | 계산기 구현 | 사칙연산 처리기 |
| 16 | 로또 번호 뽑기 | Random, Set, 정렬 |
| 17 | 날짜 포맷터 | LocalDateTime, 포맷팅 |
| 18 | 문자열 뒤집기 | reversed(), 반복문 연습 |
| 19 | Palindrome 검사 | 함수 분리 연습 |
| 20 | 파일 읽기/쓰기 | File().readLines(), writeText() |
| 21 | 간단 JSON 처리 | kotlinx.serialization |

---

## 🏗 4주차 (Day 22 ~ 28) – 객체지향 + 함수형 감각 익히기

| Day | 주제 | 설명 |
|-----|------|------|
| 22 | 고차함수 | 함수 인자로 함수 넘기기 |
| 23 | 람다식 | val sum = { a: Int, b: Int -> a + b } |
| 24 | Scope 함수 | let, run, apply, also, with |
| 25 | 확장 함수 | String.removeSpaces() 등 |
| 26 | sealed class | 상태 표현 (Success, Error) |
| 27 | Exception 처리 | try, catch, finally |
| 28 | Unit 테스트 | assertEquals(), 테스트 함수 작성 |

---

## 🌱 5주차 (Day 29 ~ 35) – Kotlin + Spring Boot 입문

| Day | 주제 | 설명 |
|-----|------|------|
| 29 | 프로젝트 세팅 | Gradle Kotlin DSL + Spring Boot |
| 30 | Hello Controller | @RestController + @GetMapping |
| 31 | DTO와 Request 처리 | @RequestBody, @Valid |
| 32 | Service 분리 | 역할 분리 연습 |
| 33 | Repository 없이 메모리 저장소 | 간단 CRUD 구현 |
| 34 | JPA 설정 + H2 연동 | Entity, @Id, ddl-auto |
| 35 | 기본 CRUD API 완성 | GET, POST, PUT, DELETE |

---

## ⚙ 6주차 (Day 36 ~ 42) – 실전 웹 백엔드 기능 확장

| Day | 주제 | 설명 |
|-----|------|------|
| 36 | 오류 핸들링 | @ControllerAdvice, ExceptionHandler |
| 37 | Enum 저장 | @Enumerated, Enum 활용 |
| 38 | 로그인 구조 설계 | 세션 또는 토큰 구조 이해 |
| 39 | RestClient 사용 | 외부 API 연동 |
| 40 | 유효성 검증 | @NotNull, @Size 등 |
| 41 | 비즈니스 로직 테스트 | 단위 테스트 작성 |
| 42 | 리팩토링 | 패키지 구조 정리 |

---

## 🌊 7주차 (Day 43 ~ 49) – 비동기 / 인증 / 확장 기능

| Day | 주제 | 설명 |
|-----|------|------|
| 43 | Coroutine 기초 | suspend, launch, delay |
| 44 | withContext | Dispatcher IO/Default |
| 45 | Flow 기초 | flow {}, collect |
| 46 | Job & Cancel | 비동기 제어 흐름 |
| 47 | 서비스 계층에 Coroutine 적용 | 병렬 호출 연습 |
| 48 | JWT 인증 시작 | 토큰 발급 로직 작성 |
| 49 | JWT 인증 필터 구현 | 필터 기반 인증 처리 |

---

## 🚀 8주차 (Day 50 ~ 60) – 포트폴리오 완성과 회고

| Day | 주제 | 설명 |
|-----|------|------|
| 50 | 프로젝트 정리 | API Docs, 테스트 마무리 |
| 51 | README 포트폴리오화 | 기술 스택/목차 정리 |
| 52~56 | 미니 개인 프로젝트 | 게시판, ToDo 앱 등 |
| 57 | 블로그 배포용 정리 | Markdown, Notion 등 정리 |
| 58 | GitHub Action 커밋 배지 | 잔디 인증용 배지 추가 |
| 59 | 회고 작성 | 배운 점 정리 |
| 60 | 다음 목표 설정 | Spring Cloud, Kafka, AI 등 확장 준비 |