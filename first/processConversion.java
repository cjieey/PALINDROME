public static void processConversion(int number, int base) {
        String baseName = base == 10 ? "Decimal" : (base == 16 ? "Hexadecimal" : "Octal");
        System.out.println(baseName + " to Binary Conversion Process:");
        System.out.println("Initial " + baseName + ": " + number);

        // Initialize a flag to indicate if a palindrome is found
        boolean palindromeFound = false;

        while (!palindromeFound) {
            // Decimal to binary
            String binary = BinaryConversion.convertToBinary(number, base);
            System.out.println(baseName + " to Binary: " + binary);

            // Palindrome check
            boolean isPalindrome = BinaryConversion.isBinaryPalindrome(binary);
            System.out.println("Is Binary Palindrome: " + isPalindrome);

            if (isPalindrome) {
                palindromeFound = true; // Set the flag to exit the inner loop
                System.out.println("Palindrome found!");
            } else {
                // If the binary is not a palindrome, try reversing it
                String reversedBinary = BinaryConversion.reverseBinary(binary);
                System.out.println("Reversed Binary: " + reversedBinary);

                // Convert the reversed binary back to decimal
                int decimalResult = BinaryConversion.convertFromBinary(reversedBinary, base);
                System.out.println("Reversed Binary to " + baseName + ": " + decimalResult);

                // Check if the reversed binary's decimal result is a palindrome
                boolean isDecimalPalindrome = BinaryConversion.isPalindrome(decimalResult);
                System.out.println("Is Reversed " + baseName + " Palindrome: " + isDecimalPalindrome);

                if (isDecimalPalindrome) {
                    palindromeFound = true; // Set the flag to exit the inner loop
                    System.out.println("Palindrome found!");
                } else {
                    number = decimalResult; // Update number to continue checking
                }
            }
        }
    }
}

class BinaryConversion {
    public static String convertToBinary(int number, int base) {
        StringBuilder binary = new StringBuilder();
        while (number > 0) {
            int remainder = number % 2;
            binary.insert(0, remainder);
            number /= 2;
        }
        return binary.toString();
    }

    public static boolean isBinaryPalindrome(String binaryNumber) {
        int left = 0;
        int right = binaryNumber.length() - 1;
        while (left < right) {
            if (binaryNumber.charAt(left) != binaryNumber.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static String reverseBinary(String binaryNumber) {
        return new StringBuilder(binaryNumber).reverse().toString();
    }

    public static int convertFromBinary(String binaryNumber, int base) {
        int decimal = 0;
        int power = 0;
        int length = binaryNumber.length();
        for (int i = length - 1; i >= 0; i--) {
            if (binaryNumber.charAt(i) == '1') {
                decimal += Math.pow(2, power);
            }
            power++;
        }
        return decimal;
    }

    public static boolean isPalindrome(int number) {
        int original = number;
        int reversed = 0;

        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }

        return original == reversed;
    }
}