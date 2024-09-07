FROM openjdk:21
VOLUME /tmp
EXPOSE 8080
#RUN mdkir -p
ADD ./target/bisa-blog-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]