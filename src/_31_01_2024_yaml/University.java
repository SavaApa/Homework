package _31_01_2024_yaml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class University {
    private String name;
    private List<Department> departments;

    public University() {
    }

    public University(String name, List<Department> departments) {
        this.name = name;
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "University{" +
                "name='" + name + '\'' +
                ", departments=" + departments +
                '}';
    }
}
