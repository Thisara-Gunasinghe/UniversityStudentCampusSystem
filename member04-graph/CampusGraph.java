package datastructures;

import java.util.*;

public class CampusGraph {
    private final Map<String, List<String>> adjacencyList = new LinkedHashMap<>();

    public boolean addLocation(String location) {
        location = clean(location);
        if (location.isEmpty() || adjacencyList.containsKey(location)) return false;
        adjacencyList.put(location, new ArrayList<>());
        return true;
    }

    public boolean removeLocation(String location) {
        location = findKey(location);
        if (location == null) return false;

        adjacencyList.remove(location);
        for (List<String> neighbours : adjacencyList.values()) {
            neighbours.remove(location);
        }
        return true;
    }

    public boolean addConnection(String first, String second) {
        first = findKey(first);
        second = findKey(second);

        if (first == null || second == null || first.equalsIgnoreCase(second)) return false;
        if (adjacencyList.get(first).contains(second)) return false;

        adjacencyList.get(first).add(second);
        adjacencyList.get(second).add(first);
        return true;
    }

    public boolean removeConnection(String first, String second) {
        first = findKey(first);
        second = findKey(second);

        if (first == null || second == null) return false;

        boolean removed = adjacencyList.get(first).remove(second);
        adjacencyList.get(second).remove(first);
        return removed;
    }

    public void displayConnections() {
        if (adjacencyList.isEmpty()) {
            System.out.println("No campus locations.");
            return;
        }
        for (Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void bfs(String start) {
        start = findKey(start);
        if (start == null) {
            System.out.println("Location not found.");
            return;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(start);
        queue.offer(start);

        System.out.print("BFS: ");
        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");
            for (String next : adjacencyList.get(current)) {
                if (visited.add(next)) queue.offer(next);
            }
        }
        System.out.println();
    }

    public void dfs(String start) {
        start = findKey(start);
        if (start == null) {
            System.out.println("Location not found.");
            return;
        }

        Set<String> visited = new HashSet<>();
        System.out.print("DFS: ");
        dfsVisit(start, visited);
        System.out.println();
    }

    private void dfsVisit(String current, Set<String> visited) {
        visited.add(current);
        System.out.print(current + " ");
        for (String next : adjacencyList.get(current)) {
            if (!visited.contains(next)) dfsVisit(next, visited);
        }
    }

    private String findKey(String input) {
        if (input == null) return null;
        for (String key : adjacencyList.keySet()) {
            if (key.equalsIgnoreCase(input.trim())) return key;
        }
        return null;
    }

    private String clean(String value) {
        return value == null ? "" : value.trim();
    }
}
