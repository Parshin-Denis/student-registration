# Консольное SPRING приложение для учёта студентов.

## Описание работы
Программа по запросу пользователя добавляет, удаляет и выводит в консоль список студентов. Информация о каждом состоит
из его ID, имени, фамилии и возраста. В приложении присутствует `dockerfile` для возожности создания докер-образа.  


## Настройки
В файле конфигурации `src/resources/application.properties` можно установить следующие 2 параметра:
```Java Properties
app.initializer.enabled=true
app.initializer.filename=src/main/resources/default-students.txt
```
Параметр `app.initializer.enabled` определяет, будет ли при запуске приложения загружаться список студентов
из файла, указанного в параметре `app.initializer.filename`.

## Управление
Управляется приложение вводом в консоли одной из четырех заданных команд с соответсвующими ей параметрами.

1. Добавить студента в список можно вводом команды `addStudent`/`a` и трех параметров через пробел: Имя, Фамилия,
Возраст. Параметр ID устанавливается автоматически. Пример: `a Сергей Журавлев 25`.
2. Удалить студента из списка можно вводом команды `removeStudent`/`r` и параметра ID через пробел. Пример: `r 5`.
3. Вывести список студентов в консоль можно вводом команды `printStudentList`/`p`. Пример: `p`
4. Очистить список студентов можно с помощью команды `clearStudentList`/`c`. Пример: `c`.
