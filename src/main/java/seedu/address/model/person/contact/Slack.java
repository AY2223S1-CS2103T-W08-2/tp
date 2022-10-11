package seedu.address.model.person.contact;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Person's Slack account in the contact book.
 * Guarantees: immutable; is valid as declared in {@link #isValidSlack(String)}
 */
public class Slack extends Contact {

    public static final String MESSAGE_CONSTRAINTS = "Slack channel names must be up to 20 characters long.";
    public static final String VALIDATION_REGEX = "^[a-z0-9-_]{1}[a-z0-9-_]{0,20}$";
    public static final String SLACK_LOGO_FILEPATH = "images/contact/slack.png";
    private static final String SLACK_LINK_PREFIX = "https://slack.com/app_redirect?channel=";
    private static final String CONTACT_TYPE_NAME = "Slack";

    /**
     * Constructs an {@code Address}.
     *
     * @param channelName A valid channel name.
     */
    public Slack(String channelName) {
        super(CONTACT_TYPE_NAME, SLACK_LINK_PREFIX + channelName, SLACK_LOGO_FILEPATH);
        requireNonNull(channelName);
        checkArgument(isValidSlack(channelName), MESSAGE_CONSTRAINTS);
        setValue(channelName);
    }

    /**
     * Returns true if a given string is a valid slack channel name.
     */
    public static boolean isValidSlack(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    /**
     * @return
     */
    @Override
    public String getLink() {
        return SLACK_LINK_PREFIX + this.getValue();
    }

    @Override
    public String toString() {
        return getValue();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof Telegram // instanceof handles nulls
            && getValue().equals(((Telegram) other).getValue())); // state check
    }

    @Override
    public int hashCode() {
        return getValue().hashCode();
    }
}
