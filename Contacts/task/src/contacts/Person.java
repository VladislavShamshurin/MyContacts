package contacts;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Person extends Contact {
    private String surname;
    private String gender;
    public LocalDate birthday;
    public LocalDateTime createDate;
    public LocalDateTime lastEdit;

    public Person(String phoneNumber, String name, String surname, String date, String gender) {
        super(phoneNumber, name);
        createDate = LocalDateTime.now();
        lastEdit = createDate;
        birthday = LocalDate.parse(date);
        this.surname = surname;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(String date) {
        this.birthday = LocalDate.parse(date);
    }

    public LocalDateTime getLastEdit() {
        return lastEdit;
    }

    public void setLastEdit(LocalDateTime lastEdit) {
        this.lastEdit = lastEdit;
    }
}
