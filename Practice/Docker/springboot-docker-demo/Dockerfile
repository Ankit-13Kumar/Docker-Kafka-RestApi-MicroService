# image from docker hub
FROM eclipse-temurin:17

# MetaData
LABEL mentainer="net.javaguides@gmail.com"

# WorkDirectory
WORKDIR /app
# COPY INSTRUCTION to our JAR file
COPY target/springboot-docker-demo-0.0.1-SNAPSHOT.jar /app/springboot-docker-demo.jar

# To Start Entry Instructions
# Getting error bcoz i have not provide space after ENTRYPOINT
ENTRYPOINT ["java", "-jar", "springboot-docker-demo.jar"]

