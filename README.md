- [x] Java 21
- [x] Gradle 8.7

Стек технологий:

`Gradle` - сборщик проектов.  \
`JUnit5` - executor тестов.\
`Allure Report` - визуализация тестовых результатов.\
`AsserJ` - Исполнение ассертов.\

Коротко про структуру:

`java/org/example/ui/page` - сттраницы с логикой \
`java/org/example/utils/config` - чтение конфига \
`java/org/example/utils/text` - текста с ошибками \
`java/extensions` - кофигурация браузера \
`java/test` - сами тесты 



запустить тесты `./gradlew clean test allureServe` 
