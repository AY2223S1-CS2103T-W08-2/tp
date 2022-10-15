package seedu.address.model.person.github;

public class GithubUser {
    private String username = "";

    private final String GITHUB_PREFIX = "https://github.com/";
    public static final String VALIDATION_REGEX = "^@(?=.{5,32}$)(?!.*__)[A-Za-z][A-Za-z0-9_]*[A-Za-z0-9]$";
    private static final String SPECIAL_CHARACTERS = "+_.-";
    public static final String MESSAGE_CONSTRAINTS = "Emails should be of the format local-part@domain "
            + "and adhere to the following constraints:\n"
            + "1. The local-part should only contain alphanumeric characters and these special characters, excluding "
            + "the parentheses, (" + SPECIAL_CHARACTERS + "). The local-part may not start or end with any special "
            + "characters.\n"
            + "2. This is followed by a '@' and then a domain name. The domain name is made up of domain labels "
            + "separated by periods.\n"
            + "The domain name must:\n"
            + "    - end with a domain label at least 2 characters long\n"
            + "    - have each domain label start and end with alphanumeric characters\n"
            + "    - have each domain label consist of alphanumeric characters, separated only by hyphens, if any.";

    public GithubUser(String username) {
        this.username = username;
    }

    public void setGithub(String newUsername) {
        this.username = newUsername;
    }

    public String getGithub() {
        return this.username;
    }

    public String getLink() {
        return this.GITHUB_PREFIX + this.username;
    }
    
    public static boolean isValidGithub(String username) {
        return username.matches(VALIDATION_REGEX);
    }

    public String ifPresent(Object object) {
        return null;
    }
}
