from transformers import pipeline

classifier = pipeline("sentiment-analysis")

def analuyze_sentiment(text: str):
    return classifier(text)