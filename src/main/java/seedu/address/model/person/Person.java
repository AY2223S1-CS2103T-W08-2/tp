package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.model.person.contact.ContactType.CONTACT_TYPE_EMAIL;
import static seedu.address.model.person.contact.ContactType.CONTACT_TYPE_PHONE;
import static seedu.address.model.person.contact.ContactType.CONTACT_TYPE_SLACK;
import static seedu.address.model.person.contact.ContactType.CONTACT_TYPE_TELEGRAM;

import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

import seedu.address.model.person.contact.Contact;
import seedu.address.model.person.contact.ContactType;
import seedu.address.model.person.contact.Email;
import seedu.address.model.person.contact.Phone;
import seedu.address.model.person.contact.Slack;
import seedu.address.model.person.contact.Telegram;
import seedu.address.model.tag.Tag;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Person {

    // Identity fields
    private final Name name;
    private final HashMap<ContactType, Contact> contactMap;
    private final Tag tag;

    /**
     * Every field must be present and not null.
     */
    public Person(Name name, HashMap<ContactType, Contact> contactMap, Tag tag) {
        requireAllNonNull(name, contactMap);
        this.contactMap = contactMap;
        this.name = name;
        this.tag = tag;
    }

    public Name getName() {
        return name;
    }

    public HashMap<ContactType, Contact> getContactMap() {
        return this.contactMap;
    }

    public Optional<Email> getEmail() {
        return Optional.ofNullable((Email) contactMap.get(CONTACT_TYPE_EMAIL));
    }

    public Optional<Phone> getPhone() {
        return Optional.ofNullable((Phone) contactMap.get(CONTACT_TYPE_PHONE));
    }

    public Optional<Slack> getSlack() {
        return Optional.ofNullable((Slack) contactMap.get(CONTACT_TYPE_SLACK));
    }

    public Optional<Telegram> getTelegram() {
        return Optional.ofNullable((Telegram) contactMap.get(CONTACT_TYPE_TELEGRAM));
    }

    public Optional<Tag> getTag() {
        System.out.println(tag == null);
        return Optional.ofNullable(this.tag);
    }

    /**
     * Returns true if both persons have the same name.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null && otherPerson.getName().equals(getName());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Person)) {
            return false;
        }

        Person otherPerson = (Person) other;
        return otherPerson.getName().equals(getName())
            && otherPerson.getEmail().equals(getEmail())
            && otherPerson.getPhone().equals(getPhone())
            && otherPerson.getSlack().equals(getSlack())
            && otherPerson.getTelegram().equals(getTelegram())
            && otherPerson.getTag().equals(getTag());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, contactMap, tag);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName());

        HashMap<ContactType, Contact> contactMap = getContactMap();
        for (Contact contact : contactMap.values()) {
            builder.append("; ").append(contact.getContactTypeName()).append(": ").append(contact.getValue());
        }
        builder.append("; Tag: ").append(tag);
        return builder.toString();
    }

}
