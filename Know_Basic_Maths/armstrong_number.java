package Know_Basic_Maths;

import java.util.Scanner;

public class armstrong_number {


    public static void armstrong_number(int num)
    {
        int res = 0 ; 
        int n = num  , rem , count = 0 ; 
        while(n!=0)
        {
            n = n/10;
            count+=1;
        }
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
