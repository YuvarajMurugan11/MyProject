# Personal Diary Application

## Description

The Personal Diary Application is a simple console-based tool to maintain and manage personal journal entries. It allows users to securely write, view, search, and delete entries, ensuring privacy through password protection.

---

## Features

1. **Password Protection**

   - Ensures that only authorized users can access the diary.

2. **Add Entry**

   - Add a new diary entry for a specific date.

3. **View Entries**

   - View all stored diary entries in a sequential order.

4. **Search Entries**

   - Search diary entries by keywords.

5. **Delete Entry**

   - Delete an entry by specifying its date.

---

## How to Run

1. **Prerequisites**:

   - Java Development Kit (JDK) installed on your machine.
   - Basic knowledge of using the command line or terminal.

2. **Steps**:

   - Save the file as `PersonalDiary.java`.
   - Open a terminal or command prompt in the file's directory.
   - Compile the program:
     ```
     javac PersonalDiary.java
     ```
   - Run the program:
     ```
     java PersonalDiary
     ```

3. Follow the menu options displayed in the application to interact with your diary.

---

## File Structure

- `PersonalDiary.java`: The main source code file.
- `diary.txt`: The file where diary entries are stored.
- `password.txt`: The file where the diary password is stored.

---

## Usage

1. **Set a Password**:

   - The first time you run the application, you will be prompted to set a password.

2. **Menu Options**:

   - `1. Add Entry`: Add a new diary entry. Type `END` on a new line to finish writing the entry.
   - `2. View Entries`: View all existing entries.
   - `3. Search Entries`: Search for entries containing specific keywords.
   - `4. Delete Entry`: Delete an entry by specifying its date.
   - `5. Exit`: Exit the application.

---

## Example Interaction

### First-Time Setup

```
Set a new password for your diary: mypassword
Password set successfully!
```

### Main Menu

```
=== Personal Diary ===
1. Add Entry
2. View Entries
3. Search Entries
4. Delete Entry
5. Exit
Choose an option: 1
```

### Adding an Entry

```
Enter the date (YYYY-MM-DD): 2024-12-18
Write your diary entry (type 'END' on a new line to finish):
Today was a productive day. I worked on a Java project.
END
Diary entry added successfully!
```

### Viewing Entries

```
=== Diary Entries ===
Date: 2024-12-18
Today was a productive day. I worked on a Java project.
---
```

### Searching for an Entry

```
Enter a keyword to search: productive
=== Search Results ===
Date: 2024-12-18
Today was a productive day. I worked on a Java project.
---
```

### Deleting an Entry

```
Enter the date of the entry to delete (YYYY-MM-DD): 2024-12-18
Entry deleted successfully.
```

---

## Limitations

- **Storage**: Data is stored in plain text files without encryption.
- **Interface**: Limited to console-based interaction.
- **Single User**: Designed for single-user access.

---

## Future Enhancements

1. Encrypt diary entries for enhanced security.
2. Implement a GUI using Java Swing or JavaFX.
3. Support multiple user accounts.
4. Add a feature to back up diary data to a cloud service.

---

## License

This project is open-source and can be modified or distributed under the [MIT License](https://opensource.org/licenses/MIT).

---

## Author

Developed by [Yuvaraj M
