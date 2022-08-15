package uz.isystem.UserService.exception;

public class BadRequest extends RuntimeException{
    public BadRequest(String message){
        super(message);
    }
}