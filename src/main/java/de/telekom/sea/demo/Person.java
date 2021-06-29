package de.telekom.sea.demo;

public class Person {

    private int ID;
    private String salutation;
    private String name;
    private String surname;
    private String email;
    private String birthdate;



    public Person(int ID, String salutation,String name, String surname, String email,String birthdate) {
        this.ID = ID;
        this.salutation = salutation;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthdate = birthdate;

    }



    public Person() {
    }



    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }


    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }


}
