package homework.collections.hospital.repository;

import homework.collections.hospital.exceptions.DoctorHasntAvailableTimeException;
import homework.collections.hospital.exceptions.PatientDontPaidException;
import homework.collections.hospital.model.Doctor;
import homework.collections.hospital.model.Patient;
import homework.collections.hospital.model.Time;

import java.util.*;

public class HospitalRepositoryImpl implements HospitalRepository<Doctor, Patient, Time> {

    private static final Map<Doctor, Map<Time, List<Patient>>> repository = new HashMap();

    @Override
    public void reservate(Doctor doctor, Time time, Patient patient) {
        if (patient.isPaid()) {
            if (isDoctorHasFreeTime(doctor, time)) {
                book(doctor, time, patient);
            } else if (isDoctorBusy(doctor, time)) {
                time = chooseNextTime(time);
                reservate(doctor, time, patient);
            }
        } else throw new PatientDontPaidException("Should pay before reservation");
    }

    @Override
    public void cancelReservation(Doctor doctor, Time time, Patient patient) {
        repository.get(doctor).get(time).remove(patient);
    }

    @Override
    public Map<Doctor, Map<Time, List<Patient>>> findReservationByPatient(Patient patient) {
        Map<Doctor, Map<Time, List<Patient>>> allReservations = new HashMap<>();
        for (Map.Entry<Doctor, Map<Time, List<Patient>>> repositoryEntry : repository.entrySet()) {
            Map<Time, List<Patient>> schedule = new TreeMap<>();
            for (Map.Entry<Time, List<Patient>> scheduleEntry : repositoryEntry.getValue().entrySet()) {
                for (Patient patientFromRepository : scheduleEntry.getValue()) {
                    List<Patient> patientList = new ArrayList<>();
                    if (patientFromRepository.equals(patient)) {
                        patientList.add(patient);
                        schedule.put(scheduleEntry.getKey(), patientList);
                    }
                }
            }
            if (schedule.size() != 0) {
                allReservations.put(repositoryEntry.getKey(), schedule);
            }
        }
        return allReservations;
    }

    @Override
    public Map<Doctor, Map<Time, List<Patient>>> findAllReservations() {
        Map<Doctor, Map<Time, List<Patient>>> allReservations = new HashMap<>();
        for (Map.Entry<Doctor, Map<Time, List<Patient>>> repositoryEntry : repository.entrySet()) {
            Map<Time, List<Patient>> schedule = new TreeMap<>();
            for (Map.Entry<Time, List<Patient>> scheduleEntry : repositoryEntry.getValue().entrySet()) {
                if (!scheduleEntry.getValue().isEmpty()) {
                    schedule.put(scheduleEntry.getKey(), scheduleEntry.getValue());
                }
            }
            if (schedule.size() != 0) {
                allReservations.put(repositoryEntry.getKey(), schedule);
            }
        }
        return allReservations;
    }

    public void initialize(List<Doctor> doctors) {
        if (repository.size() == 0) {
            addDoctorListToRepository(doctors);
        }
    }

    private void addDoctorListToRepository(List<Doctor> doctors) {
        for (Doctor doctor : doctors) {
            repository.put(doctor, new TreeMap<Time, List<Patient>>()); // создаем на каждого врача отдельную мапу
            addScheduleAllTimeValues(doctor); // она хранит время Enum и ArrayList с размером 2
        }
    }

    private void addScheduleAllTimeValues(Doctor doctor) {   // инициализация мапы time-patient
        Map<Time, List<Patient>> schedule = repository.get(doctor);
        schedule.put(Time.TEN, new ArrayList<>(2));
        schedule.put(Time.ELEVEN, new ArrayList<>(2));
        schedule.put(Time.FORTEEN, new ArrayList<>(2));
        schedule.put(Time.FIFTEEN, new ArrayList<>(2));
    }

    private void book(Doctor doctor, Time time, Patient patient) {
        List<Patient> patientList = repository.get(doctor).get(time);
        patientList.add(patient);
        TreeMap<Time, List<Patient>> scheduleForTime = new TreeMap<>(repository.get(doctor));
        scheduleForTime.put(time, patientList);
        repository.put(doctor, scheduleForTime);
    }

    private Time chooseNextTime(Time time) {
        switch (time) {
            case TEN:
                time = Time.ELEVEN;
                break;
            case ELEVEN:
                time = Time.FORTEEN;
                break;
            case FORTEEN:
                time = Time.FIFTEEN;
                break;
            case FIFTEEN:
                throw new DoctorHasntAvailableTimeException("Doctor hasn't available time at " + time.getTime());
        }
        return time;
    }

    private boolean isDoctorBusy(Doctor doctor, Time time) {
        return repository.get(doctor).get(time).size() == 2;
    }

    private boolean isDoctorHasFreeTime(Doctor doctor, Time time) {
        return repository.get(doctor).get(time).size() < 2;
    }
}
