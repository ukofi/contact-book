import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Manages contacts with file persistence.
 * Demonstrates file I/O, sorting, and search functionality.
 */
public class ContactManager {

    private List<Contact> contacts;
    private static final String FILE_PATH = "contacts.csv";

    public ContactManager() {
        this.contacts = new ArrayList<>();
        loadFromFile();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        saveToFile();
        System.out.println("Contact added: " + contact.getFullName());
    }

    public boolean deleteContact(String fullName) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getFullName().equalsIgnoreCase(fullName)) {
                contacts.remove(i);
                saveToFile();
                System.out.println("Contact deleted: " + fullName);
                return true;
            }
        }
        System.out.println("Contact not found: " + fullName);
        return false;
    }

    public Contact findByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getFullName().equalsIgnoreCase(name) ||
                contact.getFirstName().equalsIgnoreCase(name) ||
                contact.getLastName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    public List<Contact> searchByCategory(String category) {
        List<Contact> results = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getCategory().equalsIgnoreCase(category)) {
                results.add(contact);
            }
        }
        return results;
    }

    public void listAll() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts saved.");
            return;
        }
        Collections.sort(contacts, Comparator.comparing(Contact::getLastName));
        System.out.println("\n=== All Contacts (" + contacts.size() + ") ===");
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Contact contact : contacts) {
                writer.write(contact.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving contacts: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Contact contact = Contact.fromCSV(line);
                if (contact != null) {
                    contacts.add(contact);
                }
            }
            if (!contacts.isEmpty()) {
                System.out.println(contacts.size() + " contact(s) loaded from file.");
            }
        } catch (IOException e) {
            System.out.println("Error loading contacts: " + e.getMessage());
        }
    }

    public int getCount() { return contacts.size(); }
}
