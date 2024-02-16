package new_year.exception;

public class NoTeamWithMaxResultException extends RuntimeException{
    public NoTeamWithMaxResultException(String message){
        super(message);
    }
}
