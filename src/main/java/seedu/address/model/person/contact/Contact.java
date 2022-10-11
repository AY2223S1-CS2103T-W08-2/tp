package seedu.address.model.person.contact;

/**
 * Contact describes an attribute of a person with a link, value and logo.
 */
public abstract class Contact {

    private final String contactType;
    private final String link;
    private String value;

    /**
     * @param contactTypeName String of contact type to be shown to user upon editing/adding.
     * @param link            Link to be used as hyperlink in UI.
     */
    public Contact(String contactTypeName, String link) {
        this.contactType = contactTypeName;
        this.link = link;
    }

    public String getContactTypeName() {
        return contactType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLink() {
        return this.link;
    }
}
