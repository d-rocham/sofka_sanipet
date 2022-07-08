package person;

import schedule.Schedule;

import java.util.ArrayList;
import java.util.List;

public abstract class Employee extends Person {

    List<Schedule> employeeSchedule;

    public Employee(String DNI, String name, String surname, String cellphone, int age) {
        super(DNI, name, surname, cellphone, age);

        this.employeeSchedule = new ArrayList<>();

    }

    public List<Schedule> getEmployeeSchedule() {
        employeeSchedule.forEach((element) -> System.out.println(element.formatSchedule()));

        return employeeSchedule;
    }

    public void setEmployeeSchedule(Schedule newSchedule) {
        this.employeeSchedule.add(newSchedule);
    }

}
