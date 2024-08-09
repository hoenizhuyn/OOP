package chap2;
public class q17 {
    public static void main(String[] args) {
        if (args.length == 2) {
            double a = Double.parseDouble(args[0]);
            double b = Double.parseDouble(args[1]);

            if (a == 0) {
                System.out.println("The equation has no solution.");
            } else {
                double root = -b / a;
                System.out.println("The equation has one solution: " + root);
            }
        } else {
            System.out.println("Please provide exactly two real numbers as command-line arguments.");
        }
    }
}