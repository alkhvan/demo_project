package de.telekom.sea.demo;

import javax.persistence.*;

@Entity
@Table (name="persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    @Column
    private String salutation;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String email;
    @Column
    private String birthdate;



    public Person(Long ID,String name, String surname, String salutation, String email,String birthdate) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.salutation = salutation;
        this.email = email;
        this.birthdate = birthdate;

    }



    public Person() {
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

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
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

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

}
