import java.util.Scanner;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

class employeeinfo{
    String id;
    String fullName;
    String department;
    double basicSalary;
    double extraSalary;
    public employeeinfo(String id, String fullName, String department, double basicSalary, double extraSalary) {
        this.id = id;
        this.fullName = fullName;
        this.department = department;
        this.basicSalary = basicSalary;
        this.extraSalary = extraSalary;
    }
    public double calculateIncome() {
        return basicSalary + extraSalary * 2.5;
    }
    public void showinfo(){
        System.out.println("\"%-15s%-25s%-15s-%15f -15%f \\n" + id + fullName + department+ basicSalary+ extraSalary );
    }
}
class employeeinput{
    //declare a class method (can be called by using class name)
    //return data type: array of objects of employeeinfo 
    public static employeeinfo[] inputinfo(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("\nEnter the number of employee: ");
    Integer employee_number = scanner.nextInt();
    employeeinfo current_employeelist[]= new employeeinfo[employee_number];
    for (int i=0; i<employee_number;i++){
        System.out.println("Information of Employee " + (i+1) + ":");
        System.out.println("Employee ID: ");
        String id = scanner.next();
        System.out.print("Employee full name: ");
        String fullname = scanner.next();
        System.out.println("Employee department: ");
        String department = scanner.next();
        System.out.println("Employee basic salary: ");
        double basic = scanner.nextDouble();
        System.out.println("Employee extra salary: ");
        double extra = scanner.nextDouble();
        
        current_employeelist[i] = new employeeinfo(id, fullname, department, basic, extra);
    }
    scanner.close();
    return current_employeelist;
}}

class writefile{
    public static void file(employeeinfo[] employee, String filename) {
        try (PrintWriter p = new PrintWriter(filename)){
            p.printf("\n%-15s%-25s%-15s%-15s%-15s\n", "ID", "Full name", "Department", "Basic Salary", "Extra Salary");

            for (int i=0; i<employee.length; i++) {
                employee[i].showinfo(); // sai roi vi in ra text chu kphai terminal
            }
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}

public class testt4{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input employee information
        employeeinfo[] employees = employeeinput.inputinfo();

        // Write employee information to a file
        writefile.file(employees, "employees.txt");

        // Read employee information from the file
        employeeinfo[] readEmployees = ReadFile.readFile("employees.txt");

        // Display information about each employee
        if (readEmployees != null) {
            System.out.printf("%-15s%-25s%-15s%-15s\n", "ID", "Full name", "Department", "Income");
            for (employeeinfo employee : readEmployees) {
                System.out.printf("%-15s%-25s%-15s%.2f\n",
                        employee.id, employee.fullName, employee.department, employee.calculateIncome());
            }
        }

        scanner.close();
    }
}

