package Know_Basic_Maths;

import java.util.*;

public class Reverse_Digits_of_a_Number {

    public static void Reverse_Digits_of_a_Number(int n)
    {
        int res = 0;
        int digit;
        while (n!=0)
        {
            digit = n %10;
            res = res * 10 +digit;
            n = n/ 10 ;
        }
        System.out.println("The reveresed number is "+res);

    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Reverse_Digits_of_a_Number(n);
        sc.close();
    }
}
/* 
 * Given a signed 32-bit integer x, return x with its digits reversed. 
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0. 
 * 
 * The reason for dividing by 10 and checking whether the last digit exceeds 7 (in the condition 
 * reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) is to prevent 
 * overflow during the reverse operation. Let's break this down.
 * 
 * 1. Why is it divided by 10?
 * The maximum value an int can hold in Java is Integer.MAX_VALUE, which is 2147483647.
 * 
 * When reversing the digits, you're multiplying the current reversed number by 10 before adding the new digit. 
 * This multiplication can potentially cause an overflow if the result exceeds the maximum integer value 2147483647.
 * 
 * Therefore, before multiplying reversed by 10, you first check whether the current value of reversed is already too large. 
 * To do this, you compare it with Integer.MAX_VALUE / 10. This division gives the maximum value reversed can be before 
 * multiplying by 10 without overflowing.
 * 
 * Integer.MAX_VALUE / 10 = 214748364
 * If reversed exceeds 214748364, then multiplying it by 10 will certainly cause an overflow, so we return 0 in that case.
 * 
 * 2. Why check if digit > 7?
 * If reversed is exactly equal to 214748364, then multiplying it by 10 results in 2147483640. Now, if the next digit 
 * to be added is greater than 7, the result will overflow the maximum possible integer value (2147483647).
 * 
 * Hence, we need to check the following:
 * 
 * If reversed == 214748364, and the next digit is greater than 7, adding that digit would result in a number larger 
 * than 2147483647, which would overflow. Therefore, we check digit > 7.
 * 
 * public class ReverseInteger {
 *     public int reverse(int x) {
 *         int reversed = 0;
 * 
 *         while (x != 0) {
 *             int digit = x % 10;  // Get the last digit
 *             x /= 10;  // Remove the last digit from x
 * 
 *             // Check for overflow or underflow
 *             if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
 *                 return 0; // Overflow case for positive numbers
 *             }
 *             if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
 *                 return 0; // Overflow case for negative numbers
 *             }
 * 
 *             reversed = reversed * 10 + digit;
 *         }
 * 
 *         return reversed;
 *     }
 * 
 *     public static void main(String[] args) {
 *         ReverseInteger reverseInteger = new ReverseInteger();
 *         System.out.println(reverseInteger.reverse(123));   // Output: 321
 *         System.out.println(reverseInteger.reverse(-123));  // Output: -321
 *         System.out.println(reverseInteger.reverse(120));   // Output: 21
 *         System.out.println(reverseInteger.reverse(1534236469));  // Output: 0 (overflow)
 *     }
 * }
 */