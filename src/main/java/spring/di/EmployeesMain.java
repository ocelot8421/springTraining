package spring.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmployeesMain {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            EmployeeDao employeeDao = context.getBean(EmployeeDao.class);
            employeeDao.saveEmployee("XY");
            System.out.println(employeeDao.listEmployees());
        }
    }
}
