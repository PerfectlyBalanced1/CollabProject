import java.util.ArrayList;

public class AuthenticationService implements IAuthenticationService {
    private ArrayList<User> users;

    // Constructor to initialize the users list with a default user
    public AuthenticationService() {
        users = new ArrayList<>();
        // Add a default user (example: username "admin", password "admin")
        users.add(new User("admin", "admin"));
    }

    // signUp method to add a new user if the username is not taken
    public User signUp(String username, String password) {
        // Check if the username is already taken
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return null; // Username is taken, return null
            }
        }
        // Username is not taken, create a new user and add to the list
        User newUser = new User(username, password);
        users.add(newUser);
        return newUser; // Return the new user
    }

    // logIn method to return the user if the username and password match
    public User logIn(String username, String password) {
        // Check if the username and password match any user
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user; // Username and password match, return the user
            }
        }
        return null; // No matching user found, return null
    }
}
