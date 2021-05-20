package homework.streamapi.task4.exception;

public class DontFindRequiredPersonException extends RuntimeException{
    public DontFindRequiredPersonException(String message) {
        super(message);
    }
}
