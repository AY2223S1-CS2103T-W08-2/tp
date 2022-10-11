package seedu.address.ui.exceptions;

/**
 * Exception signifying a certain I/O operation failing.
 */
public class InputOutputException extends RuntimeException {
    public InputOutputException() {
        super("There was an error while performing certain I/O operations.");
    }
}
