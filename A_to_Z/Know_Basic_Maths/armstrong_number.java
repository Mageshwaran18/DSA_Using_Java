package Know_Basic_Maths;

import java.util.Scanner;

/*An Amrstrong number is a number that is equal to the sum of its own digits each raised to the power of the number of digits. */

public class armstrong_number {


    public static void armstrong_number(int num)
    {
        int res = 0 ; 
        int n = num  , rem ; 
        // Calculate the number of
        // digits in the given number
        int count  = String.valueOf(num).length();
        n = num;
        while(n!=0)
        {
            rem = n%10;
            res += Math.pow(rem, count) ; 
            n=n/10;
        }
        if(res == num )
        {
            System.out.println("The given number is armstrong number");
        }
        else
        {
            System.out.println("The given number is not an armstrong number");
        }
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int n = sc.nextInt();
        armstrong_number(n);


    }
    
}
