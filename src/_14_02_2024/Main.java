package _14_02_2024;

import java.util.List;

public class Main extends StudentRegistry {
    public static void main(String[] args) {
        Student student1 = new Student(1, "John", "Doe", "john@example.com", 3.5, Faculty.ENGINEERING, 2, true);
        Student student2 = new Student(2, "Alice", "Smith", "alice@example.com", 4.0, Faculty.BUSINESS, 3, false);
        Student student3 = new Student(3, "Bob", "Johnson", "bob@example.com", 3.2, Faculty.BUSINESS, 1, true);

        studentMap.put(student1.getId(), student1);
        studentMap.put(student2.getId(), student2);
        studentMap.put(student3.getId(), student3);

        Student student4 = new Student(4, "Eva", "White", "eva@example.com", 3.8, Faculty.ENGINEERING, 4, false);
        addStudent(student4);
        System.out.println(studentMap.entrySet());

        removeStudent(3);
        System.out.println(studentMap.entrySet());

        List<Student> studentsByMajor = findStudentsByMajor(Faculty.BUSINESS);
        System.out.println(studentsByMajor);

        System.out.println(calculateAverageGrade());

        List<Student> studentByYear = listStudentsByYear(2);
        System.out.println(studentByYear);

        Student getStudent = getStudent(4);
        System.out.println(getStudent);

        System.out.println(getTotalNumberOfStudents());

        List<Student> studentsWithGradeAbove = getStudentsWithGradeAbove(3.4);
        System.out.println(studentsWithGradeAbove);

        System.out.println(getAverageGradeByMajor(Faculty.BUSINESS));

        System.out.println(isStudentPresent("john@example.com"));
    }
}
