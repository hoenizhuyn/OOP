
import java.util.ArrayList;
import java.util.List;

class Person {
    String id;
    String fullName;

    public Person(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }
}

class Student extends Person {
    private double attendanceMark;
    private double midTermMark;
    private double finalMark;

    public Student(String id, String fullName, double attendanceMark, double midTermMark, double finalMark) {
        super(id, fullName);
        this.attendanceMark = attendanceMark;
        this.midTermMark = midTermMark;
        this.finalMark = finalMark;
    }

    public double getAttendanceMark() {
        return attendanceMark;
    }

    public void setAttendanceMark(double attendanceMark) {
        this.attendanceMark = attendanceMark;
    }

    public double getMidTermMark() {
        return midTermMark;
    }

    public void setMidTermMark(double midTermMark) {
        this.midTermMark = midTermMark;
    }

    public double getFinalMark() {
        return finalMark;
    }

    public void setFinalMark(double finalMark) {
        this.finalMark = finalMark;
    }

    public double calculateFinalCourseMark() {
        return (attendanceMark * 0.1) + (midTermMark * 0.4) + (finalMark * 0.5);
    }
}

class Lecturer extends Person {
    public Lecturer(String id, String fullName) {
        super(id, fullName); }
}

class Course {
    private String courseName;
    private List<Lecturer> lecturers;
    private List<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.lecturers = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Lecturer> getLecturers() {
        return lecturers;
    }

    public void setLecturers(List<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    public void addLecturer(Lecturer lecturer) {
        lecturers.add(lecturer);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

}

