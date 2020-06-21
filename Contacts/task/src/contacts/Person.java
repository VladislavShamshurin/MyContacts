package contacts;

import java.io.IOException;
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

    @Override
    public void editContact() throws IOException {
        System.out.println("Select a field (name, surname, birth, gender, number): ");
        String field = MainLogic.bufferedReader.readLine();
        //@field edit name, surname, number.@
        switch (field.toLowerCase()) {
            case "name":
                System.out.println("Enter name: ");
                String newName = MainLogic.bufferedReader.readLine();
                setName(newName);
                System.out.println("The record updated!");
                System.out.println();
                setLastEdit(LocalDateTime.now());
                break;
            case "surname":
                System.out.println("Enter surname: ");
                String newSurname = MainLogic.bufferedReader.readLine();
                setSurname(newSurname);
                System.out.println("The record updated!");
                System.out.println();
                setLastEdit(LocalDateTime.now());
                break;
            case "number":
                System.out.println("Enter number: ");
                String newNumber = MainLogic.bufferedReader.readLine();
                setPhoneNumber(newNumber);
                System.out.println("The record updated!");
                System.out.println();
                setLastEdit(LocalDateTime.now());
                break;
            case "birth":
                System.out.println("Enter birth: ");
                String newBirth = MainLogic.bufferedReader.readLine();
                if (newBirth.equals("") || newBirth.length() < 9) {
                    System.out.println("Bad birth date!");
                    newBirth = "1000-10-10";
                }
                setBirthday(newBirth);
                System.out.println("The record updated!");
                System.out.println();
                setLastEdit(LocalDateTime.now());
                break;
            case "gender":
                System.out.println("Enter gender: ");
                String newGender = MainLogic.bufferedReader.readLine().toUpperCase();
                if (!newGender.equals("M") && !newGender.equals("F")) {
                    System.out.println("Bad gender!");
                    newGender = "[no data]";
                }
                setGender(newGender);
                System.out.println("The record updated!");
                System.out.println();
                setLastEdit(LocalDateTime.now());
                break;
        }
    }

    @Override
    public void showInfo() {
        System.out.println("Name: " + getName());
        System.out.println("Surname: " + getSurname());
        if (birthday.toString().equals("1000-10-10")) {
            System.out.println("Birth date: [no data]");
        } else {
            System.out.println("Birth date: " + birthday);
        }
        System.out.println("Gender: " + getGender());
        System.out.println("Number: " + getPhoneNumber());
        System.out.println("Time created: " + getCreateDate());
        System.out.println("Time last edit: " + getLastEdit() + "\n");
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
