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
        System.out.println("open phonebook.db\n");
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
                        info();
                        break;
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
            System.out.println("\n[search] Enter action ([number], back, again): ");
            String choose = bufferedReader.readLine().toLowerCase().toLowerCase();
            if (choose.equals("back")) {
                return;
            } else if (choose.equals("again")) {
                search();
            } else {
                try {
                    contacts.get(Integer.parseInt(choose) - 1).showInfo();
                    System.out.println("[record] Enter action (edit, delete, menu): ");
                    String select = bufferedReader.readLine().toLowerCase();
                    if (select.equals("edit")) {
                        editContact(Integer.parseInt(choose) - 1);
                    } else if (select.equals("delete")) {
                        removeContact(Integer.parseInt(choose) - 1);
                    } else {
                        return;
                    }
                } catch (IndexOutOfBoundsException | NumberFormatException e) {
                    System.out.println("Error!");
                }
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

    public void editContact(int choose) throws IOException {
        contacts.get(choose).editContact();
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

    public void removeContact(int choose) {
        contacts.remove(choose);
        System.out.println("The record removed!");
    }


    public void showList() {
        int i = 1;
        for (Contact contact : contacts) {
                System.out.println(i + ". " + contact.getFullName());
                i++;
        }
    }
}
