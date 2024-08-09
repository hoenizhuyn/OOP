class Vector {
    private double x;
    private double y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double get_x() {
        return x;
    }

    public void set_x(double x) {
        this.x = x;
    }

    public double get_y() {
        return y;
    }

    public void set_y(double y) {
        this.y = y;
    }

    public Vector add(Vector other) {
        return new Vector(this.x + other.get_x(), this.y + other.get_y());
    }

    public Vector subtract(Vector other) {
        return new Vector(this.x - other.get_x(), this.y - other.get_y());
    }

    public Vector multiply(double scalar) {
        return new Vector(this.x * scalar, this.y * scalar);
    }

    public double dot_product(Vector other) {
        return this.x * other.get_x() + this.y * other.get_y();
    }

    public void print_vector() {
        System.out.println("Vector (" + x + ", " + y + ")");
    }
}
public class VectorTestDrive_optimal {
    public static void main(String[] args) {
        Vector vector1 = new Vector(5.0, 9.0);
        Vector vector2 = new Vector(3.0, 4.0);

        System.out.println("Vector 1:");
        vector1.print_vector();

        System.out.println("\nVector 2:");
        vector2.print_vector();

        System.out.println("\nVector Addition:");
        Vector additionResult = vector1.add(vector2);
        additionResult.print_vector();

        System.out.println("\nVector Subtraction:");
        Vector subtractionResult = vector1.subtract(vector2);
        subtractionResult.print_vector();

        System.out.println("\nVector Multiplication by Scalar:");
        Vector multiplicationResult = vector1.multiply(2.0);
        multiplicationResult.print_vector();
    }
}