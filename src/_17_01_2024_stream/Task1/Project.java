package _17_01_2024_stream.Task1;

import lombok.Getter;

import java.util.List;

@Getter
public class Project {
    private String name;
    private final List<String> tasks;

    public Project(String name, List<String> tasks) {
        this.name = name;
        this.tasks = tasks;
    }

    public void setName(String name) {
        this.name = name;
    }

}
