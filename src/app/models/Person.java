package app.models;

public class Person {

    private Long id;

    private String firstName = "";
    private String lastName = "";
    private String address = "";
    private String personalIdentificationNumber = "";
    private String nationality = "";
    private String motherTongue = "";
    private String familyRelationshipInformation = "";

    // Tehtävää varten päivämäärät ovat String tyyppiä, oikeassa projektissa esim Date tyyppi olisi parempi.
    private String birthDate = "";
    private String deathDate = "";

    public Person() {
    }

    public Person(Long id, String firstName, String lastName, String address, String personalIdentificationNumber, String nationality, String motherTongue, String familyRelationshipInformation, String birthDate, String deathDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.personalIdentificationNumber = personalIdentificationNumber;
        this.nationality = nationality;
        this.motherTongue = motherTongue;
        this.familyRelationshipInformation = familyRelationshipInformation;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPersonalIdentificationNumber() {
        return personalIdentificationNumber;
    }

    public void setPersonalIdentificationNumber(String personalIdentificationNumber) {
        this.personalIdentificationNumber = personalIdentificationNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMotherTongue() {
        return motherTongue;
    }

    public void setMotherTongue(String motherTongue) {
        this.motherTongue = motherTongue;
    }

    public String getFamilyRelationshipInformation() {
        return familyRelationshipInformation;
    }

    public void setFamilyRelationshipInformation(String familyRelationshipInformation) {
        this.familyRelationshipInformation = familyRelationshipInformation;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(String deathDate) {
        this.deathDate = deathDate;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return id.equals(person.id) || personalIdentificationNumber.equals(person.personalIdentificationNumber);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + personalIdentificationNumber.hashCode();
        result = 31 * result + nationality.hashCode();
        result = 31 * result + motherTongue.hashCode();
        result = 31 * result + familyRelationshipInformation.hashCode();
        result = 31 * result + birthDate.hashCode();
        result = 31 * result + deathDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", personalIdentificationNumber='" + personalIdentificationNumber + '\'' +
                ", nationality='" + nationality + '\'' +
                ", motherTongue='" + motherTongue + '\'' +
                ", familyRelationshipInformation='" + familyRelationshipInformation + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", deathDate='" + deathDate + '\'' +
                '}';
    }
}
