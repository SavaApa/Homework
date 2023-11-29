package _1txt;

public class Manager extends Employee{
    public int timeSize;
    public String[] teamMembers;

    public void work(){
        System.out.println("менеджер работает");
    }

    public void takeBreak(){
        System.out.println("менеджер отдыхает");
    }
}
