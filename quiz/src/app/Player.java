package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Person {

    int myScore;
    int myPlayed_Games;
    ArrayList<Player> myPlayerList = new ArrayList<>();


    Player(){
    }

    Player(String newName, int newAge, String newMail) {
        super(newName, newAge, newMail);
    }



    @Override
    public void addPerson() throws IOException {
        Scanner myScan = new Scanner(System.in);
        GameManager myGM = new GameManager();

        System.out.println("Player info\nName: ");
        String aName = myScan.nextLine();
        name = aName;

        System.out.println("Age: ");
        int aAge = myScan.nextInt();
        age = aAge;

        System.out.println("Mail: ");
        String aMail = myScan.next();
        mail = aMail;

        myPlayerList.add(new Player(aName, aAge, aMail));
        // Få in i filen Users.md för att spara players plus möjligheten att redigera listan (Edit, delete, sort, add?)

        if (aAge >= 0) {
            System.out.println("Welcome " + aName);
            myGM.playOption();
        } else {
            System.out.println( aAge + " cant be an correct age, try again!");
        }
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getMail() {
        return mail;
    }
    public int getScore() {
        return myScore;
    }
    public int getPlayed_Games() {
        return myPlayed_Games;
    }
}
