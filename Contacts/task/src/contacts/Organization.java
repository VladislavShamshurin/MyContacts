package contacts;

import java.io.IOException;
import java.time.LocalDateTime;

public class Organization extends Contact {
    private String address;
    public LocalDateTime createDate;
    public LocalDateTime lastEdit;

    public Organization(String phoneNumber, String name, String address) {
        super(phoneNumber, name);
        this.address = address;
        this.createDate = LocalDateTime.now();
        this.lastEdit = this.createDate;
    }

   public static void addContact() throws IOException {
        System.out.println("[Add] Enter the organization name: ");
        String orgName = MainLogic.bufferedReader.readLine();
        System.out.println("[Add] Enter the address: ");
        String orgAddress = MainLogic.bufferedReader.readLine();
        System.out.println("[Add] Enter the number: ");
        String orgNumber = MainLogic.bufferedReader.readLine();
        MainLogic.contacts.add(new Organization(orgNumber, orgName, orgAddress));
        System.out.println("The record added.\n");
    }

    @Override
    public void editContact() throws IOException {
        System.out.println("Select a field (name, address, number): ");
        String field = MainLogic.bufferedReader.readLine();
        switch (field.toLowerCase()) {
            case "name":
                System.out.println("Enter name: ");
                String newName = MainLogic.bufferedReader.readLine();
                setName(newName);
                System.out.println("Saved");
                setLastEdit(LocalDateTime.now());
                System.out.println();
                break;
            case "address":
                System.out.println("Enter address: ");
                String newAddress = MainLogic.bufferedReader.readLine();
                setAddress(newAddress);
                System.out.println("Saved");
                setLastEdit(LocalDateTime.now());
                System.out.println();
                break;
            case "number":
                System.out.println("Enter number: ");
                String newNumber = MainLogic.bufferedReader.readLine();
                setPhoneNumber(newNumber);
                System.out.println("Saved");
                setLastEdit(LocalDateTime.now());
                System.out.println();
                break;
        }
    }

    @Override
    public void showInfo() {
        System.out.println(String.format("Organization name: %s\n" +
                "Address: %s\n" +
                "Number: %s", getName(), getAddress(), getPhoneNumber()));
        System.out.println("Time created: " + getCreateDate());
        System.out.println("Time last edit: " + getLastEdit() + "\n");
    }

    @Override
    public String getFullName() {
        return getName();
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getLastEdit() {
        return lastEdit;
    }

    public void setLastEdit(LocalDateTime lastEdit) {
        this.lastEdit = lastEdit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
