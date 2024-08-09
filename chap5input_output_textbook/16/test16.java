import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class test16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input course information
        Course OOP = new Course("OOP");
        Course WEB = new Course("WEB");
        Course IP = new Course("IP");
        Course course_list[] = {OOP, WEB, IP};

        for  (int i=0 ;i<3; i++) {
            System.out.println("Enter the number of lecturers for "+ course_list[i].getCourseName());
            int numOopLecturers = scanner.nextInt();
            scanner.nextLine();
            for (int j = 0; i < numOopLecturers; j++) {
                System.out.println("Enter lecturer name for OOP:");
                String lecturerName = scanner.nextLine();
                String id = scanner.nextLine();
                course_list[i].addLecturer(new Lecturer(id,lecturerName));
            }
            System.out.println("Enter the number of students for"+ course_list[i].getCourseName());
            int numOopStudents = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            for (int k = 0; i < numOopStudents; k++) {
                System.out.println("Enter student ID for OOP:");
                String studentId = scanner.nextLine();
                System.out.println("Enter student name for OOP:");
                String studentName = scanner.nextLine();
                System.out.println("Enter student attendance mark");
                Double attend = scanner.nextDouble();
                System.out.println("Enter student midterm:");
                Double mid= scanner.nextDouble();
                System.out.println("Enter student final:");
                Double fin= scanner.nextDouble();
                course_list[i].addStudent(new Student(studentId, studentName, attend, mid,fin));
        }
    }



        // Write course information to a file
        try (PrintWriter writer = new PrintWriter(new File("course.txt"))) {
            writer.println(course.getCourseName());

            // Write lecturer information
            writer.println(course.getLecturers().size());
            for (Lecturer lecturer : course.getLecturers()) {
                writer.printf("%s %s %s%n", lecturer.id, lecturer.fullName);
            }

            // Write student information
            writer.println(course.getStudents().size());
            for (Student student : course.getStudents()) {
                writer.printf("%s %s %.2f %.2f %.2f%n", student.id, student.fullName,
                        student.getAttendanceMark(), student.getMidTermMark(), student.getFinalMark());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Read course information from the file
        try {
            Scanner fileScanner = new Scanner(new File("course.txt"));
            String readCourseName = fileScanner.nextLine();
            Course readCourse = new Course(readCourseName);

            // Read lecturer information
            int readLecturerCount = fileScanner.nextInt();
            fileScanner.nextLine(); // consume newline character
            for (int i = 0; i < readLecturerCount; i++) {
                String id = fileScanner.next();
                String fullName = fileScanner.next();
                String expertise = fileScanner.nextLine().trim();
                readCourse.getLecturers().add(new Lecturer(id, fullName));
            }

            // Read student information
            int readStudentCount = fileScanner.nextInt();
            fileScanner.nextLine(); // consume newline character
            for (int i = 0; i < readStudentCount; i++) {
                String id = fileScanner.next();
                String fullName = fileScanner.next();
                double attendanceMark = fileScanner.nextDouble();
                double midTermMark = fileScanner.nextDouble();
                double finalMark = fileScanner.nextDouble();
                readCourse.getStudents().add(new Student(id, fullName, attendanceMark, midTermMark, finalMark));
            }

            // Display information about each student
            System.out.println("Course: " + readCourse.getCourseName());
            System.out.println("Lecturers: ");
            for (Lecturer lecturer : readCourse.getLecturers()) {
                System.out.println("ID: " + lecturer.id + ", Full name: " + lecturer.fullName );
            }

            System.out.println("Students: ");
            for (Student student : readCourse.getStudents()) {
                System.out.println("ID: " + student.id + ", Full name: " + student.fullName +
                        ", Attendance: " + student.getAttendanceMark() + ", Mid-Term: " + student.getMidTermMark() +
                        ", Final: " + student.getFinalMark() + ", Final Course Mark: " + student.calculateFinalCourseMark());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
