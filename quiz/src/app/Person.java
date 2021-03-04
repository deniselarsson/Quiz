
package app;

import java.io.IOException;

public abstract class Person {

    /* protected variables name, age and mail */
    protected String name;
    protected int age;
    protected String mail;

    /* Empty constructor for overloading the constructor above */
    Person(){}

    /* Constructor demanding a name, age and mail */
    Person (String newName, int newAge, String newMail){
        this.name = newName;
        this.age = newAge;
        this.mail = newMail;
    }

    /* Method for adding a new user as a Person with a name, age and mail */
    public void addPerson() throws IOException {}
}
