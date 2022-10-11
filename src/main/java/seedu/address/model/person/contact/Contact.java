package seedu.address.model.person.contact;

/**
 * Contact describes an attribute of a person with a link, value and logo.
 */
public abstract class Contact {

    private final String contactType;
    private final String link;
    private final String logoFilePath;
    private String value;

    /**
     * @param contactTypeName String of contact type to be shown to user upon editing/adding.
     * @param link            Link to be used as hyperlink in UI.
     * @param logoFilePath    Pathname of logo corresponding to contact type.
     */
    public Contact(String contactTypeName, String link, String logoFilePath) {
        this.contactType = contactTypeName;
        this.link = link;
        this.logoFilePath = logoFilePath;
    }

    public String getContactType() {
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

    public String getLogoFilePath() {
        return this.logoFilePath;
    }
}
