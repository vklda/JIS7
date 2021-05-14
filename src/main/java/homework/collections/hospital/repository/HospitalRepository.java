package homework.collections.hospital.repository;

import homework.collections.hospital.model.Doctor;
import homework.collections.hospital.model.Patient;
import homework.collections.hospital.model.Time;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HospitalRepository {
    public static final Map<Doctor, Map<Time, List<Patient>>> repository = new HashMap();
}
