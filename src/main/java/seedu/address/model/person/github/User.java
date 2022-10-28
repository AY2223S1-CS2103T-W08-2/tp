package seedu.address.model.person.github;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import seedu.address.github.UserInfoWrapper;
import seedu.address.github.UserReposWrapper;
import seedu.address.model.person.Address;
import seedu.address.model.person.Name;
import seedu.address.model.person.contact.Email;

/**
 * Represents a GitHub's User
 */
public class User {

    public static final String MESSAGE_CONSTRAINTS = "GitHub usernames should be of the format @username "
        + "and adhere to the following constraints:\n"
        + "1. Username may only contain alphanumeric characters or hyphens\n"
        + "2. Username cannot have multiple consecutive hyphens\n"
        + "3. Username cannot begin or end with a hyphen\n"
        + "4. Username can have a maximum of 39 characters";
    private static final String BASE_GITHUB_URL = "https://github.com/";
    private static final String VALIDATION_REGEX = "^[a-zA-Z\\d](?:[a-zA-Z\\d]|-(?=[a-zA-Z\\d])){0,38}$";
    private final String username;
    private final String url;
    private final Name name;
    private final Email email;
    private final Address address;
    private final List<Repo> repoList = new ArrayList<>();

    /**
     * Constructs a GitHub's user
     *
     * @param username Username corresponding to user to be added
     */
    public User(String username, UserInfoWrapper userInfoWrapper, UserReposWrapper userReposWrapper) {
        requireAllNonNull(username, userInfoWrapper, userReposWrapper);
        this.username = userInfoWrapper.getUsername();
        this.url = userInfoWrapper.getUrl();
        this.name = new Name(userInfoWrapper.getName().orElse(this.username));
        this.email = userInfoWrapper.getEmail().isPresent() ? new Email(userInfoWrapper.getEmail().get()) : null;
        this.address =
            userInfoWrapper.getLocation().isPresent() ? new Address(userInfoWrapper.getLocation().get()) : null;
        userInfoWrapper.downloadAvatar();
        updateRepoList(userReposWrapper);
    }

    /**
     * @param username Username for the GitHub User class to be initiated with
     * @param repoList RepoList for the GitHub User class to be initiated with
     */
    public User(String username, List<Repo> repoList) {
        requireAllNonNull(username, repoList);
        this.username = username;
        this.name = new Name(username);
        this.url = BASE_GITHUB_URL + username;
        this.repoList.addAll(repoList);
        this.email = null;
        this.address = null;
    }

    /**
     * Returns true if a given string is a valid GitHub's username
     */
    public static boolean isValidUsername(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    public Name getName() {
        return this.name;
    }

    public String getUsername() {
        return this.username;
    }

    public String getUrl() {
        return this.url;
    }

    public Optional<Email> getEmail() {
        return Optional.ofNullable(this.email);
    }

    public Optional<Address> getAddress() {
        return Optional.ofNullable(this.address);
    }

    public List<Repo> getRepoList() {
        return Collections.unmodifiableList(this.repoList);
    }

    private void updateRepoList(UserReposWrapper userReposWrapper) {
        for (int repoId : getRepoIds(userReposWrapper)) {
            repoList.add(new Repo(
                userReposWrapper.getRepoName(repoId),
                userReposWrapper.getRepoUrl(repoId),
                userReposWrapper.getDescription(repoId),
                userReposWrapper.getLastUpdated(repoId)
            ));
        }
    }

    public ArrayList<Integer> getRepoIds(UserReposWrapper userReposWrapper) {
        return userReposWrapper.getIDs();
    }

    @Override
    public String toString() {
        return BASE_GITHUB_URL + username;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof User)) { //this handles null as well.
            return false;
        }

        User other = (User) obj;

        return username.equals(other.getUsername())
            && url.equals(other.getUrl())
            && name.equals(other.getName())
            && email.equals(other.getEmail().orElse(null))
            && address.equals(other.getAddress().orElse(null))
            && repoList.equals(other.getRepoList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, url, name, email, address);
    }
}
