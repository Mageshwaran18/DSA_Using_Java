package Array.Strivers.Easy;



/* LeetCode :- 26  https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/ */

/*
 * My Approach --> The hint they have given is, that the array is sorted 
 *             --> Assume the first element as sorted, compare the i (unique index) th element with the adjacent i-1 th element 
 *                  --> If they're same, traverse until you find the different element other than the i th element
 *                          --> If found the different element at the jth position, replace i th element with the j th element
 *                          --> Don't swap it because it creates some more additional complexity just replace i with j element
 *                          --> Now we know that 100% the element just replaced is in the correct position, hence move the unique 
 *                          Note : Those elements crossed by the i while searching for the different element will not be valid, so we can continue the same operation after the ith position (after replacement)
 *                  --> If not just move the i because the element is in the right position
 * 
 * 
 * Brute Force --> Use TreeSet (doesn't store duplicates in it), copy the TreeSet into the array
 *            --> Time Complexity  --> O(n log n) [ for storing the element in the TreeSet ] + O(n) [ for storing the unique elements into the array ]
 *                                 --> O(n log n) + O(n)
 *            --> Space complexity --> O(n) [ for storing the unique elements in the tree ]
 * 
 * Optimal Approach --> We know that first element will always be in the correct position 
 *                  --> Start comparing from the second element of the array with the unique element
 *                  --> If arr[ui] == arr[i], then it's duplicate so move i until we find the element which is not equal to arr[ui]
 *                  --> If arr[ui] != arr[i], then it's unique element replace arr[ui+1] with the arr[i], then increment the ui
 *                  --> If the i reached the end, then position at ui + 1 is the number of unique elements (ui+1 ? zero based indexing)
 *                  --> T.C :- O( N )
 *                  --> S.C :- O( 1 )
 */         
public class remove_duplicates_from_array_inplace {
    
    public static int remove_duplicates_from_array_inplace(int[] arr) {

        if (arr == null || arr.length == 0) {
            return 0;
        }
        

        int ui = 0;
        for(int j = 1 ; j < arr.length ; j++)
        {
            if(arr[ui]!=arr[j])
            {
                arr[ui+1]=arr[j];
                ui+=1;
            }
        }
        return ui +1;

        }
        
        
    

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int uniqueCount = remove_duplicates_from_array_inplace(arr);
        System.out.println("Number of unique elements: " + uniqueCount);
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < uniqueCount; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
