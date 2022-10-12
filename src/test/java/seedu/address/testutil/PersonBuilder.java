package seedu.address.testutil;

import static seedu.address.model.person.contact.ContactType.CONTACT_TYPE_EMAIL;
import static seedu.address.model.person.contact.ContactType.CONTACT_TYPE_PHONE;
import static seedu.address.model.person.contact.ContactType.CONTACT_TYPE_SLACK;
import static seedu.address.model.person.contact.ContactType.CONTACT_TYPE_TELEGRAM;

import java.util.HashMap;
import java.util.Map;

import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.contact.Contact;
import seedu.address.model.person.contact.ContactType;
import seedu.address.model.person.contact.Email;
import seedu.address.model.person.contact.Phone;
import seedu.address.model.person.contact.Slack;
import seedu.address.model.person.contact.Telegram;
import seedu.address.model.tag.Tag;

/**
 * A utility class to help with building Person objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_TELEGRAM = "@amybee";
    public static final String DEFAULT_SLACK = "amybee_";
    public static final String DEFAULT_TAG = "friends";
    private final HashMap<ContactType, Contact> contactMap;
    private Tag tag;
    private Name name;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        contactMap = new HashMap<>(Map.of(
            CONTACT_TYPE_PHONE, new Phone(DEFAULT_PHONE),
            CONTACT_TYPE_EMAIL, new Email(DEFAULT_EMAIL),
            CONTACT_TYPE_TELEGRAM, new Telegram(DEFAULT_TELEGRAM),
            CONTACT_TYPE_SLACK, new Slack(DEFAULT_SLACK)
        ));
        tag = new Tag(DEFAULT_TAG);
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Person personToCopy) {
        name = personToCopy.getName();
        contactMap = personToCopy.getContactMap();
        tag = personToCopy.getTag().orElse(null);
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
    public PersonBuilder withTag(String tag) {
        this.tag = new Tag(tag);
        return this;
    }

    /**
     * Sets the {@code Telegram} of the {@code Person} that we are building.
     */
    public PersonBuilder withTelegram(String telegram) {
        this.contactMap.put(
            CONTACT_TYPE_TELEGRAM, new Telegram(telegram)
        );
        return this;
    }

    /**
     * Sets the {@code Slack} of the {@code Person} that we are building.
     */
    public PersonBuilder withSlack(String slack) {
        this.contactMap.put(
            CONTACT_TYPE_SLACK, new Telegram(slack)
        );
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Person} that we are building.
     */
    public PersonBuilder withPhone(String phone) {
        this.contactMap.put(
            CONTACT_TYPE_PHONE, new Phone(phone)
        );
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Person} that we are building.
     */
    public PersonBuilder withEmail(String email) {
        this.contactMap.put(
            CONTACT_TYPE_EMAIL, new Email(email)
        );
        return this;
    }

    public Person build() {
        return new Person(name, contactMap, tag);
    }

}
