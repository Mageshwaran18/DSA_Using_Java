package Patterns;

import java.util.ArrayList;
import java.util.List;


public class spiral_order_traversal {

    public static List<Integer> spiral (int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int top = 0 , bottom = row-1 , left = 0 , right = col-1;
        while(top <= bottom && left<=right)
        {
            for(int i = left ; i <=right;i++)
            {
                res.add(matrix[top][i]);
            }
            top++;
            for(int i = top ; i <=bottom; i++)
            {
                res.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom)
            {
                for(int i = right ; i >=left ; i--)
                {
                    res.add(matrix[bottom][i]);
                }
            bottom--;
            }
            if(left<=right)
            {
                for(int i = bottom ; i >=top;i--)
                {
                    res.add(matrix[i][left]);
                }
            left++;
            }
        }

        return res;

        
    }

    public static void main(String[] args) {
        
        int [][] matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };

        List<Integer> result = spiral(matrix);
        System.out.println("Spiral order : " + result);
    }
    
}
