# 🤖 Kotlin + Python NLP Sentiment Analyzer

이 프로젝트는 **Kotlin(Spring Boot)**과 **Python(FastAPI)**를 연동하여 **자연어 처리(NLP) 기반 감정 분석 기능**을 제공하는 백엔드 서비스입니다.  
Spring WebClient를 이용해 외부 AI 모델 서버와 통신하며, 실제 제품에 가까운 구조로 설계되었습니다.

---

## 📌 주요 기능

- 사용자의 텍스트 입력을 받아 감정(긍정/부정) 분석 수행
- Kotlin(Spring Boot)에서 Python(FastAPI) 기반 NLP 모델 API 호출
- HuggingFace Transformers의 사전학습 모델을 이용해 감정 분석 수행
- 추후 확장을 고려한 구조 설계 (요약기, 분류기 등으로 전환 가능)

---

## 🛠️ 기술 스택

| 영역     | 기술                                        |
|----------|---------------------------------------------|
| 언어     | Kotlin, Python                              |
| 백엔드   | Spring Boot (Kotlin), FastAPI (Python)      |
| HTTP 통신| Spring WebClient                            |
| NLP 모델 | HuggingFace `pipeline("sentiment-analysis")`|
| 통신 방식| RESTful JSON                                |

---

## 🗂️ 프로젝트 구조

```
kotlin-nlp-project/
├── kotlin-client/         # Kotlin (Spring Boot) API 서버
│   ├── controller/
│   ├── dto/
│   ├── config/
│   └── build.gradle.kts
├── python-api/            # Python (FastAPI) NLP 서버
│   ├── main.py
│   ├── model/sentiment.py
│   └── requirements.txt
└── README.md
```

---

## 📦 API 예시

### ➕ 요청

```http
POST /nlp/sentiment
Content-Type: application/json

{
  "text": "I really love this service!"
}
```

### 🔁 응답

```json
{
  "result": [
    {
      "label": "POSITIVE",
      "score": 0.99983
    }
  ]
}
```

---

## 🚀 실행 방법

### 1. Python API 실행

```bash
cd python-api
pip install -r requirements.txt
uvicorn main:app --reload --port 8000
```

### 2. Kotlin API 실행

```bash
cd kotlin-client
./gradlew bootRun
```

---

## 📈 향후 확장 계획

- 텍스트 요약, 키워드 추출 기능 추가
- 감정 분석 결과 저장 및 통계 조회 API 추가
- 사용자별 요청 로그 및 분석 대시보드 연동
- GPT 연동으로 챗봇 기능 확장

---

## 📜 라이선스

MIT License

---

