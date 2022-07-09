package patient;

import java.util.Arrays;
import java.util.List;

public class Appointment {
    public String type;
    public String status;
    public String day;
    public String hour;

    public String appointmentName;

    public Appointment(String type, String status, String day, String hour, String appointmentName) {
        this.type = type;
        this.status = status;
        this.day = day;
        this.hour = hour;
        this.appointmentName = appointmentName;
    }


}
