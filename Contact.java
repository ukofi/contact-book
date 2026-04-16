/**
 * Represents a single contact with personal details.
 * Demonstrates encapsulation and data modelling.
 */
public class Contact {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String category; // e.g. "Friend", "Work", "Family"

    public Contact(String firstName, String lastName, String phoneNumber, String email, String category) {
        this.firstName   = firstName.trim();
        this.lastName    = lastName.trim();
        this.phoneNumber = phoneNumber.trim();
        this.email       = email.trim();
        this.category    = category.trim();
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public void display() {
        System.out.println("----------------------------------");
        System.out.println("Name    : " + getFullName());
        System.out.println("Phone   : " + phoneNumber);
        System.out.println("Email   : " + email);
        System.out.println("Category: " + category);
        System.out.println("----------------------------------");
    }

    // Getters
    public String getFirstName()   { return firstName; }
    public String getLastName()    { return lastName; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getEmail()       { return email; }
    public String getCategory()    { return category; }

    // Setters for edit functionality
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber.trim(); }
    public void setEmail(String email)             { this.email = email.trim(); }
    public void setCategory(String category)       { this.category = category.trim(); }

    /**
     * Returns a CSV-formatted line for file storage.
     */
    public String toCSV() {
        return firstName + "," + lastName + "," + phoneNumber + "," + email + "," + category;
    }

    /**
     * Creates a Contact from a CSV-formatted line.
     */
    public static Contact fromCSV(String csvLine) {
        String[] parts = csvLine.split(",");
        if (parts.length != 5) return null;
        return new Contact(parts[0], parts[1], parts[2], parts[3], parts[4]);
    }

    @Override
    public String toString() {
        return getFullName() + " | " + phoneNumber + " | " + category;
    }
}
