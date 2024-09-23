package Know_Basic_Maths;

import java.util.*;

public class Count_Digits {

    public static void count_digits(int n)
    {
    
        int count = 0 ; 
        int num = n ; 
        while(n!=0)
        {
            n=n/10;
            count++;
        }
        System.out.println("The number "+num+" has "+count+" digits.");
        /* See the notes for definition of optimal solution */
        System.err.println("The number "+num+" has "+(int)(Math.log10(num)+1)+" digits.");

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        count_digits(n);
    }
    
}
