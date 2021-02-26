package App;

public abstract class Person {

    private String name;
    private int age;
    private String mail;

    Person (String newName, int newAge, String newMail){
        this.name = newName;
        this.age = newAge;
        this.mail = newMail;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public String getMail(){
        return this.mail;
    }
}