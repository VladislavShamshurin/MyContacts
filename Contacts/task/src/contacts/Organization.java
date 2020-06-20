package contacts;

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
