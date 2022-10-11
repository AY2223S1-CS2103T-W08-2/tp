package seedu.address.logic.parser;

import java.util.HashMap;

import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;

/**
 * Parses input arguments and creates a new AddCommand object
 */
public class AddCommandParser implements Parser<AddCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddCommand
     * and returns an AddCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddCommand parse(String args) throws ParseException {
        String[] argList = args.split(" ", 2);
        if (argList.length != 2) {
            throw new ParseException(Name.MESSAGE_CONSTRAINTS);
        }

        String nameString = argList[1];
        Person person = null;
        if (nameString.startsWith("@")) {
            //TODO: GitHub
        } else {
            Name name = new Name(nameString);
            person = new Person(name, new HashMap<>(), null);
        }


        return new AddCommand(person);
    }

}
