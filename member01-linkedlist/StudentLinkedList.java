package datastructures;

import model.Student;

public class StudentLinkedList {
    private static class Node {
        Student data;
        Node next;
        Node(Student data) { this.data = data; }
    }

    private Node head;

    public boolean add(Student student) {
        if (find(student.getStudentId()) != null) return false;

        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
            return true;
        }

        Node current = head;
        while (current.next != null) current = current.next;
        current.next = newNode;
        return true;
    }

    public Student find(String studentId) {
        Node current = head;
        while (current != null) {
            if (current.data.getStudentId().equalsIgnoreCase(studentId)) return current.data;
            current = current.next;
        }
        return null;
    }

    public boolean update(String id, String name, String programme, double marks) {
        Student student = find(id);
        if (student == null) return false;
        student.setName(name);
        student.setProgramme(programme);
        student.setMarks(marks);
        return true;
    }

    public Student delete(String id) {
        Node current = head;
        Node previous = null;

        while (current != null) {
            if (current.data.getStudentId().equalsIgnoreCase(id)) {
                if (previous == null) head = current.next;
                else previous.next = current.next;
                return current.data;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No student records found.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void forEach(java.util.function.Consumer<Student> action) {
        Node current = head;
        while (current != null) {
            action.accept(current.data);
            current = current.next;
        }
    }
}
