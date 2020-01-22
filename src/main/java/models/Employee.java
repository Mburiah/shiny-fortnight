package models;

import java.util.Objects;

public class Employee {
    private String name;
    private String position;
    private int id;
    private int department_id;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    public Employee(String name, String position, int department_id) {
        this.name = name;
        this.position = position;
        this.department_id = department_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() !=o.getClass()) return false;
        Employee employee = (Employee) o;
        return  getId() == employee.getId() &&
                getDepartment_id() == employee.getDepartment_id()&&
                Objects.equals(getName(), employee.getName())&&
                Objects.equals(getPosition(), employee.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPosition(), getId(), getDepartment_id());
    }
}
