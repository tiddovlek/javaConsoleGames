FROM maven:3.6.3-jdk-11-openj9
ADD out/artifacts/java_console_game_jar/java-console-game.jar java-console-game.jar
ENTRYPOINT ["java","-jar","/java-console-game.jar"]
