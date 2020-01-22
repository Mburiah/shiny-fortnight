package dao;

import models.Employee;
import org.sql2o.Sql2o;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oEmployeeDao implements EmployeeDao {

    private final Sql2o sql2o;
    public Sql2oEmployeeDao(Sql2o sql2o) { this.sql2o = sql2o; }

    @Override
    public void add (Employee  employee){
        String sql = "INSERT INTO employees(name, position, department_id VALUES(:name, :position, :department_id)";
        try (Connection connection= sql2o.open()){
            int id = (int) connection.createQuery(sql, true)
                    .bind(employee)
                    .executeUpdate()
                    .getKey();
            employee.setId(id);
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Employee> getEmployees(){
        try (Connection connection= sql2o.open()) {
            return connection.createQuery("SELECT * FROM employees")
                    .executeAndFetch(Employee.class);
        }
    }

    @Override
    public List<Employee> getAllEmployeeFromADepartment(int departmentId) {
        try (Connection connection = sql2o.open()){
            return connection.createQuery("SELECT * FROM employees WHERE department_id = :departmentId")
                    .addParameter("department Id", departmentId)
                    .executeAndFetch(Employee.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from employees WHERE id= :id";

        try(Connection connection= sql2o.open()){
            connection.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from employees";
        try (Connection connection= sql2o.open()){
            connection.createQuery(sql).executeUpdate();
        }catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
