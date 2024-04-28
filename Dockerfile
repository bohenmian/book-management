FROM openjdk:17

WORKDIR /app

COPY ./build/libs/book-management-0.0.1-SNAPSHOT.jar /app

CMD ["java","-jar","/app/book-management-0.0.1-SNAPSHOT.jar"]