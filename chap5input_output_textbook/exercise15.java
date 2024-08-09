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
    static List<Student> readStudentsFromFile(String fileName) throws FileNotFoundException {
        List<Student> students = new ArrayList<>();

        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            int numStudents = fileScanner.nextInt();
            fileScanner.nextLine(); // consume newline

            for (int i = 0; i < numStudents; i++) {
                String id = fileScanner.next();
                String fullName = fileScanner.next();
                double midtermMark = fileScanner.nextDouble();
                double finalMark = fileScanner.nextDouble();
                fileScanner.nextLine(); // consume newline

                students.add(new Student(id, fullName, midtermMark, finalMark));
            }
        }

        return students;
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
    void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("course_info.txt"))) {
            writer.println("Course ID: " + id);
            writer.println("Course Name: " + name);
            writer.println("Lecturer ID: " + lecturerId);
            writer.println("Lecturer Name: " + lecturerName);

            writer.println("\nStudent Information:");
            for (Student student : students) {
                writer.println("Student ID: " + student.id);
                writer.println("Student Name: " + student.name);
                writer.println("Midterm Mark: " + student.midtermMark);
                writer.println("Final Mark: " + student.finalMark);
                writer.println("Average Mark: " + student.getAverageMark());
                writer.println(); // Empty line between students
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    List<Student> getStudentsFromFile(String fileName) throws FileNotFoundException {
        return Student.readStudentsFromFile(fileName);
    }
}

public class exercise15{
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Read the course information
        System.out.println("Enter the course ID:");
        String courseId = scanner.nextLine();
        System.out.println("Enter the course name:");
        String courseName = scanner.nextLine();
        System.out.println("Enter the lecturer ID:");
        String lecturerId = scanner.nextLine();
        System.out.println("Enter the lecturer name:");
        String lecturerName = scanner.nextLine();

        // Create a Course object
        Course course = new Course(courseId, courseName, lecturerId, lecturerName);

        // Read the student information
        while (true) {
            System.out.println("Enter the student ID (or 'exit' to finish):");
            String studentId = scanner.nextLine();
            if (studentId.equals("exit")) {
                break;
            }

            System.out.println("Enter the student name:");
            String studentName = scanner.nextLine();
            System.out.println("Enter the midterm mark:");
            double midtermMark = scanner.nextDouble();
            System.out.println("Enter the final mark:");
            double finalMark = scanner.nextDouble();
            scanner.nextLine(); // consume the newline

            // Create a Student object and add it to the course
            Student student = new Student(studentId, studentName, midtermMark, finalMark);
            course.addStudent(student);
        }

        // Print the students' status
        course.printStudents();

        // Close the scanner
        scanner.close();
    
        // Save to file
        course.saveToFile();

    
        try {
            // Read from file
            List<Student> studentsFromFile = course.getStudentsFromFile("course_info.txt");
            Student[] studentsArray = studentsFromFile.toArray(new Student[0]);

            // Display the students in the array
            System.out.println("\nStudents from File:");
            for (Student student : studentsArray) {
                // Inside the loop that reads student
                System.out.println("ID: " + student.id + ", Full Name: " + student.name + ", Midterm: " + student.midtermMark + ", Final: " + student.finalMark);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
