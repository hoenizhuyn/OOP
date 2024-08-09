import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

class employeeinfo {
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

    
}

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input employee information
        System.out.println("Enter the number of employees: ");
        int employeeCount = scanner.nextInt();
        employeeinfo[] employees = new employeeinfo[employeeCount];
        scanner.nextLine(); // consume newline character
        for (int i = 0; i < employeeCount; i++) {
            System.out.println("Information of Employee " + (i + 1) + ":");
            System.out.print("Employee ID: ");
            String id = scanner.nextLine();
            System.out.print("Employee full name: ");
            String fullname = scanner.nextLine();
            System.out.print("Employee department: "); // Changed println to print
            String department = scanner.nextLine();
            System.out.print("Employee basic salary: "); // Changed println to print
            double basic = scanner.nextDouble();
            System.out.print("Employee extra salary: "); // Changed println to print
            double extra = scanner.nextDouble();
            scanner.nextLine(); // consume newline character
            employees[i] = new employeeinfo(id, fullname, department, basic, extra);
        }

        // Write employee information to a file
        try (PrintWriter writer = new PrintWriter(new File("employees.txt"))) {
            writer.println(employeeCount); // Write the number of employees
            for (employeeinfo employee : employees) {
                writer.printf("%s %s %s %.2f %.2f%n", employee.id, employee.fullName, employee.department, employee.basicSalary, employee.extraSalary);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Read employee information from the file
        double[] readincome = new double[employeeCount];
        try {
            Scanner fileScanner = new Scanner(new File("employees.txt"));
            fileScanner.nextInt(); // Consume the number of employees
            fileScanner.nextLine(); // consume newline character
            for (int i = 0; i < employeeCount; i++) {
                fileScanner.next(); // Consume ID
                fileScanner.next(); // Consume full name
                fileScanner.next(); // Consume department
                double basic = fileScanner.nextDouble();
                double extra = fileScanner.nextDouble();
                double income = basic + extra * 2.5;
                readincome[i] = income;
                fileScanner.nextLine(); // consume newline character
            }            
            fileScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            scanner.close();
            return;
        }

        // Display information about each employee
        for (int i = 0; i < employees.length; i++) {
            System.out.printf("%-15s%-25s%-15s%.2f%n", employees[i].id, employees[i].fullName, employees[i].department,readincome[i] );
        }

        scanner.close();
    }
}
