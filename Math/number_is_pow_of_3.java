package Math;

/*Leetcode number -->  1780 */

/*
 */

public class number_is_pow_of_3 {

    public static void check_pow_of_3(int n)
    {
        while(n > 0)
        {
            if(n%3==2)
            {
                System.out.println("The number is not power of 3");
                return;
            }
            else
            {
                n = n / 3;
            }
        }
        System.out.println("The number is a power of 3");
    }

    public static void main(String[] args) {
        // Test cases
        int[] testNumbers = {1, 3, 9, 21, 91, 4, 10, 30};
        
        for (int num : testNumbers) {
            System.out.println("Checking if " + num + " is a power of 3:");
            check_pow_of_3(num);
            System.out.println(); // Add a blank line for readability
        }
    }
}
