package Graph;
import java.util.*;

/* LeetCode :- 547 https://leetcode.com/problems/number-of-provinces/description/ */

/* Once you know how to do count number of components then it will be easy for you 
 The inputs were given in the matrix format , if row and col equall and mat[row][col]==1 then it's a vertice 
 If row!=col and mat[row][col]==1 then row'th vertice is connected to the col'th vertice */

class no_of_provinces
{

    public static void helper_dfs(int i , ArrayList<ArrayList<Integer>> adj, boolean[] visited)
    {
        visited[i]=true;
        for(int temp : adj.get(i))
        {
            if(!visited[temp])
            {
                helper_dfs(temp,adj,visited);
            }
        }
    }
    public static int no_of_provinces(int [][] matrix)
    {
        int count = 0;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = 0 ; i < row;i++)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j = 0 ;  j < col ; j++)
            {
                if(matrix[i][j]!=0  && i!=j)
                {
                    temp.add(j);
                }
            }
            adj.add(new ArrayList<>(temp));
        }
        boolean []visited = new boolean[row];
        for(int i = 0 ; i < row ; i++)
        {
            if(!visited[i])
            {
                count++;
                helper_dfs(i,adj,visited);
            }

        }

        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,0,0},{0,1,0},{0,0,1}};
        System.out.println(no_of_provinces(matrix));
    }
}