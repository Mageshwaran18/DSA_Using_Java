package Array;

import java.util.Arrays;

/* LeetCode :- 2500 https://leetcode.com/problems/delete-greatest-value-in-each-row/ */


import Sorting.quick_sort;

public class delete_greatest_value_in_each_row {

    public static int delete_greatest_value_in_each_row(int[][] grid) {

        for(int i = 0 ; i < grid.length ; i++)
        {
            grid[i]=quick_sort.use_quick_sort(grid[i]);
        }
        int ans = 0 ; 
        for(int i = 0 ;  i < grid[0].length ; i++)
        {
            int maxi = grid[0][i];
            for(int j = 0 ; j < grid.length ; j++)
            {
                if(maxi<grid[j][i])
                {
                    maxi=grid[j][i];
                }
            }
            ans+=maxi;
        }

        return ans;
        
    }
    
    public static void main(String[] args) {
        int[][] grid = {{1,2,4},{3,3,1}};
        int result = delete_greatest_value_in_each_row(grid);
        System.out.println("Maximum value sum: " + result);
    }
}
