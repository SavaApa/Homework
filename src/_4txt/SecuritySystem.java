package _4txt;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class SecuritySystem  extends Device implements Security{
    private boolean isArmed;
    private String[] accessCodes;
    @Override
    void versionUpdate() {

    }

    public static void security(boolean isArmed, String[] accessCodes){
        if(isArmed){
            System.out.println("Доступ открыт");
        }else{
            System.out.println("Введите пароль");
            Scanner scanner = new Scanner(System.in);
            String person = scanner.nextLine();
            if(!Objects.equals(person, Arrays.toString(accessCodes))){
                System.out.println("Система заблокирована");
            }else{
                System.out.println("Система разблокирована");
            }
        }

    }

    @Override
    public void armSystem(String code) {

    }

    @Override
    public void disarmSystem(String code) {

    }
}
