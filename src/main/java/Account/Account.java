package Account;

public class Account {
    private String email;
    private final String username;
    private String password;

    public Account(String user, String pass, String email) {
        this.username = user;
        this.password = pass;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
