import java.util.*;

public class MainProgram {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        while (true) {
            System.out.print("\nEnter decimal number (0 to exit): ");
            int decimal = inp.nextInt();
            inp.nextLine();
            
            String dec = Integer.toString(decimal);
            
            if (decimal == 0) {
                break; 
            }

            System.out.println("Decimal to Binary Conversion Process:");
            System.out.println("Initial Decimal: " + decimal);

            
            boolean palindromeFound = false;

            while (!palindromeFound) {
               
                String binary = BinaryConversion.decimalToBinary(decimal);
                System.out.println("Decimal to Binary: " + binary);

               
                boolean isPalindrome = BinaryConversion.isBinaryPalindrome(binary);
                System.out.println("Is Binary Palindrome: " + isPalindrome);

                if (isPalindrome) {
                    palindromeFound = true; 
                    System.out.println("Palindrome found!");
                } else {

                    String reversedBinary = BinaryConversion.reverseBinary(binary);
                    System.out.println("Reversed Binary: " + reversedBinary);


                    int decimalResult = BinaryConversion.binaryToDecimal(reversedBinary);
                    System.out.println("Reversed Binary to Decimal: " + decimalResult);

                    boolean isDecimalPalindrome = BinaryConversion.isBinaryPalindrome(Integer.toString(decimalResult));
                    System.out.println("Is Reversed Decimal Palindrome: " + isDecimalPalindrome);

                    if (isDecimalPalindrome) {
                        palindromeFound = true;
                        System.out.println("Palindrome found!");
                    } else {
                        decimal = decimalResult;
                    }
                }
            }
        }
    }
}