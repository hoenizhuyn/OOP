package chap2;
public class q16 {
    //input 3 numbers, if all equall print false value    
    public static void main(String[] args) {
        if(args.length == 3) {
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);
            int num3 = Integer.parseInt(args[2]);
            if(num1==num2&&num2==num3)
            {
                System.out.println("a false value");
            } else { 
                System.out.println("a true value");
            }; 
        } 
        else{
                System.out.println("Please provide exactly three integer numbers as command-line arguments.");
            }   
} } 
