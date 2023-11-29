package _1txt;

public class HRManager extends Employee{
    private int numberOfRecruitments;
    private String[] candidateList;

    public void work(){
        System.out.println("HR менеджер работает");
    }

    public void takeBreak(){
        System.out.println("HR менеджер отдыхает");
    }
}
