package _17_01_2024.Task1;

import java.util.List;

public class Employee {
    private final String department;
    private final List<String> languages;

    public Employee(String department, List<String> languages) {
        this.department = department;
        this.languages = languages;
    }

    public String getDepartment() {
        return department;
    }

    public List<String> getLanguages() {
        return languages;
    }
}
