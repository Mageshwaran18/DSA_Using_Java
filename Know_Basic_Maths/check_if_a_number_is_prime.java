package Know_Basic_Maths;

import java.util.*;

/*
 * A number is said to be prime if the number is divisible by 1 and itself and then the no.of divisible is equal to 2
 * 1 is not a prime number because the it's divisible by 1 and itself but the no.of divisible is not equal to 2 
 * 
 * If a number is divisible by  a number then while dividing the quotient will also be divide the number ( refer the divisor of the number problem)
 */
public class check_if_a_number_is_prime {

    public static boolean is_prime(int n)
    {
        int cnt = 0; 
        for(int i = 1 ; i < Math.sqrt(n) ; i++)
        {
            if(n%i==0)
            {
                cnt+=1;

                if(n/i!=i)
                {
                    cnt+=1;
                }
            }

            if(cnt>2)
            {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a number to check if it's prime: ");
    int number = scanner.nextInt();
    boolean result = is_prime(number);
    if (result) {
        System.out.println(number + " is a prime number.");
    } else {
        System.out.println(number + " is not a prime number.");
    }
    scanner.close();
    }
}
