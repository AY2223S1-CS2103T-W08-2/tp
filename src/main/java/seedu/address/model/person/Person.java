package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.person.contact.Contact;
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
    private Email email = null;
    private Phone phone = null;
    private Slack slack = null;
    private Telegram telegram = null;
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Person(Name name) {
        requireAllNonNull(name);
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }
    public Person setEmail(Email email) {
        this.email = email;
        return this;
    }

    public Phone getPhone() {
        return phone;
    }
    public Person setPhone(Phone phone) {
        this.phone = phone;
        return this;
    }

    public Slack getSlack() {
        return slack;
    }
    public Person setSlack(Slack slack) {
        this.slack = slack;
        return this;
    }

    public Telegram getTelegram() {
        return telegram;
    }
    public Person setTelegram(Telegram telegram) {
        this.telegram = telegram;
        return this;
    }

    public Person addTag(Tag tag) {
        requireAllNonNull(tag);
        tags.add(tag);
        return this;
    }

    public Person addTags(Set<Tag> tags) {
        requireAllNonNull(tags);
        this.tags.addAll(tags);
        return this;
    }
    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both persons have the same name.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Person otherPerson) {
        if (otherPerson == this) {
            return true;
        }

        return otherPerson != null
                && otherPerson.getName().equals(getName());
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
                && otherPerson.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, email, phone, slack, telegram, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append("; Email: ")
                .append(getEmail())
                .append("; Phone: ")
                .append(getPhone())
                .append("; Slack: ")
                .append(getSlack())
                .append("; Telegram: ")
                .append(getTelegram());

        Set<Tag> tags = getTags();
        if (!tags.isEmpty()) {
            builder.append("; Tags: ");
            tags.forEach(builder::append);
        }
        return builder.toString();
    }
}
