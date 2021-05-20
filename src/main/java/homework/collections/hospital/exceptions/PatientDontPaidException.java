package homework.collections.hospital.exceptions;

public class PatientDontPaidException extends RuntimeException {
    public PatientDontPaidException(String message) {
        super(message);
    }
}
