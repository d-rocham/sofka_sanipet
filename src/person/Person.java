package person;

public abstract class Person {
    String DNI;
    String name;
    String surname;
    String cellphone;
    int age;

    public Person(String DNI, String name, String surname, String cellphone, int age) {
        this.DNI = DNI;
        this.name = name;
        this.surname = surname;
        this.cellphone = cellphone;
        this.age = age;
    }

    // TODO: build constructor
}
