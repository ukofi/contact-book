import java.util.List;
import java.util.Scanner;

/**
 * Entry point for the Contact Book application.
 */
public class Main {

    private static ContactManager manager = new ContactManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=============================");
        System.out.println("     Contact Book v1.0       ");
        System.out.println("=============================");

        boolean running = true;
        while (running) {
            printMenu();
            int choice = getIntInput("Enter choice: ");

            switch (choice) {
                case 1: handleAdd();            break;
                case 2: handleSearch();         break;
                case 3: manager.listAll();      break;
                case 4: handleSearchCategory(); break;
                case 5: handleDelete();         break;
                case 0:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Add contact");
        System.out.println("2. Search contact by name");
        System.out.println("3. List all contacts");
        System.out.println("4. Filter by category");
        System.out.println("5. Delete contact");
        System.out.println("0. Exit");
    }

    private static void handleAdd() {
        System.out.print("First name: ");
        String first = scanner.nextLine().trim();
        System.out.print("Last name: ");
        String last = scanner.nextLine().trim();
        System.out.print("Phone number: ");
        String phone = scanner.nextLine().trim();
        System.out.print("Email: ");
        String email = scanner.nextLine().trim();
        System.out.print("Category (Friend / Work / Family / Other): ");
        String category = scanner.nextLine().trim();
        manager.addContact(new Contact(first, last, phone, email, category));
    }

    private static void handleSearch() {
        System.out.print("Enter name to search: ");
        String name = scanner.nextLine().trim();
        Contact found = manager.findByName(name);
        if (found != null) {
            found.display();
        } else {
            System.out.println("No contact found with name: " + name);
        }
    }

    private static void handleSearchCategory() {
        System.out.print("Enter category (Friend / Work / Family / Other): ");
        String category = scanner.nextLine().trim();
        List<Contact> results = manager.searchByCategory(category);
        if (results.isEmpty()) {
            System.out.println("No contacts found in category: " + category);
        } else {
            System.out.println("\n=== " + category + " contacts ===");
            for (Contact c : results) {
                System.out.println(c);
            }
        }
    }

    private static void handleDelete() {
        System.out.print("Enter full name to delete: ");
        String name = scanner.nextLine().trim();
        manager.deleteContact(name);
    }

    private static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
