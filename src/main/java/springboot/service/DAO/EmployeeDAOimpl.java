package springboot.service.DAO;


import org.hibernate.SessionFactory;
import springboot.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
// SpringBoot работает с JPA, как мы помним, это спецификация, которая описывает взаимодействие
// с базой данных, а самой популярной реализацией является Hibernate. Прежде чем описывать CRUD
// операции, мы описывали в конфигурации бин для создания SessionFactory, создавали здесь поле
// с типом этого бина и с помощью внедрения зависимости инициализировали это поле.
// Это нужно было нам для получения сессии. Однако все эти операции относятся именно к Hibernate,
// SpringBoot использует для этих операций другой объект - EntityManager. Снизу мы оставим
// закомментированный код, как напоминание о том, как работает Hibernate, а здесь начнем
// реализовывать эти операции с помощью EntityManager.
@Repository
public class EmployeeDAOimpl implements EmployeeDAO {
    // Для начала создаем поле EntityManager и внедряем зависимость, для дальнейшей работы.
    // Забавный момент, IDE ругается, что не видит бина для внедрения зависимости, однако
    // это происходит из-за аннотации @Repository. Если мы ее закомментируем, ошибка пропадет.
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
        // Нам все так же необходимо получить объект сессии, entityManager является оберткой
        // для сессии и методом unwrap() с переданным внутрь классом Session мы и получаем
        // объект сессии с которым уже работаем. Позже мы рассмотрим как это делать
        // только с помощью SpringBoot, а тут у нас будет некий гибрид с Hibernate.
        // Пока не будем трогать этот класс, вспомним, что нам необходимо сделать далее.
        // А далее нам нужно создать Service который будет посредником между DAO и Controller.
        // Мы его так же скопируем из предыдущего проекта. Как и сам контроллер.
        // Мы закомментируем все методы, которые нам в данный момент не нужны и удалим обработку
        // исключений. На данной лекции у нас будет только получение всех работников.
        // Перейдем в MyRestController
        Session session = entityManager.unwrap(Session.class);
        Query<Employee> query = session.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

//    @Override
//    public List<Employee> getAllEmployees() {
//        Session session = entityManager.unwrap(Session.class);
//        Query<Employee> query = session.createQuery("from Employee", Employee.class);
//        return query.getResultList();
//    }

    @Override
    public void saveEmployee(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        Session session = entityManager.unwrap(Session.class);

        return session.get(Employee.class, id);
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(session.get(Employee.class, id));
    }
}
