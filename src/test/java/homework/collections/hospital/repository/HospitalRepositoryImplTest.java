package homework.collections.hospital.repository;

import homework.collections.hospital.exceptions.DoctorHasntAvailableTimeException;
import homework.collections.hospital.exceptions.PatientDontPaidException;
import homework.collections.hospital.model.Doctor;
import homework.collections.hospital.model.DoctorTypes;
import homework.collections.hospital.model.Patient;
import homework.collections.hospital.model.Time;
import homework.collections.hospital.service.HospitalService;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HospitalRepositoryImplTest {
    private static final Logger logger = Logger.getLogger(HospitalRepositoryImplTest.class);

    HospitalService hospitalService;
    List<Doctor> doctorList;

    @BeforeEach
    void setUp() {
        hospitalService = new HospitalService(new HospitalRepositoryImpl());
        doctorList = new ArrayList<Doctor>();
        doctorList.add(new Doctor("Петр", "Иванов", DoctorTypes.NEUROLOGIS));
        doctorList.add(new Doctor("Дмитрий", "Костоправов", DoctorTypes.SURGEON));
        doctorList.add(new Doctor("Максим", "Быковский", DoctorTypes.OTOLARYNGOLOGIST));
        doctorList.add(new Doctor("Ирина", "Соболева", DoctorTypes.THERAPIST));

        hospitalService.initialize(doctorList);
    }

    @AfterEach
    void clean() {
        HospitalRepositoryImpl.clear();
    }


    @Test
    void reservatePaidPatient() {
        hospitalService.reservate(doctorList.get(0), Time.ELEVEN,
                new Patient("Дмитрий", "Козлов", 15, true));
        hospitalService.reservate(doctorList.get(0), Time.ELEVEN,
                new Patient("Афанасий", "Петров", 17, true));
        hospitalService.reservate(doctorList.get(0), Time.FIFTEEN,
                new Patient("Артем", "Петров", 17, true));
        Assert.assertEquals(3, hospitalService.findAllReservations().get(doctorList.get(0)).get(Time.ELEVEN).size() +
                hospitalService.findAllReservations().get(doctorList.get(0)).get(Time.FIFTEEN).size());
    }

    @Test
    void reservateUnpaidPatientShouldThrowException() {
        hospitalService.reservate(doctorList.get(0), Time.ELEVEN,
                new Patient("Дмитрий", "Козлов", 15, true));
        hospitalService.reservate(doctorList.get(0), Time.ELEVEN,
                new Patient("Афанасий", "Петров", 17, true));
        assertThrows(PatientDontPaidException.class, () -> {
            hospitalService.reservate(doctorList.get(0), Time.FIFTEEN,
                    new Patient("Артем", "Петров", 17, false));
        });
    }

    @Test
    void reservateForNotAvailableTimeThrownException() {
        hospitalService.reservate(doctorList.get(0), Time.FIFTEEN,
                new Patient("Дмитрий", "Козлов", 15, true));
        hospitalService.reservate(doctorList.get(0), Time.FIFTEEN,
                new Patient("Афанасий", "Петров", 17, true));
        assertThrows(DoctorHasntAvailableTimeException.class, () -> {
            hospitalService.reservate(doctorList.get(0), Time.FIFTEEN,
                    new Patient("Артем", "Петров", 17, true));
        });
    }

    @Test
    void cancelReservationPositive() {
        hospitalService.reservate(doctorList.get(0), Time.ELEVEN,
                new Patient("Дмитрий", "Козлов", 15, true));
        hospitalService.reservate(doctorList.get(0), Time.ELEVEN,
                new Patient("Афанасий", "Петров", 17, true));

        Patient patient = new Patient("Артем", "Петров", 17, true);
        hospitalService.reservate(doctorList.get(0), Time.FIFTEEN, patient);
        hospitalService.cancelReservation(doctorList.get(0), Time.FIFTEEN, patient);

        Assert.assertEquals(2, hospitalService.findAllReservations().get(doctorList.get(0)).get(Time.ELEVEN).size());
    }

    @Test
    void findReservationByPatientPositive() {
        Patient patient = new Patient("Артем", "Петров", 17, true);
        hospitalService.reservate(doctorList.get(0), Time.ELEVEN,
                new Patient("Дмитрий", "Козлов", 15, true));
        hospitalService.reservate(doctorList.get(0), Time.ELEVEN,
                new Patient("Афанасий", "Петров", 17, true));
        hospitalService.reservate(doctorList.get(0), Time.FIFTEEN, patient);
        var map = hospitalService.findReservationByPatient(patient);
        for (Map.Entry<Doctor, Map<Time, List<Patient>>> entry : map.entrySet()) {
            for (Map.Entry<Time, List<Patient>> schedule : entry.getValue().entrySet()) {
                for (Patient patientFromMap : schedule.getValue()) {
                    Assertions.assertEquals(patient, patientFromMap);
                }
            }
        }
    }

    @Test
    void findAllReservations() {
    }
}