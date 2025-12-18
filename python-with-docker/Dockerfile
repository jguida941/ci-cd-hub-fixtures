# Minimal Dockerfile for CI/CD Hub docker fixture testing
# Purpose: Exercise Trivy container scanning and Docker build steps
FROM python:3.12-slim

WORKDIR /app

COPY requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt

COPY . .

CMD ["python", "-m", "python_docker"]
