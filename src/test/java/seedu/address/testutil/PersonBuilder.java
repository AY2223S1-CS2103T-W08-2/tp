package seedu.address.testutil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import seedu.address.model.person.Address;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Role;
import seedu.address.model.person.Timezone;
import seedu.address.model.person.contact.Contact;
import seedu.address.model.person.contact.ContactType;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Person objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";
    public static final String DEFAULT_ROLE = "Software Engineer";
    public static final String DEFAULT_TIMEZONE = "+8";

    private Name name;
    private Address address;
    private Role role;
    private Timezone timezone;
    private Set<Tag> tags;
    private HashMap<ContactType, Contact> contacts;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        address = new Address(DEFAULT_ADDRESS);
        role = new Role(DEFAULT_ROLE);
        timezone = new Timezone(DEFAULT_TIMEZONE);
        tags = new HashSet<>();
        contacts = new HashMap<>();
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Person personToCopy) {
        name = personToCopy.getName();
        address = personToCopy.getAddress();
        tags = new HashSet<>(personToCopy.getTags());
        contacts = new HashMap<>(personToCopy.getContacts());
        role = personToCopy.getRole();
        timezone = personToCopy.getTimezone();
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withTags(String... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Person} that we are building.
     */
    public PersonBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Contacts} of the {@code Person} that we are building
     */
    public PersonBuilder withContact(ContactType type, String name) {
        this.contacts.put(type, Contact.of(type, name));
        return this;
    }

    /**
     * Sets the {@code Role} of the {@code Person} that we are building
     */
    public PersonBuilder withRole(String role) {
        this.role = new Role(role);
        return this;
    }

    /**
     * Sets the {@code Role} of the {@code Person} that we are building
     */
    public PersonBuilder withTimezone(String timezone) {
        this.timezone = new Timezone(timezone);
        return this;
    }

    /**
     * Build the Person Model
     *
     * @return a Person
     */
    public Person build() {
        return new Person(name, address, tags, contacts, role, timezone);
    }

}
