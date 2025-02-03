package Array.Strivers.Hard;

import java.util.*;

public class pascals_triangle {

    public static long pascals_triangle(int n,int r)
    {
        // we are going to use the short hand ncr formula for this

        long res = 1;

        // calculating nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;

    }

    public static ArrayList<Integer>one_row_pascals_triangle(int n)
    {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(1);
        long nu = 1;
        for(int i = 0 ; i < n ; i++)
        {

            // the process of separate numerator and denominator is done using one single variable
            nu = nu * ( n - i);
            nu  = nu / (i+1);
            temp.add((int)nu);

            /*
             * long i , long j 
             * 
             * (int) i / j --> Show error because it will convert i into integer and divide that using the long j , which shows the error
             * (int) (i/j) --> Divide first and then typecast it .
             */
        }
        return temp;
    }

    public static List<List<Integer>>pascals_triangle(int row)
    {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i < row ;i++)
        {
            ans.add(one_row_pascals_triangle(i));
        }
        return ans;
    }

    public static void main(String[] args) {
        int row = 5;
        int col = 3;
        
        // Get single value from Pascal's triangle
        long singleValue = pascals_triangle(row, col);
        System.out.println("Value at row " + row + " and column " + col + " is: " + singleValue);
        
        // Get one row of Pascal's triangle
        ArrayList<Integer> oneRow = one_row_pascals_triangle(row);
        System.out.println("Values in row " + row + " are: " + oneRow);
        
        // Get complete Pascal's triangle
        List<List<Integer>> completeTriangle = pascals_triangle(row);
        System.out.println("Complete Pascal's triangle up to row " + row + " is:");
        for(List<Integer> currentRow : completeTriangle) {
            System.out.println(currentRow);
        }
    }
    
}