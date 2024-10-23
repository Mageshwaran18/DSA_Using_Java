package Array;
import java.util.*;

/* Brute Force approach --> Store the elements in the hashset which doesn't allow duplicates and it will sorted automatically 
 * 
 * Better approach --> Two pointer approach 
 */


public class union_of_two_array {
      public static List<Integer> union(int a[],int b[])
      {
          ArrayList<Integer> ans = new ArrayList<>();
        
          /*
         * HashMap allows duplicate values but unique keys
         * HashSet only stores unique elements (no duplicates allowed)
         */
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

          /* is as same as --> for(Integer st: set) ans.add(st) */
          ans.addAll(set);

          return ans;
    }
    
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {2, 3, 4, 6, 7};
        
        List<Integer> unionResult = union(arr1, arr2);
        System.out.println("Union of two arrays: " + unionResult);
    }
}
