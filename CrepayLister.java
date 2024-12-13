import java.util.*;

// Abstract class to enforce abstraction
abstract class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean validatePassword(String password) {
        return this.password.equals(password);
    }

    public abstract void displayMenu();
}

// Subclass for a standard user
class StandardUser extends User {
    private List<String> reminders;

    public StandardUser(String username, String password) {
        super(username, password);
        this.reminders = new ArrayList<>();
    }

    public void addReminder(String reminder) {
        reminders.add(reminder);
    }

    public List<String> getReminders() {
        return reminders;
    }

    @Override
    public void displayMenu() {
        System.out.println("\n--- User Menu ---");
        System.out.println("1. Add Payment Reminder");
        System.out.println("2. View Reminders");
        System.out.println("3. Logout");
    }
}

public class CrepayLister {
    private static Map<String, StandardUser> users = new HashMap<>(); // Encapsulation through private fields
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n---------------------Welcome to Crepay Lister-------------------------");
            System.out.println("                            1. Register");
            System.out.println("                            2. Login");
            System.out.println("                            3. Exit");
            System.out.print("                          Choose an option: ");

            switch (getIntInput()) {
                case 1 -> register();
                case 2 -> login();
                case 3 -> exitProgram();
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void register() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine().trim();

        if (users.containsKey(username)) {
            System.out.println("Username already exists. Try a different one.");
            return;
        }   

        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();

        users.put(username, new StandardUser(username, password));
        System.out.println("Registration successful!");
    }

    private static void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine().trim();

        System.out.print("Enter password: ");
        String password = scanner.nextLine().trim();

        StandardUser user = users.get(username);
        if (user != null && user.validatePassword(password)) {
            System.out.println("Login successful! Welcome, " + username + "!");
            userMenu(user);
        } else {
            System.out.println("Invalid username or password. Try again.");
        }
    }

    private static void userMenu(StandardUser user) {
        while (true) {
            user.displayMenu();
            System.out.print("Choose an option: ");

            switch (getIntInput()) {
                case 1 -> addReminder(user);
                case 2 -> viewReminders(user);
                case 3 -> {
                    System.out.println("Logged out successfully.");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addReminder(StandardUser user) {
        System.out.print("Enter payment name: ");
        String paymentName = scanner.nextLine().trim();

        System.out.print("Enter account: ");
        String account = scanner.nextLine().trim();

        System.out.print("Enter amount: ");
        String amount = scanner.nextLine().trim();

        System.out.print("Enter due date (YYYY-MM-DD): ");
        String dueDate = scanner.nextLine().trim();

        String reminder = String.format("Payment: %s | Account: %s |Amount: %s| Due Date: %s", paymentName, account,amount, dueDate);
        user.addReminder(reminder);
        System.out.println("Reminder added successfully!");
    }

    private static void viewReminders(StandardUser user) {
        List<String> userReminders = user.getReminders();

        if (userReminders.isEmpty()) {
            System.out.println("No reminders found.");
        } else {
            System.out.println("\n--- Your Reminders ---");
            for (int i = 0; i < userReminders.size(); i++) {
                System.out.println((i + 1) + ". " + userReminders.get(i));
            }
        }
    }

    private static int getIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a number: ");
            }
        }
    }

    private static void exitProgram() {
        System.out.println("Exiting program. Goodbye!");
        System.exit(0);
    }
}
