FROM adoptopenjdk/openjdk12-openj9:jre
RUN mkdir /usr/src/myapp
COPY ./build/libs/orderAPI-0.0.1-SNAPSHOT.jar /usr/src/myapp
WORKDIR /usr/src/myapp
EXPOSE 8080
ENV JAVA_OPTS='-Dspring.data.mongodb.host=mongodb'
CMD ["java", "-Dspring.data.mongodb.host=mongodb", "-jar", "orderAPI-0.0.1-SNAPSHOT.jar"]


