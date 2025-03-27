package Know_Basic_Recursion;

public class factorial_of_number {

    public static int fact(int n)
    {
        if(n==1)
        {
            return 1;
        }

        return n*fact(n-1);
    }

    public static void main(String[] args) {
        int n = 5; 
        System.out.println("The factorial of " + n + " is " + fact(n));
    }
    
}
