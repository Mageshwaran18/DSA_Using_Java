package Know_Basic_Maths;
import java.util.*;

/* Print all the divisors of a number ex :- 36 --> 1 , 2 , 3, 4, 6, 9, 12, 18, 36 */

  /*
 * If a number is divisible by another number, then its quotient will also divide the number
 * Ex: 36, 36 is divisible by 1, while dividing 36 by 1 its quotient (36) will also divide 36
 *     36 is divisible by 2, while dividing 36 by 2 its quotient (18) will also divide 36
 *             
 *     if (n % i == 0) then (n / i) will also divide n 
 *            
 *     In some cases, n % i == 0 and the same number (i) will appear as its quotient while dividing 
 *     Ex: 36 --> 36 % 6 == 0, so we add 6 to the resultant and while dividing its quotient will also be 6. So, if we add its quotient to resultant array then it will be duplicate
 *     To avoid those edge cases we put a condition before adding the quotient to resultant array (n / i != i) then we can add n / i to the resultant array
 */

public class divisor_of_number {

    public static ArrayList<Integer> divisor_of_number(int n)
    {

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i  = 1 ; i < Math.sqrt(n);i++ )
        {
            if(n%i==0)
            {
                arr.add(i);
                if(n/i!=i)
                {
                    arr.add(n/i);
                }
            }
        }

        Collections.sort(arr);
        return arr;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to find its divisors: ");
        int number = scanner.nextInt();

        ArrayList<Integer> divisors = divisor_of_number(number);

        System.out.print("Divisors of " + number + " are :- ");
        for (int divisor : divisors) {
            System.out.print(divisor + " ");
        }

        scanner.close();
    }
    
}
