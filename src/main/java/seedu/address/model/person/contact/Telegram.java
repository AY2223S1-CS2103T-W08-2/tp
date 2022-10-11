package seedu.address.model.person.contact;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's telegram in the contact book.
 * Guarantees: immutable; is valid as declared in {@link #isValidTelegram(String)}
 */
public class Telegram extends Contact {

    public static final String MESSAGE_CONSTRAINTS = "Telegram username should be of the format @username "
            + "and adhere to the following constraints:\n"
            + "1. The username should be between 5 and 32 characters in length."
            + "2. The username should only contain alphanumeric characters and underscores. The username may not "
            + "start or end with any underscores."
            + "3. The username must not have consecutive underscores.";

    /*
     * The first character of the telegram must not be a whitespace,
     * otherwise " " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "^@(?=.{5,32}$)(?!.*__)[A-Za-z][A-Za-z0-9_]*[A-Za-z0-9]$";
    public static final String TELEGRAM_LINK_PREFIX = "https://t.me/";
    public static final String TELEGRAM_LOGO_FILEPATH = "";

    private static final String CONTACT_TYPE = "Telegram";

    public final String value;

    /**
     * Constructs an {@code Address}.
     *
     * @param username A valid username.
     */
    public Telegram(String username) {
        super(CONTACT_TYPE);
        requireNonNull(username);
        System.out.println(username);
        checkArgument(isValidTelegram(username), MESSAGE_CONSTRAINTS);
        value = username;
    }

    /**
     * Returns true if a given string is a valid telegram username.
     */
    public static boolean isValidTelegram(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    /**
     * @return
     */
    @Override
    public String getLink() {
        return TELEGRAM_LINK_PREFIX + this.value.substring(1);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Telegram // instanceof handles nulls
                && value.equals(((Telegram) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
