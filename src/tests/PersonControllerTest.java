package tests;

import app.controllers.PersonController;
import app.database.Database;
import app.models.Person;
import org.junit.jupiter.api.*;

class PersonControllerTest {

    @BeforeEach
    void resetDatabase() {
        Database.getInstance().resetDatabase();

        System.out.println("Database before:");
        for (Person person : Database.getInstance().getPersonArrayList()) {
            System.out.println(person.toString());
        }
        System.out.println("-----");
    }

    @AfterEach
    void printDatabase() {
        System.out.println("Database after:");
        for (Person person : Database.getInstance().getPersonArrayList()) {
            System.out.println(person.toString());
        }
        System.out.println("-----");
    }

    @Test
    void addPerson() {
        PersonController personController = new PersonController();

        int initialPersonCount = Database.getInstance().getPersonArrayList().size();

        personController.addPerson("newFirstName",
                "newLastName",
                "newAddress",
                "newPID",
                "newNationality",
                "newMotherTongue",
                "newFamilyRelationshipInformation",
                "newBirthDate",
                "newDeathDate");

        Assertions.assertEquals(initialPersonCount + 1, Database.getInstance().getPersonArrayList().size());
    }

    @Test
    void addPersonFail() {
        PersonController personController = new PersonController();

        int initialPersonCount = Database.getInstance().getPersonArrayList().size();

        personController.addPerson("newFirstName",
                "newLastName",
                "newAddress",
                "1_personal_identification_number", // oleamassa oleva henkilötunnus
                "newNationality",
                "newMotherTongue",
                "newFamilyRelationshipInformation",
                "newBirthDate",
                "newDeathDate");

        Assertions.assertEquals(initialPersonCount, Database.getInstance().getPersonArrayList().size());
    }

    @Test
    void getPersonByPersonalIdentificationNumber() {
        PersonController personController = new PersonController();

        Person personFromDatabase = personController.getPersonByPersonalIdentificationNumber("1_personal_identification_number");

        Assertions.assertEquals(0, personFromDatabase.getId());
    }

    @Test
    void getPersonByPersonalIdentificationNumberFail() {
        PersonController personController = new PersonController();

        Person personFromDatabase = personController.getPersonByPersonalIdentificationNumber("non_existent_personal_identification_number");

        Assertions.assertNull(personFromDatabase);
    }

    @Test
    void updatePerson() {
        PersonController personController = new PersonController();

        personController.updatePerson(0L,
                "newFirstName",
                "newLastName",
                "newAddress",
                "newPID",
                "newNationality",
                "newMotherTongue",
                "newFamilyRelationshipInformation",
                "newBirthDate",
                "newDeathDate");

        Person personFromDatabase = personController.getPersonByPersonalIdentificationNumber("newPID");

        Assertions.assertEquals(0, personFromDatabase.getId());
    }

    @Test
    void updatePersonFail() {
        PersonController personController = new PersonController();

        personController.updatePerson(null,
                "newFirstName",
                "newLastName",
                "newAddress",
                "newPID",
                "newNationality",
                "newMotherTongue",
                "newFamilyRelationshipInformation",
                "newBirthDate",
                "newDeathDate");

        Person personFromDatabase = personController.getPersonByPersonalIdentificationNumber("newPID");

        Assertions.assertNull(personFromDatabase);
    }

    @Test
    void deletePerson() {
        PersonController personController = new PersonController();

        int initialPersonCount = Database.getInstance().getPersonArrayList().size();

        personController.deletePerson(0L);

        Assertions.assertEquals(initialPersonCount - 1, Database.getInstance().getPersonArrayList().size());
    }

    @Test
    void deletePersonFail() {
        PersonController personController = new PersonController();

        int initialPersonCount = Database.getInstance().getPersonArrayList().size();

        personController.deletePerson(999L);

        Assertions.assertEquals(initialPersonCount, Database.getInstance().getPersonArrayList().size());
    }
}