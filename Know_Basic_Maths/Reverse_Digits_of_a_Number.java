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
