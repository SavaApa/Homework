package _1txt;

abstract class Employee implements EmployeeActions{
    protected String name;
    protected int age;
    protected String department;
    protected double salary;

    @Override
    public void work() {
        System.out.println("работник работает");
    }

    @Override
    public void takeBreak() {
        System.out.println("работник отдыхает");
    }
}
