package Bit_Manupulation;

import java.util.Scanner;

public class decimal_to_binary {

    // Function to convert decimal to binary
    public static String toBinary(int number) {
        StringBuilder binary = new StringBuilder();

        // Handle the case for 0
        if (number == 0) {
            return "0";
        }

        // Convert decimal to binary
        while (number > 0) {
            int remainder = number % 2;  // Get remainder (0 or 1)
            binary.append(remainder);    // Append remainder to binary string
            number = number / 2;         // Divide number by 2 for next iteration
        }

        // Reverse the string since binary digits are generated in reverse order
        return binary.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input number
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        // Get binary representation
        String binary = toBinary(number);
        
        // Output result
        System.out.println("Binary representation: " + binary);
        
        scanner.close();
    }
}
