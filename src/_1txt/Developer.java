package _1txt;

public class Developer extends Employee{
   private String programmingLanguage;
    private boolean remote;

    @Override
    public void work() {
        if(remote){
            System.out.println("работает дистанционно");
        }else{
            System.out.println("работает в офисе");
        }
    }

    public void takeBreak(){
        System.out.println("разработчик отдыхает");
    }
}
