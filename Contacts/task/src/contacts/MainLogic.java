package contacts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MainLogic {
    public static final List<Contact> contacts = new ArrayList<>();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public void selectAction() {
        boolean isExit = false;
        while(!isExit) {
            try {
                System.out.println("Enter action (add, remove, edit, count, info, exit): ");
                String answer = bufferedReader.readLine();
                switch (answer.toLowerCase()) {
                    case "add":
                        addContact();
                        break;
                    case "remove":
                        if (contacts.size() != 0) {
                            showList(); removeContact();
                        } else
                            System.out.println("No records to remove!");
                        break;
                    case "edit":
                        if (contacts.size() != 0) {
                            showList(); editContact();
                        } else
                            System.out.println("No records to edit!");
                        break;
                    case "count":
                        System.out.println("The Phone Book has " + contacts.size() +  " records.");
                        break;
                    case "info":
                        info();
                        break;
                    case "exit":
                        isExit = true;
                        break;
                }
            } catch (IOException e) {
                e.getMessage();
            }
        }
        try {
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void info() throws IOException {
        showList();
        System.out.println("Enter index to show info: ");
        try {
            int index = Integer.parseInt(bufferedReader.readLine()) - 1;
            if (contacts.get(index).isPerson()) {
                Person person = (Person) contacts.get(index);
                System.out.println("Name: " + person.getName());
                System.out.println("Surname: " + person.getSurname());
                if (person.birthday.toString().equals("1000-10-10")) {
                    System.out.println("Birth date: [no data]");
                } else {
                    System.out.println("Birth date: " + person.birthday);
                }
                System.out.println("Gender: " + person.getGender());
                System.out.println("Number: " + person.getPhoneNumber());
                System.out.println("Time created: " + person.createDate);
                System.out.println("Time last edit: " + person.getLastEdit());
                System.out.println();
            } else {
                Organization organization = (Organization) contacts.get(index);
                System.out.println("Organization name: " + organization.getName());
                System.out.println("Address: " + organization.getAddress());
                System.out.println("Number: " + organization.getPhoneNumber());
                System.out.println("Time created: " + organization.createDate);
                System.out.println("Time last edit: " + organization.getLastEdit());
                System.out.println();
            }
        } catch (NumberFormatException e) {
            e.getMessage();
        }
    }

    public void editContact() throws IOException {
        System.out.println("Select a record: ");
        int choose1 = Integer.parseInt(bufferedReader.readLine()) - 1;
        if (contacts.get(choose1).isPerson()) {
            Person person = (Person) contacts.get(choose1);
            System.out.println("Select a field (name, surname, birth, gender, number): ");
            String field = bufferedReader.readLine();
            //@field edit name, surname, number.@
            switch (field.toLowerCase()) {
                case "name":
                    System.out.println("Enter name: ");
                    String newName = bufferedReader.readLine();
                    person.setName(newName);
                    System.out.println("The record updated!");
                    System.out.println();
                    person.setLastEdit(LocalDateTime.now());
                    break;
                case "surname":
                    System.out.println("Enter surname: ");
                    String newSurname = bufferedReader.readLine();
                    person.setSurname(newSurname);
                    System.out.println("The record updated!");
                    System.out.println();
                    person.setLastEdit(LocalDateTime.now());
                    break;
                case "number":
                    System.out.println("Enter number: ");
                    String newNumber = bufferedReader.readLine();
                    person.setPhoneNumber(newNumber);
                    System.out.println("The record updated!");
                    System.out.println();
                    person.setLastEdit(LocalDateTime.now());
                    break;
                case "birth":
                    System.out.println("Enter birth: ");
                    String newBirth = bufferedReader.readLine();
                    if (newBirth.equals("") || newBirth.length() < 9) {
                        System.out.println("Bad birth date!");
                        newBirth = "1000-10-10";
                    }
                    person.setBirthday(newBirth);
                    System.out.println("The record updated!");
                    System.out.println();
                    person.setLastEdit(LocalDateTime.now());
                    break;
                case "gender":
                    System.out.println("Enter gender: ");
                    String newGender = bufferedReader.readLine().toUpperCase();
                    if (!newGender.equals("M") && !newGender.equals("F")) {
                        System.out.println("Bad gender!");
                        newGender = "[no data]";
                    }
                    person.setGender(newGender);
                    System.out.println("The record updated!");
                    System.out.println();
                    person.setLastEdit(LocalDateTime.now());
                    break;
            }
        } else {
            Organization organization = (Organization) contacts.get(choose1);
            System.out.println("Select a field (name, address, number): ");
            String field = bufferedReader.readLine();
            switch (field.toLowerCase()) {
                case "name":
                    System.out.println("Enter name: ");
                    String newName = bufferedReader.readLine();
                    organization.setName(newName);
                    System.out.println("The record updated!");
                    System.out.println();
                    organization.setLastEdit(LocalDateTime.now());
                    break;
                case "address":
                    System.out.println("Enter address: ");
                    String newAddress = bufferedReader.readLine();
                    organization.setAddress(newAddress);
                    System.out.println("The record updated!");
                    System.out.println();
                    organization.setLastEdit(LocalDateTime.now());
                    break;
                case "number":
                    System.out.println("Enter number: ");
                    String newNumber = bufferedReader.readLine();
                    organization.setPhoneNumber(newNumber);
                    System.out.println("The record updated!");
                    System.out.println();
                    organization.setLastEdit(LocalDateTime.now());
                    break;
            }
        }
    }

    public void addContact() throws IOException {
        System.out.println("Enter the type (person, organization): ");
        String type = bufferedReader.readLine();
        switch (type.toLowerCase()) {
            case "person":
                System.out.println("Enter the name: ");
                    String perName = bufferedReader.readLine();
                System.out.println("Enter the surname: ");
                    String perSurname = bufferedReader.readLine();
                System.out.println("Enter the birth date: ");
                    String perDate = bufferedReader.readLine();
                    if (perDate.equals("") || perDate.length() < 9) {
                        System.out.println("Bad birth date!");
                        perDate = "1000-10-10";
                    }
                System.out.println("Enter the gender (M, F): ");
                    String gender = bufferedReader.readLine().toUpperCase();
                if (!gender.equals("M") && !gender.equals("F")) {
                    System.out.println("Bad gender!");
                    gender = "[no data]";
                }
                System.out.println("Enter the number: ");
                String perPhoneNumber = bufferedReader.readLine();
                    contacts.add(new Person(perPhoneNumber, perName, perSurname, perDate, gender));
                System.out.println("The record added.");
                System.out.println();
                break;
            case "organization":
                System.out.println("Enter the organization name: ");
                String orgName = bufferedReader.readLine();
                System.out.println("Enter the address: ");
                String orgAddress = bufferedReader.readLine();
                System.out.println("Enter the number: ");
                String orgNumber = bufferedReader.readLine();
                contacts.add(new Organization(orgNumber, orgName, orgAddress));
                System.out.println("The record added.");
                System.out.println();
                break;
        }
    }

    public void removeContact() throws IOException {
        System.out.println("Select a record: ");
        int choose = Integer.parseInt(bufferedReader.readLine());
        contacts.remove(choose - 1);
        System.out.println("The record removed!");
    }


    public void showList() {
        int i = 1;
        for (Contact contact : contacts) {
            if (!contact.isPerson()) {
                System.out.println(i + ". " + contact.getName());
            } else {
                Person person = (Person) contact;
                System.out.println(i + ". " + contact.getName() + " " + person.getSurname());
            }
            i++;
        }
    }
}
