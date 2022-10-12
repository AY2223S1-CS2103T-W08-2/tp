package seedu.address.testutil;

import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_SLACK;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TELEGRAM;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
import seedu.address.model.person.Person;

/**
 * A utility class for Person.
 */
public class PersonUtil {

    /**
     * Returns an add command string for adding the {@code person}.
     */
    public static String getAddCommand(Person person) {
        return AddCommand.COMMAND_WORD + " " + getPersonDetails(person);
    }

    /**
     * Returns the part of command string for the given {@code person}'s details.
     */
    public static String getPersonDetails(Person person) {
        StringBuilder sb = new StringBuilder();
        sb.append(PREFIX_NAME).append(person.getName().fullName).append(" ");
        person.getPhone().ifPresent(phone -> sb.append(PREFIX_PHONE).append(phone.getValue()).append(" "));
        person.getEmail().ifPresent(email -> sb.append(PREFIX_EMAIL).append(email.getValue()).append(" "));
        person.getTelegram().ifPresent(telegram -> sb.append(PREFIX_TELEGRAM).append(telegram.getValue()).append(" "));
        person.getSlack().ifPresent(slack -> sb.append(PREFIX_SLACK).append(slack.getValue()).append(" "));
        person.getTag().ifPresent(tag -> sb.append(PREFIX_TAG).append(tag.tagName));
        return sb.toString();
    }

    /**
     * Returns the part of command string for the given {@code EditPersonDescriptor}'s details.
     */
    public static String getEditPersonDescriptorDetails(EditPersonDescriptor descriptor) {
        StringBuilder sb = new StringBuilder();
        descriptor.getName().ifPresent(name -> sb.append(PREFIX_NAME).append(name.fullName).append(" "));
        descriptor.getPhone().ifPresent(phone -> sb.append(PREFIX_PHONE).append(phone.getValue()).append(" "));
        descriptor.getEmail().ifPresent(email -> sb.append(PREFIX_EMAIL).append(email.getValue()).append(" "));
        descriptor.getTelegram()
            .ifPresent(telegram -> sb.append(PREFIX_TELEGRAM).append(telegram.getValue()).append(" "));
        descriptor.getSlack().ifPresent(slack -> sb.append(PREFIX_SLACK).append(slack.getValue()).append(" "));
        descriptor.getTag().ifPresent(tag -> sb.append(PREFIX_TAG).append(tag.tagName).append(" "));
        return sb.toString();
    }
}
