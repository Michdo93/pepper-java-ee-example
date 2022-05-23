# pepper-java-ee-example
A simple example how to use the Java SDK with the pepper robot within a Java EE application. More specifically, a servlet is used and executed in an Apache Tomcat 8.0 server. The sample Dynamic Web App project will connect with a pepper robot under a given ip. Then it will create a tts service. After that the robot will say "Hello World!".

The Java project was created for NAOqi version 2.5. You have to download the Java SDK first and then import it as external library.

```
wget https://community-static.aldebaran.com/resources/2.5.10/Java%20SDK/java-naoqi-sdk-2.5.6.5-linux64%20%281%29.jar
```
