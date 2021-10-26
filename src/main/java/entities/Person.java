package entities;

import helpers.Gender;

import java.time.LocalDate;
import java.time.Year;

public class Person {

    protected int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected LocalDate dateOfBirthday;

    public LocalDate getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(LocalDate dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    protected Gender gender;

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    protected String snPassport;

    public String getSnPassport() {
        return snPassport;
    }

    public void setSnPassport(String snPassport) {
        this.snPassport = snPassport;
    }

    public int getAge(){
        return Year.now().getValue() - getDateOfBirthday().getYear();
    }

    public Person(int id, String name, LocalDate dateOfBirthday, Gender gender, String snPassport) {
        setId(id);
        setName(name);
        setDateOfBirthday(dateOfBirthday);
        setGender(gender);
        setSnPassport(snPassport);
    }
}
