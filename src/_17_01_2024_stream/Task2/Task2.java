package _17_01_2024_stream.Task2;

import java.util.*;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
//        Задача 14:  Напишите метод, который обрабатывает список объектов,
//        содержащих другие объекты с коллекциями.
//Ваша задача - вычислить среднее значение некоторого числового поля для каждого уникального ключа.

        List<Company> companies = List.of(
                new Company("Company1", List.of(
                        new Department("Depart1", List.of(new Employee("John", 30000), new Employee("Alice", 10000))),
                        new Department("Depart2", List.of(new Employee("Bob", 100000), new Employee("Sava", 110000)))
                )),
                new Company("Company2", List.of(
                        new Department("Depart3", List.of(new Employee("Max", 90000), new Employee("Danya", 2000000)))
                ))
        );

        System.out.println(averageSalaryByCompany(companies));

        List<Order> orders = List.of(
                new Order("Customer1", List.of(
                        new Product("Electronic", 1500.0),
                        new Product("Clothing", 1100.0),
                        new Product("Auto", 800.0)
                ))
        );

        Map<String, List<String>> result = highValueProductsByCustomer(orders, 1000.0);
        result.forEach((customer, products) -> System.out.println(customer + ", High-Value Products: " + products));
    }

    public static Map<String, Double> averageSalaryByCompany(List<Company> companies) {
        return companies.stream()
                .collect(Collectors.groupingBy(Company::getName,
                        Collectors.averagingDouble(el ->
                                el.getDepartments().stream()
                                        .flatMap(department -> department.getEmployees().stream())
                                        .mapToDouble(Employee::getSalary)
                                        .average()
                                        .orElse(0.0))));
    }

    //    Задача 15: Напишите метод, который анализирует данные из нескольких различных коллекций,
//соединяет их и выводит результаты, соответствующие определённым критериям.
    public static Map<String, List<String>> highValueProductsByCustomer(List<Order> orders, double threshold) {
        return orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCustomerName,
                        Collectors.flatMapping(
                                order -> order.getProducts().stream()
                                        .filter(product -> product.getPrice() > threshold)
                                        .map(Product::getCategory),
                                Collectors.toList()
                        )
                ));
    }
}
