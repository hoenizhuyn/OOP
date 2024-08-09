import java.io.*;
import java.util.*;

class Person {
    String id;
    String name;

    Person(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Student extends Person {
    double midtermMark;
    double finalMark;

    Student(String id, String name, double midtermMark, double finalMark) {
        super(id, name);
        this.midtermMark = midtermMark;
        this.finalMark = finalMark;
    }

    double getAverageMark() {
        return (midtermMark + finalMark) / 2;
    }
}

class Course {
    String id;
    String name;
    String lecturerId;
    String lecturerName;
    List<Student> students;

    Course(String id, String name, String lecturerId, String lecturerName) {
        this.id = id;
        this.name = name;
        this.lecturerId = lecturerId;
        this.lecturerName = lecturerName;
        this.students = new ArrayList<>();
    }

    void addStudent(Student student) {
        students.add(student);
    }

    void printStudents() {
        for (Student student : students) {
            if (student.getAverageMark() >= 10 && student.midtermMark > 7) {
                System.out.println(student.name + " - Grade passing student");
            } else {
                System.out.println(student.name + " - Retake student");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            // Create a BufferedReader object to read input from the user
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            // Read the course information
            System.out.println("Enter the course ID:");
            String courseId = reader.readLine();
            System.out.println("Enter the course name:");
            String courseName = reader.readLine();
            System.out.println("Enter the lecturer ID:");
            String lecturerId = reader.readLine();
            System.out.println("Enter the lecturer name:");
            String lecturerName = reader.readLine();

            // Create a Course object
            Course course = new Course(courseId, courseName, lecturerId, lecturerName);

            // Read the student information
            while (true) {
                System.out.println("Enter the student ID (or 'exit' to finish):");
                String studentId = reader.readLine();
                if (studentId.equals("exit")) {
                    break;
                }

                System.out.println("Enter the student name:");
                String studentName = reader.readLine();
                System.out.println("Enter the midterm mark:");
                double midtermMark = Double.parseDouble(reader.readLine());
                System.out.println("Enter the final mark:");
                double finalMark = Double.parseDouble(reader.readLine());

                // Create a Student object and add it to the course
                Student student = new Student(studentId, studentName, midtermMark, finalMark);
                course.addStudent(student);
            }

            // Print the students' status
            course.printStudents();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
