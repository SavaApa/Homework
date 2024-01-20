package _17_01_2024.Task1;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {
    public static void main(String[] args) {
        //Задача 1: Напишите метод, который принимает список списков целых чисел
        //и преобразует его в один список
        List<List<Integer>> list = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(3, 4, 3),
                Arrays.asList(1, 2, 3)
        );
        System.out.println(flattenListOfLists(list));

        //Задача 2: Напишите метод, который преобразует список объектов с
        //вложенными списками в один список всех вложенных элементов.
        List<User> user = new ArrayList<>();
        User user1 = new User("Mark", Arrays.asList("M", "N", "P"));
        User user2 = new User("Anna", Arrays.asList("Q", "S", "P"));
        User user3 = new User("Alex", Arrays.asList("L", "N", "P"));
        user.add(user1);
        user.add(user2);
        user.add(user3);
        System.out.println(getAllSkills(user));

        //Задача 3: Напишите метод, который объединяет строки из списка объектов.
        List<Book> books = new ArrayList<>();
        Book book1 = new Book("Harry", Arrays.asList("Mark", "Alex", "Anna"));
        Book book2 = new Book("Potter", Arrays.asList("Mark", "Alex", "Petter"));
        Book book3 = new Book("Ring", Arrays.asList("Leon", "Rob", "Johnson"));
        books.add(book1);
        books.add(book2);
        books.add(book3);
        System.out.println(getAuthorsTitles(books));
        //Задача 4: Напишите метод, который преобразует Map в список значений.

        //Задача 5: Напишите метод, который принимает список списков и фильтрует все
        // четные числа, а затем умножает их на 2.
        System.out.println(processAndFilter(list));

        //Задача 6: Преобразование и фильтрация объектов в списках
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee("Police", Arrays.asList("Spain", "English", "German"));
        Employee employee2 = new Employee("Teacher", Arrays.asList("Russian", "Poland"));
        Employee employee3 = new Employee("Architect", Arrays.asList("Spain", "English", "German"));
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        System.out.println(getLanguagesFromDepartment(employees, "Police"));
//        Задача 8: Напишите метод, который принимает список объектов с вложенными коллекциями,
//сортирует вложенные элементы и возвращает отсортированный список всех элементов.
        List<Project> projects = new ArrayList<>();
        Project project1 = new Project("project1", Arrays.asList("p.12", "p.13"));
        Project project2 = new Project("project2", Arrays.asList("p.10", "p.11"));
        projects.add(project1);
        projects.add(project2);
        System.out.println(getSortedTasks(projects));
//     Задача 9: Напишите метод, который преобразует карту, где ключи - это строки, а значения -
//списки объектов, в один список уникальных строк, извлечённых из атрибутов объектов.
        Map<String, List<Product>> products = Map.of(
                "Electronics", List.of(new Product("Electronics", "Laptop")),
                "Clothing", List.of(new Product("Clothing", "T-Shirt"))
        );
        //Задача 11: Обработка вложенных структур с условными фильтрами
        //Задание: Напишите метод, который обрабатывает вложенные структуры данных
        //(например мапы, содержащих списки), фильтрует элементы по условию и объединяет их в один список.
        List<Order> orders = new ArrayList<>();
        Order order1 = new Order("Customer1");
        order1.addItem(new Item("Item1", 13.2));
        order1.addItem(new Item("Item2", 40.4));

        Order order2 = new Order("Customer2");
        order2.addItem(new Item("Item3", 78.3));
        order2.addItem(new Item("Item4", 90.4));

        orders.add(order1);
        orders.add(order2);
        System.out.println(getItemsByCustomerName(orders, "Customer1"));
//  Задача 12: Напишите метод, который объединяет данные из вложенных коллекций разных
//  объектов и считает сумму некоторого числового атрибута.
        List<Department> departments = new ArrayList<>();
        Department department1 = new Department("Department1");
        department1.addEmployee(new EmployeeDepartment("Adama", 32.5));
        department1.addEmployee(new EmployeeDepartment("Liza", 43.4));

        Department department2 = new Department("Department2");
        department2.addEmployee(new EmployeeDepartment("Dima", 92.5));
        department2.addEmployee(new EmployeeDepartment("Ivan", 12.4));

        departments.add(department1);
        departments.add(department2);
        System.out.println(getTotalSalaryByDepartment(departments, "Department2"));
    }

    public static List<Integer> flattenListOfLists(List<List<Integer>> listOfLists) {
        return listOfLists.stream()
                .flatMap(Collection::stream)
                .toList();
    }

    public static List<String> getAllSkills(List<User> users) {
        return users.stream()
                .flatMap(skills -> skills.getSkills().stream())
                .toList();
    }

    public static List<String> getAuthorsTitles(List<Book> books) {
        return books.stream()
                .flatMap(book -> book.getAuthors().stream().map(author -> author + " - " + book.getTitle()))
                .toList();
    }

    public static List<String> flattenMap(Map<String, List<String>> map) {
        return map.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public static List<Integer> processAndFilter(List<List<Integer>> listOfLists) {
        return listOfLists.stream()
                .flatMap(Collection::stream)
                .filter(el -> el % 2 == 0)
                .map(el -> el * 2)
                .toList();
    }


//Задание: Напишите метод, который фильтрует список объектов по некоторому условию,
//а затем извлекает и объединяет определённые атрибуты этих объектов в один список.

    public static List<String> getLanguagesFromDepartment(List<Employee> employees, String department) {
        return employees.stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .flatMap(languages -> languages.getLanguages().stream())
                .collect(Collectors.toList());
    }

    public static List<String> getSortedTasks(List<Project> projects) {
        List<String> strings = projects.stream()
                .flatMap(tasks -> tasks.getTasks().stream())
                .sorted(String::compareTo)
                .toList();
        Collections.sort(strings);
        return strings;
    }

    //
//Задача 9: Напишите метод, который преобразует карту, где ключи - это строки, а значения -
//списки объектов, в один список уникальных строк, извлечённых из атрибутов объектов.
    public static List<String> getUniqueProductNames(Map<String, List<Product>> categoryMap) {
        return categoryMap.values().stream()
                .flatMap(Collection::stream)
                .map(Product::getName)
                .distinct()
                .toList();
    }

    //    Задача 10: Напишите метод, который объединяет данные из нескольких списков и
//преобразует их в один список, применяя к каждому элементу определённую функцию.
    public static List<String> combineAndTransform(List<Integer> list1, List<Double> list2, Function<Number, String> transformer) {
        return Stream.concat(list1.stream(), list2.stream())
                .map(transformer)
                .toList();
    }

    //    Задача 11: Обработка вложенных структур с условными фильтрами
//Задание: Напишите метод, который обрабатывает вложенные структуры данных
//(например мапы, содержащих списки), фильтрует элементы по условию и объединяет их в один список.
    public static List<Item> getItemsByCustomerName(List<Order> orders, String customerName) {
        return orders.stream()
                .filter(custName -> custName.getCustomerName().equals(customerName))
                .flatMap(el -> el.getItems().stream())
                .filter(el -> el.getPrice() > 39.0)
                .toList();
    }

    public static double getTotalSalaryByDepartment(List<Department> departments, String departmentName) {
        return departments.stream()
                .filter(department -> department.getName().equals(departmentName))
                .flatMap(el -> el.getEmployees().stream())
                .mapToDouble(EmployeeDepartment::getSalary)
                .sum();
    }

    public List<String> combineAndTransformComplex(List<Integer> integers, List<String> strings, List<Double> doubles) {
        List<String> stringList = new ArrayList<>();

        stringList.addAll(integers.stream()
                .map(Object::toString)
                .toList());
        stringList.addAll(strings);

        // Преобразование и объединение списка чисел с плавающей запятой
        stringList.addAll(doubles.stream()
                .map(Object::toString)
                .toList());

        return stringList;
    }
}
