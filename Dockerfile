FROM openjdk:11

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=target/*.jar

ADD ${JAR_FILE} simple-board.jar

ENTRYPOINT ["java","-Dspring.profiles.active=real", "-jar","/simple-board.jar"]