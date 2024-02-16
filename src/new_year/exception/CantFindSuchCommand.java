package new_year.exception;

public class CantFindSuchCommand extends RuntimeException{
    public CantFindSuchCommand (String message){
        super(message);
    }
}
