package Patterns;

public class alpha_traingle {
    
    public static void alpha_traingle()
    {
        int n = 5;

        char ch = 'A' + 5;
        // 'A' + 5 is accepted because 'A' is a character literal with ASCII value 65
        // Adding 5 to it results in the character 'F' (ASCII 70)
        
        // char ch = 65; // This is accepted because 65 is within the range of char (0 to 65535)
        // char ch = 65 + 5; // This is not accepted because 65 + 5 is an int expression
        // To make it work with integers, you need to cast:
        // char ch = (char)(65 + 5);

        for(int row = 0 ; row <= n ; row++)
        {
            for(int column = row ; column >= 0 ; column--)
            {
                System.out.print((char)(ch - column));
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        alpha_traingle();
    }
}
