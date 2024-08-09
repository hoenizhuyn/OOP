import java.io.*;
import java.util.*;

class Student {
    String fullName;
    String dateOfBirth;
    String[] mathCourseNames;
    double[] mathCourseMarks;

    public Student(String fullName, String dateOfBirth, int numCourses) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.mathCourseNames = new String[numCourses];
        this.mathCourseMarks = new double[numCourses];
    }

    public void addMathCourseMark(int index, String courseName, double mark) {
        mathCourseNames[index] = courseName;
        mathCourseMarks[index] = mark;
    }

    public double getAverageMathMark() {
        if (mathCourseMarks.length == 0) {
            return 0.0;
        }

        double sum = 0;
        for (double mark : mathCourseMarks) {
            sum += mark;
        }
        return sum / mathCourseMarks.length;
    }
}

public class question17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of students
        System.out.println("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Create a list to hold students
        List<Student> students = new ArrayList<>();

        // Input student information
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter student information for student " + (i + 1));
            System.out.print("Full Name: ");
            String fullName = scanner.nextLine();
            System.out.print("Date of Birth (month/day/year): ");
            String dateOfBirth = scanner.nextLine();

            System.out.print("Enter the number of math courses for the last two years: ");
            int numMathCourses = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Create a new student
            Student student = new Student(fullName, dateOfBirth, numMathCourses);

            // Input math course names and corresponding marks
            System.out.println("Enter math course information for the last two years:");
            for (int year = 1; year <= 2; year++) {
                System.out.print("Year " + year + ":\n");

                for (int j = 0; j < numMathCourses; j++) {
                    System.out.print("Math Course Name: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Math Course Mark: ");
                    double mark = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    // Add math course mark to the student
                    student.addMathCourseMark(j, courseName, mark);
                }
            }

            // Add the student to the list
            students.add(student);
        }

        // Save student information to a text file
        saveToFile(students);

        // Read from the saved text file and display very good math students
        displayVeryGoodMathStudents("students.txt");

        scanner.close();
    }

    private static void saveToFile(List<Student> students) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("students.txt"))) {
            writer.println(students.size()); // Write the number of students

            for (Student student : students) {
                // Write student information
                writer.println(student.fullName);
                writer.println(student.dateOfBirth);

                // Write math course information
                for (int i = 0; i < student.mathCourseNames.length; i++) {
                    writer.println(student.mathCourseNames[i] + " " + student.mathCourseMarks[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void displayVeryGoodMathStudents(String fileName) {
        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            int numStudents = fileScanner.nextInt();
            fileScanner.nextLine(); // Consume newline

            System.out.println("Very Good Math Students:");

            for (int i = 0; i < numStudents; i++) {
                String fullName = fileScanner.nextLine();
                String dateOfBirth = fileScanner.nextLine();

                int numMathCourses = fileScanner.nextInt();
                fileScanner.nextLine(); // Consume newline

                Student student = new Student(fullName, dateOfBirth, numMathCourses);

                for (int year = 1; year <= 2; year++) {
                    for (int j = 0; j < numMathCourses; j++) {
                        String courseName = fileScanner.next();
                        double mark = fileScanner.nextDouble();
                        fileScanner.nextLine(); // Consume newline

                        // Add math course mark to the student
                        student.addMathCourseMark(j, courseName, mark);
                    }
                }

                if (student.getAverageMathMark() >= 15) {
                    System.out.println("Full Name: " + student.fullName);
                    System.out.println("Date of Birth: " + student.dateOfBirth);
                    System.out.println("Average Math Mark: " + student.getAverageMathMark());
                    System.out.println("---------------");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
