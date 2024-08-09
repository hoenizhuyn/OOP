// input the number n>1.
// enter 2 vectors a and b from the keyboard with dimension n and a and b are floating point
// Calculate the angle between the 2 vectors.
// Print the angle in degrees.

import java.util.Scanner;

class Vector {
    private int dimension;
    private double[] vector;

    public Vector(int dimension) {
        this.dimension = dimension;
        vector = new double[dimension];
    }

    public void getVector(Scanner scanner) {
        System.out.println("Enter the vector with " + dimension + " dimensions:");
        for (int i = 0; i < dimension; i++) {
            System.out.print("Enter component " + (i + 1) + ": ");
            vector[i] = scanner.nextDouble();
        }
    }

    public double findLength() {
        double length = 0;
        for (int i = 0; i < dimension; i++) {
            length += vector[i] * vector[i];
        }
        return Math.sqrt(length);
    }

    public double findAngle(Vector other) {
        double dotProduct = 0;
        for (int i = 0; i < dimension; i++) {
            dotProduct += other.vector[i] * this.vector[i];
        }
        double cosine = dotProduct / (this.findLength() * other.findLength());
        return Math.toDegrees(Math.acos(cosine));
    }
}

public class Vectorangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the dimension of the vectors (n > 1): ");
        int dimension = scanner.nextInt();

        Vector vectorA = new Vector(dimension);
        Vector vectorB = new Vector(dimension);

        vectorA.getVector(scanner);
        vectorB.getVector(scanner);

        double angle = vectorA.findAngle(vectorB);

        System.out.println("The angle between the vectors is: " + angle + " degrees.");

        scanner.close();
    }
}
