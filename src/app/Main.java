package app;

import datastructures.*;
import model.Student;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    private static final StudentLinkedList studentList = new StudentLinkedList();
    private static final ActionStack actionStack = new ActionStack();
    private static final ServiceQueue serviceQueue = new ServiceQueue();
    private static final StudentBST studentBST = new StudentBST();
    private static final StudentHashTable hashTable = new StudentHashTable();
    private static final CampusGraph campusGraph = new CampusGraph();

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println(" University Student Record & Campus Route System");
        System.out.println("==============================================");

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = readInt("Enter your choice (1-16): ", 1, 16);

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> updateStudent();
                case 3 -> deleteStudent();
                case 4 -> studentList.displayAll();
                case 5 -> addServiceRequest();
                case 6 -> processServiceRequest();
                case 7 -> actionStack.display();
                case 8 -> studentBST.displayInOrder();
                case 9 -> searchStudentUsingHashing();
                case 10 -> addCampusLocation();
                case 11 -> removeCampusLocation();
                case 12 -> addCampusConnection();
                case 13 -> removeCampusConnection();
                case 14 -> campusGraph.displayConnections();
                case 15 -> traverseCampus();
                case 16 -> {
                    running = false;
                    System.out.println("System closed. Thank you.");
                }
            }
            if (running) pause();
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n--------------- MAIN MENU ---------------");
        System.out.println("1. Add Student Record");
        System.out.println("2. Update Student Record");
        System.out.println("3. Delete Student Record");
        System.out.println("4. Display All Records using Linked List");
        System.out.println("5. Add Service Request to Queue");
        System.out.println("6. Process Next Service Request");
        System.out.println("7. Display Recent Actions using Stack");
        System.out.println("8. Display Students using BST");
        System.out.println("9. Search Student using Hashing");
        System.out.println("10. Add Campus Location");
        System.out.println("11. Remove Campus Location");
        System.out.println("12. Add Campus Connection/Road");
        System.out.println("13. Remove Campus Connection/Road");
        System.out.println("14. Display Campus Connections");
        System.out.println("15. Traverse Campus Locations using BFS/DFS");
        System.out.println("16. Exit");
        System.out.println("------------------------------------------");
    }

    private static void addStudent() {
        System.out.println("\n--- Add Student ---");
        String id = readNonEmpty("Student ID: ");

        if (studentList.find(id) != null) {
            System.out.println("Error: Student ID already exists.");
            return;
        }

        String name = readNonEmpty("Name: ");
        String programme = readNonEmpty("Programme: ");
        double marks = readDouble("Marks (0-100): ", 0, 100);

        Student student = new Student(id, name, programme, marks);
        studentList.add(student);
        studentBST.insert(student);
        hashTable.put(student);
        actionStack.push("Added student: " + id);

        System.out.println("Student added successfully.");
    }

    private static void updateStudent() {
        System.out.println("\n--- Update Student ---");
        String id = readNonEmpty("Student ID: ");
        Student student = studentList.find(id);

        if (student == null) {
            System.out.println("Error: Student not found.");
            return;
        }

        String name = readNonEmpty("New name: ");
        String programme = readNonEmpty("New programme: ");
        double marks = readDouble("New marks (0-100): ", 0, 100);

        studentList.update(id, name, programme, marks);
        rebuildBST();
        hashTable.put(student);
        actionStack.push("Updated student: " + id);

        System.out.println("Student updated successfully.");
    }

    private static void deleteStudent() {
        System.out.println("\n--- Delete Student ---");
        String id = readNonEmpty("Student ID: ");
        Student deleted = studentList.delete(id);

        if (deleted == null) {
            System.out.println("Error: Student not found.");
            return;
        }

        hashTable.remove(id);
        rebuildBST();
        actionStack.push("Deleted student: " + id);
        System.out.println("Deleted: " + deleted);
    }

    private static void rebuildBST() {
        studentBST.clear();
        studentList.forEach(studentBST::insert);
    }

    private static void addServiceRequest() {
        System.out.println("\n--- Add Service Request ---");
        String request = readNonEmpty("Request: ");
        serviceQueue.enqueue(request);
        actionStack.push("Added service request: " + request);
        System.out.println("Request added to queue.");
    }

    private static void processServiceRequest() {
        System.out.println("\n--- Process Next Service Request ---");
        String request = serviceQueue.dequeue();

        if (request == null) {
            System.out.println("No pending service requests.");
            return;
        }

        actionStack.push("Processed service request: " + request);
        System.out.println("Processed request: " + request);
    }

    private static void searchStudentUsingHashing() {
        System.out.println("\n--- Search Student using Hashing ---");
        String id = readNonEmpty("Student ID: ");
        Student student = hashTable.search(id);

        if (student == null) System.out.println("Student not found.");
        else System.out.println("Student found: " + student);
    }

    private static void addCampusLocation() {
        System.out.println("\n--- Add Campus Location ---");
        String location = readNonEmpty("Location name: ");

        if (campusGraph.addLocation(location)) {
            actionStack.push("Added campus location: " + location);
            System.out.println("Location added successfully.");
        } else {
            System.out.println("Error: Location already exists or is invalid.");
        }
    }

    private static void removeCampusLocation() {
        System.out.println("\n--- Remove Campus Location ---");
        String location = readNonEmpty("Location name: ");

        if (campusGraph.removeLocation(location)) {
            actionStack.push("Removed campus location: " + location);
            System.out.println("Location removed successfully.");
        } else {
            System.out.println("Error: Location not found.");
        }
    }

    private static void addCampusConnection() {
        System.out.println("\n--- Add Campus Connection ---");
        String first = readNonEmpty("First location: ");
        String second = readNonEmpty("Second location: ");

        if (campusGraph.addConnection(first, second)) {
            actionStack.push("Added connection: " + first + " - " + second);
            System.out.println("Connection added successfully.");
        } else {
            System.out.println("Error: Check locations, duplicate connection, or same location.");
        }
    }

    private static void removeCampusConnection() {
        System.out.println("\n--- Remove Campus Connection ---");
        String first = readNonEmpty("First location: ");
        String second = readNonEmpty("Second location: ");

        if (campusGraph.removeConnection(first, second)) {
            actionStack.push("Removed connection: " + first + " - " + second);
            System.out.println("Connection removed successfully.");
        } else {
            System.out.println("Error: Connection or location not found.");
        }
    }

    private static void traverseCampus() {
        System.out.println("\n--- Campus Traversal ---");
        String start = readNonEmpty("Starting location: ");
        System.out.println("1. BFS");
        System.out.println("2. DFS");
        int choice = readInt("Choose traversal (1-2): ", 1, 2);

        if (choice == 1) campusGraph.bfs(start);
        else campusGraph.dfs(start);
    }

    private static String readNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) return value;
            System.out.println("Input cannot be empty. Try again.");
        }
    }

    private static int readInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            try {
                int number = Integer.parseInt(value);
                if (number >= min && number <= max) return number;
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Invalid input. Enter a number from " + min + " to " + max + ".");
        }
    }

    private static double readDouble(String prompt, double min, double max) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            try {
                double number = Double.parseDouble(value);
                if (number >= min && number <= max) return number;
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Invalid marks. Enter a value from " + min + " to " + max + ".");
        }
    }

    private static void pause() {
        System.out.println("\nPress ENTER to continue...");
        scanner.nextLine();
    }
}
