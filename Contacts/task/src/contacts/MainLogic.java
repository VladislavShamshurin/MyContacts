package contacts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainLogic {
    public static final List<Contact> contacts = new ArrayList<>();
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public void selectAction() {
        boolean isExit = false;
        while(!isExit) {
            try {
                System.out.println("[menu] Enter action (add, list, search, count, exit): ");
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
                    case "list":
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
            contacts.get(Integer.parseInt(bufferedReader.readLine()) - 1).showInfo();
        } catch (NumberFormatException e) {
            e.getMessage();
        }
    }

    public void editContact() throws IOException {
        System.out.println("Select a record: ");
        contacts.get(Integer.parseInt(bufferedReader.readLine()) - 1).editContact();
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
