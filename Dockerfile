FROM openjdk:11
WORKDIR /app
ADD DzTry2Application myDir
RUN javac DzTry2Application.java
CMD ["java", "DzTry2Application"]