package seedu.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.storage.JsonAdaptedPerson.MISSING_FIELD_MESSAGE_FORMAT;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.BENSON;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.person.Address;
import seedu.address.model.person.Name;
import seedu.address.model.person.contact.ContactType;

public class JsonAdaptedPersonTest {
    private static final String INVALID_NAME = "R@chel";
    private static final String INVALID_ADDRESS = " ";
    private static final String INVALID_TAG = "#friend";
    private static final String INVALID_TELEGRAM = "hello-world";
    private static final String INVALID_PHONE = "+651234";
    private static final String INVALID_EMAIL = "example.com";
    private static final String INVALID_SLACK = "@+213";

    private static final String VALID_NAME = BENSON.getName().toString();
    private static final String VALID_ADDRESS = BENSON.getAddress().toString();
    private static final List<JsonAdaptedTag> VALID_TAGS = BENSON.getTags().stream()
        .map(JsonAdaptedTag::new)
        .collect(Collectors.toList());
    private static final List<JsonAdaptedContact> VALID_CONTACTS = BENSON.getContacts().values().stream()
            .map(JsonAdaptedContact::new)
            .collect(Collectors.toList());

    @Test
    public void toModelType_validPersonDetails_returnsPerson() throws Exception {
        JsonAdaptedPerson person = new JsonAdaptedPerson(BENSON);
        assertEquals(BENSON, person.toModelType());
    }

    @Test
    public void toModelType_invalidName_throwsIllegalValueException() {
        JsonAdaptedPerson person =
            new JsonAdaptedPerson(INVALID_NAME, VALID_ADDRESS, VALID_TAGS, VALID_CONTACTS);
        String expectedMessage = Name.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullName_throwsIllegalValueException() {
        JsonAdaptedPerson person = new JsonAdaptedPerson(null, VALID_ADDRESS, VALID_TAGS, VALID_CONTACTS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidAddress_throwsIllegalValueException() {
        JsonAdaptedPerson person =
            new JsonAdaptedPerson(VALID_NAME, INVALID_ADDRESS, VALID_TAGS, VALID_CONTACTS);
        String expectedMessage = Address.MESSAGE_CONSTRAINTS;
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_nullAddress_throwsIllegalValueException() {
        JsonAdaptedPerson person = new JsonAdaptedPerson(VALID_NAME, null, VALID_TAGS, VALID_CONTACTS);
        String expectedMessage = String.format(MISSING_FIELD_MESSAGE_FORMAT, Address.class.getSimpleName());
        assertThrows(IllegalValueException.class, expectedMessage, person::toModelType);
    }

    @Test
    public void toModelType_invalidTags_throwsIllegalValueException() {
        List<JsonAdaptedTag> invalidTags = new ArrayList<>(VALID_TAGS);
        invalidTags.add(new JsonAdaptedTag(INVALID_TAG));
        JsonAdaptedPerson person =
            new JsonAdaptedPerson(VALID_NAME, VALID_ADDRESS, invalidTags, VALID_CONTACTS);
        assertThrows(IllegalValueException.class, person::toModelType);
    }

    @Test
    public void toModelType_invalidTelegram_throwsIllegalValueException() {
        List<JsonAdaptedContact> invalidContacts = new ArrayList<>();
        invalidContacts.add(new JsonAdaptedContact(ContactType.TELEGRAM, INVALID_TELEGRAM));
        JsonAdaptedPerson person = new JsonAdaptedPerson(VALID_NAME, VALID_ADDRESS, VALID_TAGS, invalidContacts);
        assertThrows(IllegalValueException.class, person::toModelType);
    }

    @Test
    public void toModelType_invalidPhone_throwsIllegalValueException() {
        List<JsonAdaptedContact> invalidContacts = new ArrayList<>();
        invalidContacts.add(new JsonAdaptedContact(ContactType.PHONE, INVALID_PHONE));
        JsonAdaptedPerson person = new JsonAdaptedPerson(VALID_NAME, VALID_ADDRESS, VALID_TAGS, invalidContacts);
        assertThrows(IllegalValueException.class, person::toModelType);
    }

    @Test
    public void toModelType_invalidEmail_throwsIllegalValueException() {
        List<JsonAdaptedContact> invalidContacts = new ArrayList<>();
        invalidContacts.add(new JsonAdaptedContact(ContactType.EMAIL, INVALID_EMAIL));
        JsonAdaptedPerson person = new JsonAdaptedPerson(VALID_NAME, VALID_ADDRESS, VALID_TAGS, invalidContacts);
        assertThrows(IllegalValueException.class, person::toModelType);
    }

    @Test
    public void toModelType_invalidSlack_throwsIllegalValueException() {
        List<JsonAdaptedContact> invalidContacts = new ArrayList<>();
        invalidContacts.add(new JsonAdaptedContact(ContactType.SLACK, INVALID_SLACK));
        JsonAdaptedPerson person = new JsonAdaptedPerson(VALID_NAME, VALID_ADDRESS, VALID_TAGS, invalidContacts);
        assertThrows(IllegalValueException.class, person::toModelType);
    }
}
