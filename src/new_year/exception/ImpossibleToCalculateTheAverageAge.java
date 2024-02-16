package new_year.exception;

public class ImpossibleToCalculateTheAverageAge extends RuntimeException{
    public ImpossibleToCalculateTheAverageAge(String message){
        super(message);
    }
}
