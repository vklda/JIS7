package homework.collections.hospital.service;

import homework.collections.hospital.exceptions.DoctorHasntAvailableTimeException;
import homework.collections.hospital.exceptions.PatientDontPaidException;
import homework.collections.hospital.exceptions.ReservationNotFoundException;
import homework.collections.hospital.model.Doctor;
import homework.collections.hospital.model.Patient;
import homework.collections.hospital.model.Time;

import java.util.*;

import static homework.collections.hospital.repository.HospitalRepository.repository;

public class HospitalServiceImpl implements HospitalService<Doctor, Patient, Time> {
    private final static Integer ZERO = Integer.valueOf(0);
    private final static Integer TWO = Integer.valueOf(2);

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
        var counter = 0;
        var allReservations = new HashMap<Doctor, Map<Time, List<Patient>>>();
        for (Map.Entry<Doctor, Map<Time, List<Patient>>> repositoryEntry : repository.entrySet()) {
            var schedule = new TreeMap<Time, List<Patient>>();
            for (Map.Entry<Time, List<Patient>> scheduleEntry : repositoryEntry.getValue().entrySet()) {
                for (Patient patientFromRepository : scheduleEntry.getValue()) {
                    var patientList = new ArrayList<Patient>();
                    if (patientFromRepository.equals(patient)) {
                        patientList.add(patient);
                        schedule.put(scheduleEntry.getKey(), patientList);
                        counter++;
                    }
                }
            }
            if (schedule.size() != ZERO) {
                allReservations.put(repositoryEntry.getKey(), schedule);
            }
        }
        if (counter == ZERO) {
            throw new ReservationNotFoundException("Reservation by patient '" + patient.getSecondName() + "' not found");
        }
        return allReservations;
    }

    @Override
    public Map<Doctor, Map<Time, List<Patient>>> findAllReservations() {
        var allReservations = new HashMap<Doctor, Map<Time, List<Patient>>>();
        for (Map.Entry<Doctor, Map<Time, List<Patient>>> repositoryEntry : repository.entrySet()) {
            var schedule = new TreeMap<Time, List<Patient>>();
            for (Map.Entry<Time, List<Patient>> scheduleEntry : repositoryEntry.getValue().entrySet()) {
                if (!scheduleEntry.getValue().isEmpty()) {
                    schedule.put(scheduleEntry.getKey(), scheduleEntry.getValue());
                }
            }
            if (schedule.size() != ZERO) {
                allReservations.put(repositoryEntry.getKey(), schedule);
            }
        }
        return allReservations;
    }

    public static void clear() {
        repository.clear();
    }

    public void initialize(List<Doctor> doctors) {
        if (repository.size() == ZERO) {
            addDoctorListToRepository(doctors);
        }
    }

    private void addDoctorListToRepository(List<Doctor> doctors) {
        for (Doctor doctor : doctors) {
            repository.put(doctor, new TreeMap<>());
            addScheduleAllTimeValues(doctor);
        }
    }

    private void addScheduleAllTimeValues(Doctor doctor) {
        var schedule = repository.get(doctor);
        schedule.put(Time.TEN, new ArrayList<>(2));
        schedule.put(Time.ELEVEN, new ArrayList<>(2));
        schedule.put(Time.FORTEEN, new ArrayList<>(2));
        schedule.put(Time.FIFTEEN, new ArrayList<>(2));
    }

    private void book(Doctor doctor, Time time, Patient patient) {
        var patientList = repository.get(doctor).get(time);
        patientList.add(patient);
        var scheduleForTime = new TreeMap<>(repository.get(doctor));
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
        return repository.get(doctor).get(time).size() == TWO;
    }

    private boolean isDoctorHasFreeTime(Doctor doctor, Time time) {
        return repository.get(doctor).get(time).size() < TWO;
    }
}
