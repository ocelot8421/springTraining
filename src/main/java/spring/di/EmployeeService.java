package spring.di;


import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private EmployeeDao employeeDao;

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void saveEmployee(String name){
        //BL
        String trimmedName = name.trim();
        employeeDao.saveEmployee(trimmedName);
    }
}
