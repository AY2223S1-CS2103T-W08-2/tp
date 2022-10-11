package seedu.address.model.person.contact;

public abstract class Contact {

    private final String contactType;

    public Contact(String contactType) {
        this.contactType = contactType;
    }

    public String getContactType() {
        return contactType;
    }

    abstract public String getLink();
}
