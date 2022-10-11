package seedu.address.ui.exceptions;

/**
 * Exception to be thrown when there is an error parsing the URI provided.
 */
public class UriSyntaxParseException extends RuntimeException {
    public UriSyntaxParseException() {
        super("There was an error in the link.");
    }
}
