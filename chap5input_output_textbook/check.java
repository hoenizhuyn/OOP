import java.util.Scanner;

public class check{
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the number of real numbers to be entered: ");
    int n = scanner.nextInt();

    double[] numbers = new double[n];
    double sum = 0;

    System.out.println("Enter " + n + " real numbers:");
    for (int i = 0; i < n; i++) {
        numbers[i] = scanner.nextDouble();
        sum += numbers[i];
    }

    double mean = sum / n;
    double variance = 0;
    for (int i = 0; i < n; i++) {
        variance += Math.pow(numbers[i] - mean, 2);
    }
    variance /= n;
    double standardDeviation = Math.sqrt(variance);

    System.out.printf("Mean: %.2f%n", mean);
    System.out.printf("Standard Deviation: %.2f%n", standardDeviation);

    scanner.close();}
}