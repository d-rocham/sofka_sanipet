package patient;

import java.time.LocalDateTime;

public class Appointment {
    AppointmentType type;
    AppointmentStatus status;
    LocalDateTime datetime;

    public Appointment(AppointmentType type, String datetime) {
        this.type = type;
        this.status = AppointmentStatus.NOT_STARTED;
        this.datetime = LocalDateTime.parse(datetime);
    }
}
