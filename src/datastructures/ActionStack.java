package datastructures;

import java.util.Stack;

public class ActionStack {
    private final Stack<String> stack = new Stack<>();

    public void push(String action) { stack.push(action); }

    public String pop() {
        return stack.isEmpty() ? null : stack.pop();
    }

    public void display() {
        if (stack.isEmpty()) {
            System.out.println("No recent actions.");
            return;
        }
        System.out.println("Recent Actions (latest first):");
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println("- " + stack.get(i));
        }
    }
}
