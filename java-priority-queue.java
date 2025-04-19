import java.io.*;
import java.util.*;

class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class Priorities {
    private PriorityQueue<Student> queue;

    public Priorities() {
        queue = new PriorityQueue<>(
            Comparator.comparing(Student::getCGPA).reversed()
                      .thenComparing(Student::getName)
                      .thenComparing(Student::getID)
        );
    }

    public List<Student> getStudents(List<String> events) {
        for (String event : events) {
            if (event.startsWith("ENTER")) {
                String[] parts = event.split(" ");
                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);
                Student student = new Student(id, name, cgpa);
                queue.add(student);
            } else if (event.equals("SERVED")) {
                queue.poll();
            }
        }

        List<Student> remaining = new ArrayList<>();
        while (!queue.isEmpty()) {
            remaining.add(queue.poll());
        }
        return remaining;
    }
}


public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalEvents = Integer.parseInt(scanner.nextLine());
        List<String> events = new ArrayList<>();

        for (int i = 0; i < totalEvents; i++) {
            events.add(scanner.nextLine());
        }

        Priorities priorities = new Priorities();
        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student student : students) {
                System.out.println(student.getName());
            }
        }
        scanner.close();
    }
}
