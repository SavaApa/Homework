package _17_01_2024.Task1;

import java.util.List;

public class User {

    private final List<String> skills;

    public User(String name, List<String> skills) {
        this.skills = skills;
    }

    public List<String> getSkills() {
        return skills;
    }
}
