package Patterns;

public class number_pattern {


    public static void number_pattern()
    {
        int n = 4;
        int top = 0 , left = 0 ; 
        int bottom = n*2-1 , right = n*2-1;
        while(top<=bottom && left<=right)
        {
            for(int i = left ; i <=right ; i++)
            {
                System.out.print(n);
            }
            
        }

    }

    public static void main(String[] args) {
        number_pattern();
    }
    
}
