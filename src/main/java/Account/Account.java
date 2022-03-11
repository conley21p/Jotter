package Account;

public class Account {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;

    public Account(String user, String pass, String fName, String lName, String email) {
        this.username = user;
        this.password = pass;
        this.firstName = fName;
        this.lastName = lName;
        this.email = email;
    }

    public String exportAsCsvString() {
        return username + "," + password + "," + firstName + "," + lastName + "," + email;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fName) {
        this.firstName = fName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setlLastName(String lName) {
        this.lastName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
