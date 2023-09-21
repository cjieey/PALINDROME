import java.util.*;
public class Newmain {
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
            } else {
                int count = 0;
                int prevdecresult = -1;
                boolean palindromeFound = false;
                List<Integer> prevdec = new ArrayList<>();

                while (!palindromeFound) {
                    boolean found = false;
                    for (int i : prevdec) {
                        if (i == decimal) {
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        System.out.println("Stuck in a loop. Palindrome not found.");
                        break;
                    } else {
                        prevdec.add(decimal);

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
                        
                            if (decimalResult == prevdecresult) {
                            count++;
                        } else {
                            prevdecresult = decimalResult;
                            count = 0;
                        }

                        boolean isdecpal = BinaryConversion.isBinaryPalindrome(Integer.toString(decimalResult));
                        System.out.println("Is Reversed Decimal Palindrome: " + isdecpal);

                        if (isdecpal) {
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