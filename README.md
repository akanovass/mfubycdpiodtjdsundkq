# Задание "CRUD телефония"
Задание для Junior Backend Developer (Java)
# 1. Требования 
 Spring Boot 3.2.2
 Gradle 8.5
 Java 17
 PostgreSQL 42.5.4
 MongoDB 3.2.1
 
#  2. Установка
**Клонируйте репозиторий из GitHub:**

    git clone https://github.com/akanovass/mfubycdpiodtjdsundkq.git

**Перейдите в директорию проекта:**

    cd mfubycdpiodtjdsundkq

**Установите зависимости, запустив Gradle:**

    ./gradlew build

# 3. Запуск приложения

**Подключите базы данных::**  
Для PostgreSQL:
 - Создайте базу данных с именем `mfubycdpiodtjdsundkq`.
  - Подключитесь к базе данных:
    - username: `postgres` 
    - password: `postgres`
    - URL: `jdbc:postgresql://localhost:5432/mfubycdpiodtjdsundkq`

Для MongoDB: 
   - Создайте базу данных с именем `mfubycdpiodtjdsundkq` 
   - Подключитесь к базе данных:     
     - URI: `mongodb://localhost:27017/mfubycdpiodtjdsundkq`

> Убедитесь, что серверы баз данных запущены и прослушивают указанные порты!

**Запустите приложение:**

    ./gradlew bootRun

> Сервер будет запущен на порту localhost:8800

#  4. Использование
**Импорт Postman коллекции:**
  Чтобы использовать предварительно созданные запросы, импортируйте файл main/resourse/postman/postman_collection.json в Postman.
  
# 5. Структура проекта
Проект состоит из следующих основных компонентов:
  **Model**. Представляющие сущности и их структуру.
     
   **Repository**. Для взаимодействия с базой данных.
   
 **Service**.Содержащие бизнес-логику.
 
 **Controller**. Для обработки HTTP-запросов.
 Описание методов контроллеров:
1.  getRegisterById:
    -   URL: `GET /register/{id}`
    -   Входной параметр: `id` (тип `Long`)
    -   Получение Register по id.
2.  getRegisterByPhoneNumb:
    -   URL: `GET /register`
    -   Входной параметр: `phoneNumb` (тип `String`)
    -   Получение по номеру телефона.
3.  deleteRegisterById
    -   URL: `DELETE /register/{id}`
    -   Входной параметр: `id` (тип `Long`)
    -   Удаление по id.
4.  deleteRegisterByPhoneNumb:
    -   URL: `DELETE /register`
    -   Входной параметр: `phoneNumb` (тип `String`)
    -   Удаление по номеру телефона.
5.  getRegistersByFilter:
    -   URL: `GET /register/filter`
    -   Входной параметр: Объект `Filter` в теле запроса
    -   Получение весь список где в запросе отправляем класс Filter и внутри него есть поле limit и offset
6.  updateUserById:
    -   URL: `PUT /register/updateById/{id}`
    -   Входной параметр: `id` (тип `Long`) в URL, `RegisterDTO` в теле запроса
    -   Обновление  по id.
7.  updateUserByPhoneNumber:
    -   URL: `PUT /register/updateByPhoneNumb/{phoneNumb}`
    -   Входной параметр: `phoneNumb` (тип `String`) в URL, `RegisterDTO` в теле запроса
    -   Обновление по номеру телефона.
 
 **DTO (Data Transfer Objects)**. Для передачи данных между слоями приложения или с клиентами.  
Поле `createdDate` скрыто от пользователей и не доступно для просмотра, есть только в бд. Для этой цели использовано DTO.

 **Mapper**. Для преобразования объектов между моделями и DTO.
 
 Для создания фейковых данных, которые автоматически загружаются в базу данных при запуске проекта, используется  **PostConstruct.** 
 
Тестирование в проекте осуществляется с использованием **TestNG**. Реализованы тесты для метода `GetRegisterById`.

Использовано **Spring Data JPA**, **Hibernate ORM** для взаимодействия с бд.

**Lombok** использовано для уменьшение количество шаблонного кода в Java проектах.
