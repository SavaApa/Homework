package _14_02_2024_test;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Student {
    int id;
    String firstName;
    String lastName;
    String email;
    double grade;
    Faculty major;
    int year;
    boolean fullTime;

    public Student(int id, String firstName, String lastName, String email, double grade, Faculty major, int year, boolean fullTime) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.grade = grade;
        this.major = major;
        this.year = year;
        this.fullTime = fullTime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", email=" + email +
                ", grade=" + grade +
                ", major=" + major +
                ", year=" + year +
                ", fullTime=" + fullTime +
                '}';
    }
}
