package dao;

import models.Department;
import models.Employee;
import java.util.List;

public interface EmployeeDao {
    void add(Employee employee);

    List<Employee> getEmployees();
    List<Employee> getAllEmployeeFromADepartment(int departmentId);

    void deleteById(int id);
    void clearAll();
}

