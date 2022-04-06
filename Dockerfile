FROM openjdk:17

# copy jar file into docker image
ADD build/libs/int20220405-0.0.1.jar /app.jar
# expose port 8080
EXPOSE 8080
CMD ["java", "-jar", "/app.jar"]
