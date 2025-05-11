import java.io.*;
import java.util.*;

public class StudentManager {
    private List<Student> students = new ArrayList<>();
    private final String filePath = "students.txt";

    public StudentManager() {
        loadFromFile();
    }

    public void addStudent(Student s) {
        students.add(s);
        saveToFile();
    }

    public void viewStudents() {
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public Student searchById(int id) {
        for (Student s : students) {
            if (s.getId() == id) return s;
        }
        return null;
    }

    public void updateStudent(int id, String newName, int newAge) {
        Student s = searchById(id);
        if (s != null) {
            s.setName(newName);
            s.setAge(newAge);
            saveToFile();
        } else {
            System.out.println("Student not found.");
        }
    }

    public void deleteStudent(int id) {
        students.removeIf(s -> s.getId() == id);
        saveToFile();
    }

    private void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            for (Student s : students) {
                pw.println(s);
            }
        } catch (IOException e) {
            System.out.println("Error saving to file.");
        }
    }

    private void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                students.add(Student.fromString(line));
            }
        } catch (IOException e) {
            System.out.println("No existing data file found.");
        }
    }
}