package homework.collections.hospital.exceptions;

public class DoctorHasntAvailableTimeException extends RuntimeException {
    public DoctorHasntAvailableTimeException(String message) {
        super(message);
    }
}
