import java.util.*;
public class MainP {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        while (true) {
            System.out.print("\nEnter decimal number (0 to exit): ");
            int decimal = inp.nextInt();
            inp.nextLine();
            
            if (decimal == 0) {
                break; 
            }

            System.out.println("Decimal to Binary Conversion Process:");
            System.out.println("Initial Decimal: " + decimal);
            
            if (BinaryConversion.isBinaryPalindrome(Integer.toString(decimal))) {
                System.out.println("Palindrome found!");
                
            }else{

            int count = 0;
            int prevDecimalResult = -1;
            boolean palindromeFound = false;

            while (!palindromeFound) {
                if (count == 10) {
                    System.out.println("Palindrome Not Found! Repeated 10 times.");
                    break;
                } else {
                    String rev = BinaryConversion.reverseBinary(Integer.toString(decimal));
                    System.out.println("Rev: " + rev);

                    String binary = BinaryConversion.decimalToBinary(Integer.parseInt(rev));
                    System.out.println("Decimal to Binary: " + binary);

                    String isPalindrome = BinaryConversion.reverseBinary(binary);
                    System.out.println("Is Binary Palindrome: " + isPalindrome);

                    String reversedBinary = BinaryConversion.reverseBinary(binary);
                    System.out.println("Reversed Binary: " + reversedBinary);

                    int decimalResult = BinaryConversion.binaryToDecimal(reversedBinary);
                    System.out.println("Reversed Binary to Decimal: " + decimalResult);

                    if (decimalResult == prevDecimalResult) {
                        count++;
                    } else {
                        prevDecimalResult = decimalResult;
                        count = 0;
                    }

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
}
