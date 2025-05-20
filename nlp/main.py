from fastapi import FastAPI
from pydantic import BaseModel
from model.sentiment import analuyze_sentiment

app = FastAPI()

class SentimentRequest(BaseModel):
    text: str

@app.get("/")
async def root():
    return {"message": "Hello World"}


@app.get("/hello/{name}")
async def say_hello(name: str):
    return {"message": f"Hello {name}"}

@app.post("/analyze")
def analyze(req: SentimentRequest):
    result = analuyze_sentiment(req.text)
    return {"result": result}