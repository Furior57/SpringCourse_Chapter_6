public class Lesson_75_JPARepository {
    // Немного ретроспективы. Мы создали entity сущность, создали интерфейс с методами
    // позволяющими работать с этой сущностью и имплементировали эти методы в классе
    // который пометили как @Repository. Однако, что нам делать, если у нас несколько Entity?
    // Создавать несколько репозиториев, описывая одинаковые по функционалу методы?
    // Нет, здесь нам на помощь придет интерфейс @JPARepository.

    // В SpringBoot имеется механизм Spring Data JPA, он отвечает за взаимодействие с
    // базами данных, заключается он в определенных названиях для методов.
    // Если кратко, то у нас есть несколько ключевых слов описывающих операции,
    // которые мы хотим проводить. Как в конструкторе мы из этих слов составляем
    // название метода и в нем автоматически генерируется логика. Просто и гениально.

    // Для реализации мы создадим новый проект. Назовем его SpringCourseDataJPA, перейдем в него.
    // Лекция продолжится там же.
}
