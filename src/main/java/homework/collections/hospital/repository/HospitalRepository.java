package homework.collections.hospital.repository;

import homework.collections.hospital.model.Patient;
import homework.collections.hospital.model.Time;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface HospitalRepository<Doctor, Patient, Time> {

    void reservate(Doctor doctor, Time time, Patient patient);

    void cancelReservation(Doctor doctor, Time time, Patient patient);

    Map<Doctor, Map<Time, List<Patient>>> findReservationByPatient(Patient patient);

    Map<Doctor, Map<Time, List<Patient>>> findAllReservations();
}
