package P7;

public class User {
    private final int id;
    private final String name;
    private final String username;
    private final String city;

    public User(int id, String name, String username, String city) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getCity() {
        return city;
    }
}
