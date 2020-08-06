FROM openjdk:8

VOLUME /tmp

EXPOSE 8000

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} board.jar

ENTRYPOINT ["java","-jar","/board.jar"]
