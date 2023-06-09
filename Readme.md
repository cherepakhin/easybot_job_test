### Behave тестирование RestAssured проекта Easybot

Тестируемый проект [https://github.com/cherepakhin/easybot_job](https://github.com/cherepakhin/easybot_job)

Для проведения тестов использован RestAssured<br/>
 [https://github.com/rest-assured/rest-assured](https://github.com/rest-assured/rest-assured/wiki/GettingStarted)

Для просмотра отчетов использован Allure [https://docs.qameta.io/allure/](https://docs.qameta.io/allure/)

Скрипты выполнять из папки проекта с тестами Rest Assured. 
Перед запуском тестов нужно запустить сам проект:
[https://github.com/cherepakhin/easybot_job](https://github.com/cherepakhin/easybot_job)

```shell
# Проведение теста
easybot_restassured$ mvn clean test
# Просмотр отчета в браузере
easybot_restassured$ ./allure serve target/surefire-reports/
```

### Шпаргалка по вложенности

![Epic-Feature-Story](doc/hierarchy.png)

### Документация по Allure

https://docs.qameta.io/allure/
https://allure-framework.github.io/allure-demo/5/#suites/a2891ce60e520f56ae25e6caf68ea773/448aea45096280d4/



