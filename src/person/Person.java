package person;

public abstract class Person {
    protected String DNI;
    protected String name;
    protected String surname;
    protected String cellphone;

    protected int age;

    public Person(String DNI, String name, String surname, String cellphone, int age) {
        this.DNI = DNI;
        this.name = name;
        this.surname = surname;
        this.cellphone = cellphone;
        this.age = age;
    }

    public void setAge(int age) {
        if (age >= 18) {
            this.age = age;
        }
        // TODO: What if age is < 18?
    }


}
