package datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class ServiceQueue {
    private final Queue<String> queue = new LinkedList<>();

    public void enqueue(String request) { queue.offer(request); }
    public String dequeue() { return queue.poll(); }

    public void display() {
        if (queue.isEmpty()) {
            System.out.println("No pending service requests.");
            return;
        }
        System.out.println("Pending Service Requests:");
        for (String request : queue) {
            System.out.println("- " + request);
        }
    }
}
