package homework.collections.hospital.model;

public enum DoctorTypes {
    THERAPIST("терапевт"),
    OTOLARYNGOLOGIST("лор"),
    NEUROLOGIS("невролог"),
    SURGEON("хирург");

    String type;

    DoctorTypes(String type) {
        this.type = type;
    }

    public String getDoctorType() {
        return type;
    }
}
