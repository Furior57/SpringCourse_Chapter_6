package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// Первое, что мы увидим это аннотацию @SpringBootApplication, эта аннотация объединяет в себе
// три разных аннотации @Configuration, @EnableAutoConfiguration и @ComponentScan
@SpringBootApplication(scanBasePackages = "springboot")
public class Chapter6SpringBootApplication {
    // Далее мы видим метод run() в который передается main класс, он сам создаст контейнер,
    // инициализирует бины и конфигурацию. Какой пакет будет сканироваться для поиска этих
    // компонентов? А сканироваться будет тот пакет где лежит main-класс, как и все его подпакеты.
    // Этот путь может быть некорректен, но мы можем в аннотации @SpringBootApplication
    // прописать необходимый пакет.
    public static void main(String[] args) {
        SpringApplication.run(Chapter6SpringBootApplication.class,
                args);
    }
    // А теперь рассмотрим вариант создания SpringBoot проекта для бедных :).
    // Мы можем пользоваться бесплатной IDE, но там такого удобного меню при создании
    // проекта не будет. Для того чтобы создать подобный проект существует
    // сайт start.spring.io. Там все элементарно, здесь описывать ничего не будем. Генерируем
    // проект, скачиваем и открываем нашей IDE./

}
