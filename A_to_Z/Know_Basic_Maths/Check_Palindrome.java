package Know_Basic_Maths;
import java.util.*;

public class Check_Palindrome {

    public static void Check_Palindrome(int num)
    {
        int res = 0;
        int n = num; 
        int rem;
        while(n!=0)
        {
         rem = n%10;
         res = res*10 + rem ; 
         n=n/10;   
        }
        if(res==num)
        {
            System.out.println("The given number is palindrome");
        }
        else
        {
            System.out.println("The give number is not an palindrome");
        }
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Check_Palindrome(n);


    }

    
}
