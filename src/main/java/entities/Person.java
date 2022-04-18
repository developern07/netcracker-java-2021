package entities;

import helpers.Gender;
import xml.LocalDateAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.time.Year;

/**
 * Owner model
 */
@XmlRootElement
public class Person {

    /**
     * ID of human
     */
    protected int id;

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * human name
     */
    protected String name;

    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * date of birthday
     */
    protected LocalDate dateOfBirthday;

    @XmlElement
    @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
    public LocalDate getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setDateOfBirthday(LocalDate dateOfBirthday) {
        this.dateOfBirthday = dateOfBirthday;
    }

    /**
     * human gender
     */
    protected Gender gender;

    @XmlElement
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * series and number of passport
     */
    protected String snPassport;

    @XmlElement
    public String getSnPassport() {
        return snPassport;
    }

    public void setSnPassport(String snPassport) {
        this.snPassport = snPassport;
    }

    /**
     * Method of getting human age
     * @return
     */
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

    public Person() {
    }
}
