package homework.collections.hospital.model;

public enum Time {
    TEN("10:00"),
    ELEVEN("11:00"),
    FORTEEN("14:00"),
    FIFTEEN("15:00");

    String time;

    Time(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

}
