public class BinaryConversion {
    public static String decimalToBinary(int decimalNumber) {
        StringBuilder binary = new StringBuilder();
        while (decimalNumber > 0) {
            int remainder = decimalNumber % 2;
            binary.insert(0, remainder);
            decimalNumber /= 2;
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

    public static int binaryToDecimal(String binaryNumber) {
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

    
}