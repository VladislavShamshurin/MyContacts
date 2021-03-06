package contacts;

import java.io.IOException;

public abstract class Contact {
    private String phoneNumber = "";
    private String name;

    public Contact(String phoneNumber, String name) {
        this.name = name;
        checkNumber(phoneNumber);
    }

    private void checkNumber(String phoneNumber) {
        if (phoneNumber.matches(RegexContact.firstRegexNumber) || phoneNumber.matches(RegexContact.secondRegexNumber)
        || phoneNumber.matches(RegexContact.thirdRegexNumber)) {
            this.phoneNumber = phoneNumber;
        } else {
            this.phoneNumber = "";
            System.out.println("Wrong number format!");
            if (!hasNumber()) {
                this.phoneNumber = "[no number]";
            }
        }
    }

    public abstract String getFullName();

    public abstract void editContact() throws IOException;

    public abstract void showInfo();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        checkNumber(phoneNumber);
    }

    public boolean isPerson() {
        return this instanceof Person;
    }

    public boolean hasNumber() {
        return !phoneNumber.equals("");
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}
