package _17_01_2024.Task1;

import java.util.List;

public class Project {
    private String name;
    private final List<String> tasks;

    public Project(String name, List<String> tasks) {
        this.name = name;
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTasks() {
        return tasks;
    }

}
