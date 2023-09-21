import java.util.*;

public class MainProgram {
    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Decimal to Binary");
            System.out.println("2. Hexadecimal to Binary");
            System.out.println("3. Octal to Binary");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = inp.nextInt();
            inp.nextLine();

            if (choice == 0) {
                break; // Exit the program when the user enters 0
            }

            if (choice >= 1 && choice <= 3) {
                System.out.print("Enter the number: ");
                String input = inp.nextLine();

                switch (choice) {
                    case 1:
                        int decimal = Integer.parseInt(input);
                        processConversion(decimal, 10);
                        break;
                    case 2:
                        processConversion(Integer.parseInt(input, 16), 16);
                        break;
                    case 3:
                        processConversion(Integer.parseInt(input, 8), 8);
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            } else {
                System.out.println("Invalid choice. Please select 1, 2, 3, or 0 to exit.");
            }
        }
    }
}