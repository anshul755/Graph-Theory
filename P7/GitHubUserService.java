package P7;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GitHubUserService {
    private static final Pattern LOGIN_PATTERN = Pattern.compile("\\\"login\\\"\\s*:\\s*\\\"([^\\\"]+)\\\"");

    public List<User> fetchUsers(int count) throws IOException, InterruptedException {
        String url = "https://api.github.com/users?per_page=" + count;

        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("User-Agent", "java")
                .timeout(Duration.ofSeconds(20))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() != 200) {
            throw new IOException("GitHub API returned status " + response.statusCode());
        }

        return parseUsers(response.body(), count);
    }

    private List<User> parseUsers(String responseBody, int expectedCount) throws IOException {
        Matcher matcher = LOGIN_PATTERN.matcher(responseBody);
        List<User> users = new ArrayList<>();
        int index = 0;

        while (matcher.find() && index < expectedCount) {
            String login = matcher.group(1);
            users.add(new User(index, login, login, "unknown"));
            index++;
        }

        if (users.size() != expectedCount) {
            throw new IOException("Could not parse " + expectedCount + " users from GitHub response");
        }

        return users;
    }
}
