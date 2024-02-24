package _31_01_2024_yaml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
            FileReader reader = new FileReader("C:\\projects\\homework\\src\\_31_01_2024\\1.yaml");
            UniversityContainer universityContainer = objectMapper.readValue(reader, UniversityContainer.class);

            //1. Получить список всех курсов в университете
            List<Course> courses = UniversityProcessor.getAllCourses(universityContainer.getUniversity());
            for (Course course : courses) {
                System.out.println(course);
            }

            // 2. Найти количество курсов в каждом департаменте
            Map<String, Long> map = UniversityProcessor.getCoursesCountByDepartment(universityContainer.getUniversity());
            for (Map.Entry<String, Long> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }

            // 3. Получить список названий всех курсов, которые имеют более 3 кредитов
            List<String> title = UniversityProcessor.getCoursesWithMoreThanThreeCredits(universityContainer.getUniversity());
            for (String s : title) {
                System.out.println(s);
            }

            // 4. Найти всех профессоров, которые ведут более одного курса
            Set<String> teaching = UniversityProcessor.getProfessorsTeachingMultipleCourses(universityContainer.getUniversity());
            for (String s : teaching) {
                System.out.println(s);
            }

            // 5. Получить мапу курсов, где ключ - название курса, значение - список тем
            Map<String, List<String>> listMap = UniversityProcessor.getCourseTopicsMap(universityContainer.getUniversity());
            for (Map.Entry<String, List<String>> entry : listMap.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }

            // 6. Найти департаменты, где все курсы имеют более 3 кредитов
            System.out.println(UniversityProcessor.getDepartmentsWithAllCoursesMoreThanThreeCredits(universityContainer.getUniversity()));

            // 7. Получить список курсов, сгруппированных по количеству кредитов
            Map<Integer, List<Course>> integerListMap = UniversityProcessor.getCoursesGroupedByCredits(universityContainer.getUniversity());
            for (Map.Entry<Integer, List<Course>> entry : integerListMap.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }

            // 8. Найти департамент с самым большим количеством курсов
            System.out.println(UniversityProcessor.getDepartmentWithMostCourses(universityContainer.getUniversity()));

            // 9. Получить мапу, где ключ - название департамента, а значение - среднее количество кредитов курсов в департаменте
            Map<String, Double> doubleMap = UniversityProcessor.getAverageCreditsPerDepartment(universityContainer.getUniversity());
            for (Map.Entry<String, Double> entry : doubleMap.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }

            // 10. Найти курсы, у которых более 2 тем и профессор начинается на 'Dr.'
            List<Course> list = UniversityProcessor.getCoursesWithMoreThanTwoTopicsAndDrProfessor(universityContainer.getUniversity());
            for (Course course : list) {
                System.out.println(course);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
