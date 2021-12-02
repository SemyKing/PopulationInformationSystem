package app;

import app.database.Database;
import app.models.Person;

public class Main {

    public static void main(String[] args) {
        Database database = Database.getInstance();

        System.out.println("Tietokannassa olevat henkilöt:");

        for (Person person : database.getPersonArrayList()) {
            System.out.println(person.toString());
        }
    }
}
