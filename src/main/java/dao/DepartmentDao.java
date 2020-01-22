package dao;

import models.News;
import models.Department;
import models.Employee;

import java.util.List;

public interface DepartmentDao {

    void add(Department department);

    void addClassifiedNewsToDepartment(News news , Department department);

    List<Department> getDepartments();

    List<News> getAllNewsByDepartment(int departmentId);

    Department findById(int id);

    void deleteById(int id);
    void clearAll();
}