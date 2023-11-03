# Базовый образ, содержащий Java 17
FROM openjdk:17-oracle

# Директория приложения внутри контейнера
WORKDIR /app

# Копирование Jar-файла приложения в контейнер
COPY target/StudentRegistration-0.0.1-SNAPSHOT.jar app.jar

# Команда для запуска приложения
CMD ["java", "-jar", "app.jar"]