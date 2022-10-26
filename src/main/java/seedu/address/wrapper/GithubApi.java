package seedu.address.wrapper;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import kong.unirest.Config;
import kong.unirest.HttpRequestSummary;
import kong.unirest.HttpResponse;
import kong.unirest.Interceptor;
import kong.unirest.UnirestInstance;
import seedu.address.model.person.github.User;
import seedu.address.wrapper.exceptions.NetworkConnectionException;
import seedu.address.wrapper.exceptions.RepoNotFoundException;
import seedu.address.wrapper.exceptions.UserInvalidException;

/**
 * Class representing a singleton GitHub API wrapper
 */
public class GithubApi {

    //@@author arnav-ag
    private static final String BASE_CHECK_USER_URL = "https://api.github.com/users/";
    private final UnirestInstance unirest;

    public GithubApi() {
        unirest = getDefaultUnirestInstance();
    }

    public static UnirestInstance getDefaultUnirestInstance() {
        Config config = new Config()
                .interceptor(new Interceptor() {
                    @Override
                    public void onResponse(HttpResponse<?> response, HttpRequestSummary request, Config config) {
                        if (response.getStatus() == 404) {
                            throw new UserInvalidException(
                                    "User does not exist. Please provide an existing GitHub username.");
                        }
                    }

                    @Override
                    public HttpResponse<?> onFail(Exception e, HttpRequestSummary request, Config config)
                            throws RepoNotFoundException {
                        throw new NetworkConnectionException("Error while getting request, unable to get results.");
                    }
                });
        return new UnirestInstance(config);
    }

    public User getUser(String username) throws UserInvalidException, NetworkConnectionException {
        requireAllNonNull(username);
        checkUserExists(username, unirest);
        UserInfoWrapper userInfoWrapper = new UserInfoWrapper(username, unirest);
        UserReposWrapper userReposWrapper = new UserReposWrapper(username, unirest);

        return new User(username, userInfoWrapper, userReposWrapper);
    }

    private void checkUserExists(String username, UnirestInstance unirest)
            throws UserInvalidException, NetworkConnectionException {
        unirest.get(BASE_CHECK_USER_URL + username).asEmpty();
    }
}
