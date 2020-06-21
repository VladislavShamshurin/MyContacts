package contacts;

import java.io.IOException;
import java.time.LocalDateTime;

public class Organization extends Contact {
    private String address;
    public LocalDateTime createDate;
    public LocalDateTime lastEdit;

    public Organization(String phoneNumber, String name, String address) {
        super(phoneNumber, name);
        createDate = LocalDateTime.now();
        lastEdit = createDate;
        this.address = address;
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
                System.out.println("The record updated!");
                setLastEdit(LocalDateTime.now());
                System.out.println();
                break;
            case "address":
                System.out.println("Enter address: ");
                String newAddress = MainLogic.bufferedReader.readLine();
                setAddress(newAddress);
                System.out.println("The record updated!");
                setLastEdit(LocalDateTime.now());
                System.out.println();
                break;
            case "number":
                System.out.println("Enter number: ");
                String newNumber = MainLogic.bufferedReader.readLine();
                setPhoneNumber(newNumber);
                System.out.println("The record updated!");
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
