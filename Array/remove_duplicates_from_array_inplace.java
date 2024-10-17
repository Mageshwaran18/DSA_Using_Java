package Array;


/* LeetCode :- 26 */

/*
 * My Approach --> The hint they have given is , that the array is sorted 
 *             --> Assume the first element as sorted , compare the i (unique index) th element with the adjacent i-1 th element 
 *                  --> If the're same , traverse untill you find the different element other than the i th element
 *                          --> If found the different element at the jth position , replace i th element with the j th element
 *                          --> Don't swap it because it creates some more additional complexity just replace i with j element
 *                          --> Now we know that 100% the element just replaced is in the correct position , hence move the unique 
 *                          Note : Those element crossed by the i while searchin for the different element is will not be valid , so we can continue the same operation after the ith postion (after replacement)
 *                  --> If not just move the i because the element is in the right position
 */         
public class remove_duplicates_from_array_inplace {
    
    public static int remove_duplicates_from_array_inplace(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        int uniqueIndex = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                arr[uniqueIndex] = arr[i];
                uniqueIndex++;
            }
        }
        
        return uniqueIndex;
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
