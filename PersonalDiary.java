package project;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class PersonalDiary {
    private static final String DIARY_FILE = "diary.txt";
    private static final String PASSWORD_FILE = "password.txt";
    private static String password;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Set up the diary (load or set a password)
        setupDiary(scanner);

        while (true) {
            System.out.println("\n=== Personal Diary ===");
            System.out.println("1. Add Entry");
            System.out.println("2. View Entries");
            System.out.println("3. Search Entries");
            System.out.println("4. Delete Entry");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addEntry(scanner);
                case 2 -> viewEntries();
                case 3 -> searchEntries(scanner);
                case 4 -> deleteEntry(scanner);
                case 5 -> {
                    System.out.println("Exiting the diary. Goodbye!");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Setup the diary (load password or set a new one)
    private static void setupDiary(Scanner scanner) {
        try {
            File passwordFile = new File(PASSWORD_FILE);
            if (passwordFile.exists()) {
                System.out.print("Enter your password: ");
                String inputPassword = scanner.nextLine();
                password = new String(Files.readAllBytes(passwordFile.toPath())).trim();
                if (!password.equals(inputPassword)) {
                    System.out.println("Incorrect password. Exiting...");
                    System.exit(0);
                }
            } else {
                System.out.print("Set a new password for your diary: ");
                password = scanner.nextLine();
                try (FileWriter writer = new FileWriter(PASSWORD_FILE)) {
                    writer.write(password);
                }
                System.out.println("Password set successfully!");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while setting up the diary: " + e.getMessage());
        }
    }

    // Add a new diary entry
    private static void addEntry(Scanner scanner) {
        System.out.print("Enter the date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.println("Write your diary entry (type 'END' on a new line to finish):");

        StringBuilder entryContent = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).equals("END")) {
            entryContent.append(line).append("\n");
        }

        String entry = "Date: " + date + "\n" + entryContent + "---\n";
        try (FileWriter writer = new FileWriter(DIARY_FILE, true)) {
            writer.write(entry);
            System.out.println("Diary entry added successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the entry: " + e.getMessage());
        }
    }

    // View all diary entries
    private static void viewEntries() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DIARY_FILE))) {
            String line;
            System.out.println("\n=== Diary Entries ===");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No entries found. Start by adding a new entry.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the diary: " + e.getMessage());
        }
    }

    // Search for entries by keyword
    private static void searchEntries(Scanner scanner) {
        System.out.print("Enter a keyword to search: ");
        String keyword = scanner.nextLine();
        boolean found = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(DIARY_FILE))) {
            String line;
            System.out.println("\n=== Search Results ===");
            while ((line = reader.readLine()) != null) {
                if (line.contains(keyword)) {
                    found = true;
                    System.out.println(line);
                }
            }
            if (!found) {
                System.out.println("No entries found with the keyword: " + keyword);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No entries found. Start by adding a new entry.");
        } catch (IOException e) {
            System.out.println("An error occurred while searching the diary: " + e.getMessage());
        }
    }

    // Delete an entry by date
    private static void deleteEntry(Scanner scanner) {
        System.out.print("Enter the date of the entry to delete (YYYY-MM-DD): ");
        String dateToDelete = scanner.nextLine();
        StringBuilder updatedContent = new StringBuilder();
        boolean entryFound = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(DIARY_FILE))) {
            String line;
            boolean skip = false;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Date: " + dateToDelete)) {
                    entryFound = true;
                    skip = true;
                }
                if (skip && line.equals("---")) {
                    skip = false;
                    continue;
                }
                if (!skip) {
                    updatedContent.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the diary: " + e.getMessage());
        }

        if (entryFound) {
            try (FileWriter writer = new FileWriter(DIARY_FILE)) {
                writer.write(updatedContent.toString());
                System.out.println("Entry deleted successfully.");
            } catch (IOException e) {
                System.out.println("An error occurred while updating the diary: " + e.getMessage());
            }
        } else {
            System.out.println("No entry found for the specified date.");
        }
    }
}
