# Contact Book

A console-based contact management application in Java with file persistence. Contacts are saved to a CSV file and automatically reloaded when the application starts.

## Features

- Add contacts with name, phone, email, and category
- Search contacts by name
- Filter contacts by category (Friend, Work, Family, Other)
- List all contacts sorted alphabetically by last name
- Delete contacts
- Persistent storage — contacts saved to `contacts.csv` and reloaded on startup

## Concepts Demonstrated

- **File I/O** — reading and writing contact data using `BufferedReader` and `BufferedWriter`
- **ArrayList and Collections** — dynamic list management and `Collections.sort()`
- **Encapsulation** — `Contact` class with private fields and controlled access
- **Static factory method** — `Contact.fromCSV()` for object creation from file data
- **Search and filter** — linear search and category-based filtering
- **Comparator** — sorting contacts alphabetically by last name

## How to Run

### Requirements

- Java JDK 8 or higher

### Steps

```bash
# Clone the repository
git clone https://github.com/ukofi/contact-book.git
cd contact-book/src

# Compile
javac *.java

# Run
java Main
```

## Project Structure

```
contact-book/
└── src/
    ├── Contact.java         # Contact model with CSV serialisation
    ├── ContactManager.java  # CRUD operations and file persistence
    └── Main.java            # Entry point and menu interface
```

## Data Storage

Contacts are saved in `contacts.csv` in the following format:

```
FirstName,LastName,PhoneNumber,Email,Category
Unathi,Kofi,0828986302,unathi@email.com,Work
```

## Author

**Unathi Kofi** — [GitHub](https://github.com/ukofi)
