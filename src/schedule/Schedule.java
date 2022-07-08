package schedule;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Schedule {

    LocalTime initialHour;
    LocalTime endHour;
    DayOfWeek weekDay;

    public Schedule(String initialHourString, String endHourString, int weekDay) {
        this.initialHour = LocalTime.parse(initialHourString);
        this.endHour = LocalTime.parse(endHourString);
        this.weekDay = DayOfWeek.of(weekDay); //TODO: it may be necessary to call enum.toString

    }

    public String formatSchedule() {
        // TODO: toString() methods on LocalTime objects might return odd formatting.
        return String.format("From %s to %s, on %s", initialHour.toString(), endHour.toString(), weekDay.name());
    }


}
