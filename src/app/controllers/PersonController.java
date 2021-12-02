package app.controllers;

import app.database.Database;
import app.models.Person;

public class PersonController {

    private Database database;

    public PersonController() {
        database = Database.getInstance();
    }


    /**
     * Lisätään uutta henkilöä tietokantaan
     * @param firstName
     * @param lastName
     * @param address
     * @param personalIdentificationNumber
     * @param nationality
     * @param motherTongue
     * @param familyRelationshipInformation
     * @param birthDate
     * @param deathDate
     * @return false jos tietokannasta löytyy henkilö samalla id:llä tai henkilötunnuksella, true jos kaikki ok.
     */
    public boolean addPerson(String firstName, String lastName, String address, String personalIdentificationNumber, String nationality, String motherTongue, String familyRelationshipInformation, String birthDate, String deathDate) {

        Person newPerson = new Person();
        newPerson.setId(Database.createID());
        newPerson.setFirstName(firstName);
        newPerson.setLastName(lastName);
        newPerson.setAddress(address);
        newPerson.setPersonalIdentificationNumber(personalIdentificationNumber);
        newPerson.setNationality(nationality);
        newPerson.setMotherTongue(motherTongue);
        newPerson.setFamilyRelationshipInformation(familyRelationshipInformation);
        newPerson.setBirthDate(birthDate);
        newPerson.setDeathDate(deathDate);

        for (Person person : database.getPersonArrayList()) {
            if (person.equals(newPerson)) {
                return false; // Henkilö samalla id:llä tai henkilötunnuksella on jo tietokannassa.
            }
        }

        database.getPersonArrayList().add(newPerson);

        return true;
    }

    /**
     * Haetaan henkilöä tietokannasta henkilötunnuksen avulla
     * @param personalIdentificationNumber henkilötunnus
     * @return Person-objekti jos henkilötunnus löytyy, muuten null
     */
    public Person getPersonByPersonalIdentificationNumber(String personalIdentificationNumber) {

        for (Person person : database.getPersonArrayList()) {
            if (person.getPersonalIdentificationNumber().equals(personalIdentificationNumber)) {
                return person;
            }
        }

        return null;
    }

    /**
     * Päivitetään oleamassaolevan henkilön tiedot
     * @param id
     * @param firstName
     * @param lastName
     * @param address
     * @param personalIdentificationNumber
     * @param nationality
     * @param motherTongue
     * @param familyRelationshipInformation
     * @param birthDate
     * @param deathDate
     * @return false jos id:tä ei annettu tai henkilöä ei löydy, muuten true
     */
    public boolean updatePerson(Long id, String firstName, String lastName, String address, String personalIdentificationNumber, String nationality, String motherTongue, String familyRelationshipInformation, String birthDate, String deathDate) {

        if (id == null) {
            return false;
        }

        Person personFromDatabase = database.getById(id);

        if (personFromDatabase == null) {
            return false;
        }

        //Ennen tätä toki tiedon validointi.

        personFromDatabase.setFirstName(firstName);
        personFromDatabase.setLastName(lastName);
        personFromDatabase.setAddress(address);
        personFromDatabase.setPersonalIdentificationNumber(personalIdentificationNumber);
        personFromDatabase.setNationality(nationality);
        personFromDatabase.setMotherTongue(motherTongue);
        personFromDatabase.setFamilyRelationshipInformation(familyRelationshipInformation);
        personFromDatabase.setBirthDate(birthDate);
        personFromDatabase.setDeathDate(deathDate);

        database.deleteById(id);
        database.getPersonArrayList().add(personFromDatabase);

        return true;
    }

    /**
     * Poistetaan henkilö tietokannasta id:n avulla
     * @param id
     * @return false jos id:tä ei annettu, muuten true
     */
    public boolean deletePerson(Long id) {

        if (id == null) {
            return false;
        }

        return database.deleteById(id);
    }

}
