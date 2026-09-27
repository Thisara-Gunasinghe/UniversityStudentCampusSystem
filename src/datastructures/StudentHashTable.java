package datastructures;

import java.util.HashMap;
import java.util.Map;
import model.Student;

public class StudentHashTable {
    private final Map<String, Student> table = new HashMap<>();

    public void put(Student student) {
        table.put(normalize(student.getStudentId()), student);
    }

    public void remove(String id) {
        table.remove(normalize(id));
    }

    public Student search(String id) {
        return table.get(normalize(id));
    }

    private String normalize(String id) {
        return id.trim().toUpperCase();
    }
}
