package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.contact.Slack;
import seedu.address.model.person.contact.Telegram;
import seedu.address.model.person.contact.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.contact.Phone;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"))
                    .setPhone(new Phone("87438807"))
                    .setEmail(new Email("alexyeoh@example.com"))
                    .setTelegram(new Telegram("@alexyy"))
                    .setSlack(new Slack("alexyeohhh_"))
                    .addTags(getTagSet("Backend Developer")),
            new Person(new Name("Bernice Yu"))
                    .setPhone(new Phone("99272758"))
                    .setEmail(new Email("berniceyu@example.com"))
                    .setTelegram(new Telegram("@berniceyu"))
                    .setSlack(new Slack("berniceyu"))
                    .addTags(getTagSet("Full Stack Developer", "DevOps Expert")),
            new Person(new Name("Charlotte Oliveiro"))
                    .setPhone(new Phone("93210283"))
                    .setEmail(new Email("charlotte@example.com"))
                    .setTelegram(new Telegram("@charlotteo"))
                    .setSlack(new Slack("charlotteoliveiro"))
                    .addTags(getTagSet("Project Manager")),
            new Person(new Name("David Li"))
                    .setPhone(new Phone("91031282"))
                    .setEmail(new Email("lidavid@example.com"))
                    .setTelegram(new Telegram("@davidli"))
                    .setSlack(new Slack("david_li"))
                    .addTags(getTagSet("Backend Team Lead")),
            new Person(new Name("Irfan Ibrahim"))
                    .setPhone(new Phone("92492021"))
                    .setEmail(new Email("irfan@example.com"))
                    .setTelegram(new Telegram("@irfannn"))
                    .setSlack(new Slack("_irfan_ibrahim"))
                    .addTags(getTagSet("QA Team Lead")),
            new Person(new Name("Roy Balakrishnan"))
                    .setPhone(new Phone("92624417"))
                    .setEmail(new Email("royb@example.com"))
                    .setTelegram(new Telegram("@royBalakrish"))
                    .setSlack(new Slack("roy_balakrishnan"))
                    .addTags(getTagSet("colleagues"))
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
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
