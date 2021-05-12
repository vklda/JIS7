package homework.collections.hospital.service;

import homework.collections.hospital.model.Doctor;
import homework.collections.hospital.model.Patient;
import homework.collections.hospital.model.Time;
import homework.collections.hospital.repository.HospitalRepositoryImpl;

import java.util.List;
import java.util.Map;

public class HospitalService {

    private final HospitalRepositoryImpl hospitalRepository;

    public HospitalService(HospitalRepositoryImpl hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public void initialize(List<Doctor> doctors) {
        hospitalRepository.initialize(doctors);
    }

    public void reservate(Doctor doctor, Time time, Patient patient) {
        hospitalRepository.reservate(doctor, time, patient);
    }

    public void cancelReservation(Doctor doctor, Time time, Patient patient) {
        hospitalRepository.cancelReservation(doctor, time, patient);
    }

    public Map<Doctor, Map<Time, List<Patient>>> findAllReservations() {
        return hospitalRepository.findAllReservations();
    }

    public Map<Doctor, Map<Time, List<Patient>>> findReservationByPatient(Patient patient) {
        return hospitalRepository.findReservationByPatient(patient);
    }
}
