package _14_02_2024;

import java.util.*;
import java.util.stream.Collectors;

public class StudentRegistry {
    public static Map<Integer, Student> studentMap = new HashMap<>();

    //   добавляет студента в реестр
    public static void addStudent(Student student) {
        studentMap.put(student.getId(), student);
    }

    //    удаляет студента по идентификатору
    public static void removeStudent(int id) {
        studentMap = studentMap.entrySet().stream()
                .filter(student -> student.getKey() != id)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    // возвращает список студентов, обучающихся на указанной специальности
    public static List<Student> findStudentsByMajor(Faculty major) {
        return studentMap.values().stream()
                .filter(el -> el.getMajor().equals(major))
                .collect(Collectors.toList());
    }

//    вычисляет средний балл среди всех студентов
    public static double calculateAverageGrade(){
        return studentMap.values().stream()
                .collect(Collectors.averagingDouble(Student::getGrade));
    }

//    возвращает список студентов, обучающихся на указанном курсе
    public static List<Student> listStudentsByYear(int year){
        return studentMap.values().stream()
                .filter(el -> el.getYear() == year)
                .collect(Collectors.toList());
    }

//     возвращает студента по его идентификатору
    public static Student getStudent(int id){
        return studentMap.entrySet().stream()
                .filter(el -> el.getKey() == id)
                .map(Map.Entry::getValue)
                .findFirst()
                .orElseThrow(null);
    }

//    возвращает общее количество студентов
    public static long getTotalNumberOfStudents(){
        return studentMap.values().stream()
                .map(Student::getFirstName)
                .count();
    }

//    возвращает список студентов, чей средний балл выше указанного
    public static List<Student> getStudentsWithGradeAbove(double grade){
        return studentMap.values().stream()
                .filter(el -> el.getGrade() > grade)
                .collect(Collectors.toList());
    }

//   вычисляет средний балл среди студентов определенной специальности.
    public static double getAverageGradeByMajor(Faculty major){
        return studentMap.values().stream()
                .filter(el -> el.getMajor() == major)
                .collect(Collectors.averagingDouble(Student::getGrade));
    }

//    проверяет, существует ли студент с заданным email в реестре.
    public static boolean isStudentPresent(String email){
        return studentMap.values().stream()
                .anyMatch(el -> Objects.equals(el.getEmail(), email));
    }
}
