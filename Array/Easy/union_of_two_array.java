package Array.Easy;

import java.util.*;

/* Brute Force approach --> Store the elements in the hashset which doesn't allow duplicates
 * 
 * Better approach --> Two pointer approach , it's as same as the merge two sorted linked list
 *                 --> See the code , don't make the mistake twice 
 *                 --> The problem is so simple don't make it complicate by thinking overly 
 *                 --> Solve it in easy approach
 */


public class union_of_two_array {
      public static List<Integer> union(int a[],int b[])
      { 
          /* 
         * HashMap allows duplicate values but unique keys
         * HashSet only stores unique elements (no duplicates allowed)
          HashSet<Integer> set = new HashSet<>();

          int n1 = a.length;
          int n2 = b.length;
       
          for(int i = 0 ; i < n1 ; i++)
          {
              set.add(a[i]);
          }
          for(int j = 0 ; j < n2 ; j++)
          {
              set.add(b[j]);
          }

         is as same as --> for(Integer st: set) ans.add(st) 
          ans.addAll(set);
           */
        
        ArrayList<Integer> ans = new ArrayList<>();
        int n1 = a.length;
        int n2 = b.length;
        int i = 0 , j = 0;
        
        while( i < n1 && j < n2)
        {
            if(a[i]<=b[j])
            {
                if(ans.size()==0||ans.get(ans.size()-1)!=a[i])
                {
                    ans.add(a[i]);
                }
                i++;
            }
            else
            {
                if(ans.size()==0 || ans.get(ans.size()-1)!=b[j])
                {
                    ans.add(b[j]);
                }
                j++;
            }
        }

        while( i < n1)
        {
            if(ans.size()==0 || ans.get(ans.size()-1)!=a[i])
            {
                ans.add(a[i]);
            }
            i++;
        }

        while( j < n2)
        {
            if(ans.size()==0 || ans.get(ans.size()-1)!=b[j])
            {
                ans.add(b[j]);
            }
            j++;
        }

        return ans;

    }
    
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 3, 4, 6, 7};
        
        List<Integer> unionResult = union(arr1, arr2);
        System.out.println("Union of two arrays: " + unionResult);
    }
}
