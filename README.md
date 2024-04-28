# Prerequisites
- openjdk version 17+
- Spring Boot 3.2.X
- Installed Docker
- Optional: Installed IntelliJ IDEA

# Github
Clone Backend project via: `https://github.com/bohenmian/book-management.git`

# How to run the project in local environment
```shell
./gradlew bootRun
```

# How to run the test
```shell
./gradlew test
```

# How to run with Docker

1. Clone the project the desktop
2. Run the command
```shell
./gradlew clean build
```
3. Build the docker image and run the project
```shell
docker build -t book-management .
```
4. Run the project 
```shell
docker run -p 8080:8080 book-management
```