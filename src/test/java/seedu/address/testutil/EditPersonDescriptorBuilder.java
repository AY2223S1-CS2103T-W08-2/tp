package seedu.address.testutil;

import seedu.address.logic.commands.EditCommand.EditPersonDescriptor;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.contact.Email;
import seedu.address.model.person.contact.Phone;
import seedu.address.model.person.contact.Slack;
import seedu.address.model.person.contact.Telegram;
import seedu.address.model.tag.Tag;

/**
 * A utility class to help with building EditPersonDescriptor objects.
 */
public class EditPersonDescriptorBuilder {

    private final EditPersonDescriptor descriptor;

    public EditPersonDescriptorBuilder() {
        descriptor = new EditPersonDescriptor();
    }

    public EditPersonDescriptorBuilder(EditPersonDescriptor descriptor) {
        this.descriptor = new EditPersonDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditPersonDescriptor} with fields containing {@code person}'s details
     */
    public EditPersonDescriptorBuilder(Person person) {
        descriptor = new EditPersonDescriptor();
        descriptor.setName(person.getName());
        descriptor.setContactMap(person.getContactMap());
        descriptor.setTag(person.getTag().orElse(null));
    }

    /**
     * Sets the {@code Name} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withName(String name) {
        descriptor.setName(new Name(name));
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withPhone(String phone) {
        descriptor.setPhone(new Phone(phone));
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withEmail(String email) {
        descriptor.setEmail(new Email(email));
        return this;
    }

    /**
     * Sets the {@code Telegram} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withTelegram(String telegram) {
        descriptor.setTelegram(new Telegram(telegram));
        return this;
    }

    /**
     * Sets the {@code Slack} of the {@code EditPersonDescriptor} that we are building.
     */
    public EditPersonDescriptorBuilder withSlack(String slack) {
        descriptor.setSlack(new Slack(slack));
        return this;
    }

    /**
     * Parses the {@code tag} into a {@code Tag>} and set it to the {@code EditPersonDescriptor}
     * that we are building.
     */
    public EditPersonDescriptorBuilder withTag(String tag) {
        descriptor.setTag(new Tag(tag));
        return this;
    }

    public EditPersonDescriptor build() {
        return descriptor;
    }
}
