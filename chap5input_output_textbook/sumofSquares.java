import java.util.Scanner;
public class sumofSquares{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of  numbers to be entered: ");
        int n = scanner.nextInt();
        int sumsquare=0;
        int number[] = new int[n];
        for (int i=0; i<n; i++){
            System.out.println("Enter an integer number:");
            number[i]= scanner.nextInt();
            sumsquare += number[i]*number[i]; }
        scanner.close();
        System.out.printf("Sum of the square of these numbers is" +sumsquare);
    }
}



