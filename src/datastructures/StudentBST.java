package datastructures;

import model.Student;

public class StudentBST {
    private static class Node {
        Student data;
        Node left, right;
        Node(Student data) { this.data = data; }
    }

    private Node root;

    public boolean insert(Student student) {
        if (root == null) {
            root = new Node(student);
            return true;
        }

        Node current = root;
        while (true) {
            int comparison = student.getStudentId().compareToIgnoreCase(current.data.getStudentId());
            if (comparison == 0) return false;

            if (comparison < 0) {
                if (current.left == null) {
                    current.left = new Node(student);
                    return true;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new Node(student);
                    return true;
                }
                current = current.right;
            }
        }
    }

    public void clear() { root = null; }

    public void displayInOrder() {
        if (root == null) {
            System.out.println("No student records in BST.");
            return;
        }
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }
}
