package jproject.my_board.exception;

public class SessionEmptyException extends RuntimeException{

    public SessionEmptyException(String message){
        super(message);
    }
}
