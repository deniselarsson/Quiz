import java.io.IOException;

public abstract class Person {

    protected String name;
    protected int age;
    protected String mail;

    Person (String newName, int newAge, String newMail){
        this.name = newName;
        this.age = newAge;
        this.mail = newMail;
    }
    Person(){}

    public void addPerson() throws IOException {}

}