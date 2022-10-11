package seedu.address.storage;

import static seedu.address.model.person.contact.ContactType.CONTACT_TYPE_EMAIL;
import static seedu.address.model.person.contact.ContactType.CONTACT_TYPE_PHONE;
import static seedu.address.model.person.contact.ContactType.CONTACT_TYPE_SLACK;
import static seedu.address.model.person.contact.ContactType.CONTACT_TYPE_TELEGRAM;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
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
 * Jackson-friendly version of {@link Person}.
 */
class JsonAdaptedPerson {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Person's %s field is missing!";

    private final String name;
    private String phone;
    private String email;
    private String telegram;
    private String slack;
    private String tag;

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedPerson(@JsonProperty("name") String name, @JsonProperty("phone") String phone,
                             @JsonProperty("email") String email, @JsonProperty("telegram") String telegram,
                             @JsonProperty("slack") String slack, @JsonProperty("tag") String tag) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.telegram = telegram;
        this.slack = slack;
        this.tag = tag;
    }

    /**
     * Converts a given {@code Person} into this class for Jackson use.
     */
    public JsonAdaptedPerson(Person source) {
        name = source.getName().fullName;
        source.getPhone().ifPresent(phone -> this.phone = phone.getValue());
        source.getEmail().ifPresent(email -> this.email = email.getValue());
        source.getTelegram().ifPresent(telegram -> this.telegram = telegram.getValue());
        source.getSlack().ifPresent(slack -> this.slack = slack.getValue());
        source.getTag().ifPresent(tag -> this.tag = tag.tagName);
    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code Person} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public Person toModelType() throws IllegalValueException {
        HashMap<ContactType, Contact> modelContactMap = new HashMap<ContactType, Contact>();
        Tag modelTag = null;

        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!Name.isValidName(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name modelName = new Name(name);

        if (phone != null) {
            if (!Phone.isValidPhone(phone)) {
                throw new IllegalValueException(Phone.MESSAGE_CONSTRAINTS);
            }
            modelContactMap.put(CONTACT_TYPE_PHONE, new Phone(phone));
        }


        if (email != null) {
            if (!Email.isValidEmail(email)) {
                throw new IllegalValueException(Email.MESSAGE_CONSTRAINTS);
            }
            modelContactMap.put(CONTACT_TYPE_EMAIL, new Email(email));
        }


        if (telegram != null) {
            if (!Telegram.isValidTelegram(telegram)) {
                throw new IllegalValueException(Telegram.MESSAGE_CONSTRAINTS);
            }
            modelContactMap.put(CONTACT_TYPE_TELEGRAM, new Telegram(telegram));
        }


        if (slack != null) {
            if (!Slack.isValidSlack(slack)) {
                throw new IllegalValueException(Slack.MESSAGE_CONSTRAINTS);
            }
            modelContactMap.put(CONTACT_TYPE_SLACK, new Slack(slack));
        }


        if (tag != null) {
            if (!Tag.isValidTagName(tag)) {
                throw new IllegalValueException(Slack.MESSAGE_CONSTRAINTS);
            }
            modelTag = new Tag(tag);
        }

        return new Person(modelName, modelContactMap, modelTag);
    }

}
