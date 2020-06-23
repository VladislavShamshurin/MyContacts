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
        System.out.println("open phonebook.db");
        boolean isExit = false;
        while(!isExit) {
            try {
                System.out.println("[menu] Enter action (add, list, search, count, exit): ");
                String answer = bufferedReader.readLine();
                switch (answer.toLowerCase()) {
                    case "add":
                        addContact();
                        break;
                    case "count":
                        System.out.println("The Phone Book has " + contacts.size() +  " records.");
                        break;
                    case "list":
                        if (contacts.size() != 0) {
                            list();
                            break;
                        } else {
                            System.out.println("Records not added!");
                        }
                    case "exit":
                        isExit = true;
                        bufferedReader.close();
                        break;
                    case "search":
                        search();
                        break;
                }
            } catch (IOException e) {
                e.getMessage();
            }
        }
    }

    public void search() throws IOException {
            System.out.println("Enter search query: ");
            String search = bufferedReader.readLine().toLowerCase();
            int count = 0;
            for (Contact contact : contacts) {
                if (contact.getFullName().toLowerCase().contains(search)) {
                    count++;
                }
            }
            System.out.println("Found " + count + " results:");
            count = 0;
            for (Contact contact : contacts) {
                if (contact.getFullName().toLowerCase().contains(search)) {
                    System.out.println((count + 1) + ". " + contact.getFullName());
                    count++;
                }
            }
            searchAction();
    }

    public void searchAction() throws IOException {
        System.out.println("\n[search] Enter action ([number], back, again): ");
        String choose = bufferedReader.readLine().toLowerCase();
        if (choose.equals("back")) {} else if (choose.equals("again")) {
            search();
        } else {
            try {
                contacts.get(Integer.parseInt(choose) - 1).showInfo();
                recordAction(Integer.parseInt(choose) - 1);
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Error!");
            }
        }
    }

    public void recordAction(int index) throws IOException {
        System.out.println("[record] Enter action (edit, delete, menu): ");
        String select = bufferedReader.readLine().toLowerCase();
        if (select.equals("edit")) {
            editContact(index);
        } else if (select.equals("delete")) {
            removeContact(index);
        }
    }

    public void list() throws IOException {
        showList();
        System.out.println("[list] Enter action ([number], back): ");
        String choose = bufferedReader.readLine().toLowerCase();
        if (choose.equals("back")) {} else {
            try {
                int index = Integer.parseInt(choose) - 1;
                info(index);
                recordAction(index);
            } catch (IndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Error!");
            }
        }
    }

    public void info(int index) {
        try {
            contacts.get(index).showInfo();
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
            System.out.println("Error!");
        }
    }

    public void editContact(int index) throws IOException {
        contacts.get(index).editContact();
    }

    public void addContact() throws IOException {
        System.out.println("[Add] Enter the type (person, organization, back): ");
        String type = bufferedReader.readLine();
        switch (type.toLowerCase()) {
            case "person":
                Person.addContact();
                break;
            case "organization":
                Organization.addContact();
                break;
            case "back":
                break;
        }
    }

    public void removeContact(int index) {
        contacts.remove(index);
        System.out.println("The record removed!");
    }


    public void showList() {
        int i = 1;
        for (Contact contact : contacts) {
                System.out.println(i + ". " + contact.getFullName());
                i++;
        }
        System.out.println();
    }
}
