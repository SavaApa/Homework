package new_year.Exception;

public class NoTeamWithMaxResultException extends RuntimeException{
    public NoTeamWithMaxResultException(String message){
        super(message);
    }
}
