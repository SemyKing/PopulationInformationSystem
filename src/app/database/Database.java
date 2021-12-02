package app.database;

import app.models.Person;
import java.util.ArrayList;

public class Database {

    private static long idCounter = 0;
    private ArrayList<Person> personArrayList;

    private static Database instance;

    private Database() {
        personArrayList = new ArrayList<>();

        generateDummyData();
    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    private void generateDummyData() {
        for (int i = 1; i < 6; i++) {
            Person person = new Person();
            person.setId(createID());
            person.setFirstName(i + "_first_name");
            person.setLastName(i + "_last_name");
            person.setAddress(i + "_address");
            person.setPersonalIdentificationNumber(i + "_personal_identification_number");
            person.setNationality(i + "_nationality");
            person.setMotherTongue(i + "_mother_tongue");
            person.setFamilyRelationshipInformation(i + "_family_relationship_information");
            person.setBirthDate(i + "_birth_date");
            person.setDeathDate(i + "_death_date");

            personArrayList.add(person);
        }
    }

    public void resetDatabase() {
        personArrayList.clear();
        idCounter = 0;
        generateDummyData();

    }


    public static synchronized long createID() {
        return idCounter++;
    }

    public ArrayList<Person> getPersonArrayList() {
        return personArrayList;
    }

    public Person getById(Long id) {
        if (id == null) {
            return null;
        }

        for (Person person : personArrayList) {
            if (person.getId().equals(id)) {
                return person;
            }
        }

        return null;
    }

    public boolean deleteById(Long id) {
        if (id == null) {
            return false;
        }

        personArrayList.removeIf(person -> person.getId().equals(id));

        return true;
    }
}