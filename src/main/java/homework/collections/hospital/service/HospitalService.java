package homework.collections.hospital.service;

import java.util.List;
import java.util.Map;

public interface HospitalService<Doctor, Patient, Time> {

    void reservate(Doctor doctor, Time time, Patient patient);

    void cancelReservation(Doctor doctor, Time time, Patient patient);

    Map<Doctor, Map<Time, List<Patient>>> findReservationByPatient(Patient patient);

    Map<Doctor, Map<Time, List<Patient>>> findAllReservations();
}
