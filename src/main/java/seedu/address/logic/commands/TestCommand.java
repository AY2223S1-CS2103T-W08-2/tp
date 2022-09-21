package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.Messages;
import seedu.address.model.Model;
import seedu.address.model.person.NameContainsKeywordsPredicate;

/**
 * Finds and lists all persons in address book whose name contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class TestCommand extends Command {

    public static final String COMMAND_WORD = "test";

    public static final String MESSAGE_USAGE = "Test command";

    public TestCommand() {}

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        return new CommandResult("Test");
    }

    @Override
    public boolean equals(Object other) {
        return other == this;
    }
}
