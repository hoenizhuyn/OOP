import java.util.Scanner;

public class stringfind{
    private static int findSubstring(String inputString, String substring) {
        int inputLength = inputString.length();
        int subLength = substring.length();

        for (int i = 0; i <= inputLength - subLength; i++) {
            String sub = inputString.substring(i, i + subLength);
            if (sub.equals(substring)) {
                return 1;
            }
        }   
        return 0;}
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String inputString = scn.nextLine();
        System.out.print("Enter the substring to be searched :");
        String substring = scn.nextLine(); 
        int found = findSubstring(inputString, substring);
        if (found ==1) {
            System.out.println("The substring is present in the string.");
        } else {
            System.out.println("The substring is not present in the string.");
            }
            scn.close();
        }
        
        
        // if (str.contains(substr)){
        //     System.out.println("The given substring is present in the string.");
        // }else{System.out.println("The given substring is not present in the string.");}

    }

