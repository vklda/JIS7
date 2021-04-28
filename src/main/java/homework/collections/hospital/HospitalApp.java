package homework.collections.hospital;

import homework.collections.hospital.model.Doctor;
import homework.collections.hospital.model.DoctorTypes;
import homework.collections.hospital.model.Patient;
import homework.collections.hospital.model.Time;
import homework.collections.hospital.repository.HospitalRepositoryImpl;
import homework.collections.hospital.service.HospitalService;

import java.util.*;

public class HospitalApp {
    public static void main(String[] args) {
        HospitalService hospitalService = new HospitalService(new HospitalRepositoryImpl());
        List<Doctor> doctorList = new ArrayList<Doctor>();
        List<Patient> patientList = new ArrayList<>();
        doctorList.add(new Doctor("Петр", "Иванов", DoctorTypes.NEUROLOGIS));
        doctorList.add(new Doctor("Дмитрий", "Костоправов", DoctorTypes.SURGEON));
        doctorList.add(new Doctor("Максим", "Быковский", DoctorTypes.OTOLARYNGOLOGIST));
        doctorList.add(new Doctor("Ирина", "Соболева", DoctorTypes.THERAPIST));

        patientList.add(new Patient("Дмитрий", "Козлов", 15, true));
        patientList.add(new Patient("Афанасий", "Петров", 17, true));
        patientList.add(new Patient("Артем", "Петров", 17, true));
        patientList.add(new Patient("фыв", "Петров", 17, true));
        hospitalService.initialize(doctorList);

        hospitalService.reservate(doctorList.get(0), Time.ELEVEN, patientList.get(0));
        hospitalService.reservate(doctorList.get(0), Time.ELEVEN, patientList.get(1));
        hospitalService.reservate(doctorList.get(0), Time.FIFTEEN, patientList.get(2));
        hospitalService.reservate(doctorList.get(0), Time.FIFTEEN, patientList.get(3));
        System.out.println(hospitalService.findAllReservations());
        System.out.println(hospitalService.findReservationByPatient(patientList.get(0)));
    }
}
