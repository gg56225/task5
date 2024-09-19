package model;

public abstract class User {

    public User(String firstName, String lastName, String middlename) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middlename = middlename;
    }

    private String firstName;
    private String lastName;
    private String middlename;

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

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }
}
