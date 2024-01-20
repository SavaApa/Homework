package _17_01_2024.Task1;

import java.util.ArrayList;
import java.util.List;

class Department {
    private final String name;
    private final List<EmployeeDepartment> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(EmployeeDepartment employee){
        employees.add(employee);
    }

    public String getName() {
        return name;
    }

    public List<EmployeeDepartment> getEmployees() {
        return employees;
    }
}

class EmployeeDepartment {
    private final String name;
    private final double salary;

    public EmployeeDepartment(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "EmployeeDepartment{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}