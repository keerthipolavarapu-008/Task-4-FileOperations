import java.io.*;
import java.util.Scanner;

public class NotesApp {

    private static final String FILE_NAME = "notes.txt";

    // Write a note (append mode)
    private static void addNote(String note) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            fw.write(note + System.lineSeparator());
            System.out.println("✅ Note saved.");
        } catch (IOException e) {
            System.out.println("❌ Error writing note: " + e.getMessage());
        }
    }

    // Read all notes
    private static void viewNotes() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("📒 Your Notes:");
            while ((line = br.readLine()) != null) {
                System.out.println("- " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("⚠️ No notes found yet.");
        } catch (IOException e) {
            System.out.println("❌ Error reading notes: " + e.getMessage());
        }
    }

    // Clear all notes (overwrite file)
    private static void clearNotes() {
        try (FileWriter fw = new FileWriter(FILE_NAME, false)) {
            fw.write(""); // overwrite with empty content
            System.out.println("🗑 Notes cleared.");
        } catch (IOException e) {
            System.out.println("❌ Error clearing notes: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Notes Manager ---");
            System.out.println("1) Add Note");
            System.out.println("2) View Notes");
            System.out.println("3) Clear Notes");
            System.out.println("0) Exit");
            System.out.print("Choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("Enter your note: ");
                    String note = sc.nextLine();
                    addNote(note);
                }
                case "2" -> viewNotes();
                case "3" -> clearNotes();
                case "0" -> { System.out.println("Bye 👋"); return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
