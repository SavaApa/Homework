package new_year.Exception;

public class CantFindSuchCommand extends RuntimeException{
    public CantFindSuchCommand (String message){
        super(message);
    }
}
