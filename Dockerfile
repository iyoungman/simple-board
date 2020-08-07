FROM openjdk:11

VOLUME /tmp

EXPOSE 8000

ARG JAR_FILE=target/*.jar

ADD ${JAR_FILE} board.jar

ENTRYPOINT ["java","-jar","-Dspring.profiles.active=real","/board.jar"]
