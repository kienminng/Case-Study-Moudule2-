package Person;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Person implements Serializable {
    private String name;

    private String pass;
    private String account;
    private LocalDate date;
    private String gender;

    public Person() {
    }

    public Person(String name, String account,String pass, LocalDate date, String gender) {
        this.name = name;
        this.account = account;
        this.pass =pass;
        this.date = date;
        this.gender = gender;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return name + " " + account + " "+pass+ " " + date +" " + gender+"\n";
    }
}
