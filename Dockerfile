FROM gradle:jdk12 as builder

COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle -PbuildEnv=prod build

FROM openjdk:8-jre-slim
EXPOSE 8080

COPY --from=builder /home/gradle/src/build/libs/test-task-0.1.0.jar /app/app.jar
WORKDIR /app
CMD [ "java", "-jar", "-Djava.security.egd=file:/dev/./urandom", "-Dspring.config.location=classpath:/,/app/", "/app/app.jar"]
