package Know_Basic_Maths;

import java.util.*;


public class GCD_of_number {

    public static int gcd(int a , int b)
    {
        if (b==0)
        {
            return a;
        }
        else
        {
            a = a%b;
            return gcd(b,a);
        }
    }
   
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number");
        int aa = sc.nextInt();
        System.out.println("Enter the second number");
        int bb = sc.nextInt();

        int a = Math.max(aa,bb);
        int b = Math.min(aa,bb);

        System.out.println("The GCD of two number is " + gcd(a,b));
    }

}
