# Generar la imagen
#   docker build -t app_books .
#   docker tag usuario/app_authors
# docker build -t usuario/app_books .

FROM eclipse-temurin:21.0.3_9-jre-alpine

RUN mkdir /app
WORKDIR /app

COPY /target/demo-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java","-jar","app.jar"]