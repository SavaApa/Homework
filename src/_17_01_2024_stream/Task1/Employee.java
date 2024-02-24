package _17_01_2024_stream.Task1;

import lombok.Getter;

import java.util.List;

@Getter
public class Employee {
    private final String department;
    private final List<String> languages;

    public Employee(String department, List<String> languages) {
        this.department = department;
        this.languages = languages;
    }

}
