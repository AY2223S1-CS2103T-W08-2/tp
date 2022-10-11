package seedu.address.model.util;

import static seedu.address.model.person.contact.ContactType.CONTACT_TYPE_EMAIL;
import static seedu.address.model.person.contact.ContactType.CONTACT_TYPE_PHONE;
import static seedu.address.model.person.contact.ContactType.CONTACT_TYPE_SLACK;
import static seedu.address.model.person.contact.ContactType.CONTACT_TYPE_TELEGRAM;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.contact.Email;
import seedu.address.model.person.contact.Phone;
import seedu.address.model.person.contact.Slack;
import seedu.address.model.person.contact.Telegram;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[]{
            new Person(
                new Name("Alex Yeoh"),
                new HashMap<>(
                    Map.of(
                        CONTACT_TYPE_PHONE, new Phone("87438807"),
                        CONTACT_TYPE_EMAIL, new Email("alexyeoh@example.com"),
                        CONTACT_TYPE_TELEGRAM, new Telegram("@alexyy"),
                        CONTACT_TYPE_SLACK, new Slack("alexyeohhh_"))),
                new Tag("Backend Developer")
            ),

            new Person(
                new Name("Bernice Yu"),
                new HashMap<>(
                    Map.of(
                        CONTACT_TYPE_PHONE, new Phone("99272758"),
                        CONTACT_TYPE_EMAIL, new Email("berniceyu@example.com"),
                        CONTACT_TYPE_TELEGRAM, new Telegram("@berniceyu"),
                        CONTACT_TYPE_SLACK, new Slack("berniceyu"))),
                new Tag("Full Stack Developer, DevOps Expert")
            ),
            new Person(
                new Name("Charlotte Oliveiro"),
                new HashMap<>(
                    Map.of(
                        CONTACT_TYPE_PHONE, new Phone("93210283"),
                        CONTACT_TYPE_EMAIL, new Email("charlotte@example.com"),
                        CONTACT_TYPE_TELEGRAM, new Telegram("@charlotteo"),
                        CONTACT_TYPE_SLACK, new Slack("charlotteoliveiro"))),
                new Tag("Project Manager")
            ),
            new Person(
                new Name("David Li"),
                new HashMap<>(
                    Map.of(
                        CONTACT_TYPE_PHONE, new Phone("91031282"),
                        CONTACT_TYPE_EMAIL, new Email("lidavid@example.com"),
                        CONTACT_TYPE_TELEGRAM, new Telegram("@davidli"),
                        CONTACT_TYPE_SLACK, new Slack("david_li"))),
                new Tag("Backend Team Lead")
            ),
            new Person(
                new Name("Irfan Ibrahim"),
                new HashMap<>(
                    Map.of(
                        CONTACT_TYPE_PHONE, new Phone("92492021"),
                        CONTACT_TYPE_EMAIL, new Email("irfan@example.com"),
                        CONTACT_TYPE_TELEGRAM, new Telegram("@irfannn"),
                        CONTACT_TYPE_SLACK, new Slack("_irfan_ibrahim"))),
                new Tag("QA Team Lead")
            ),
            new Person(
                new Name("Roy Balakrishnan"),
                new HashMap<>(
                    Map.of(
                        CONTACT_TYPE_PHONE, new Phone("92624417"),
                        CONTACT_TYPE_EMAIL, new Email("royb@example.com"),
                        CONTACT_TYPE_TELEGRAM, new Telegram("@royBalakrishnan"),
                        CONTACT_TYPE_SLACK, new Slack("roy_balakrishnan"))),
                new Tag("Frontend Developer")
            )
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings).map(Tag::new).collect(Collectors.toSet());
    }

}
