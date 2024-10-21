package Array;

public class single_number {
      /*
     * Two important properties of XOR are the following:
     * 
     * 1. XOR of two same numbers is always 0, i.e., a ^ a = 0.
     * 2. XOR of a number with 0 will result in the number itself, i.e., 0 ^ a = a.
     * 
     * Here, all the numbers except the single number appear twice and so will form pairs.
     * If we perform XOR of all elements of the array, the XOR of each pair will result in 0
     * according to property 1. The result will be: 0 ^ (single number) = single number
     * (according to property 2).
     * 
     * Therefore, if we perform the XOR of all the numbers in the array, we will be left
     * with the single number that appears only once.
     */

    public static int single_number(int arr[])
    {
        int xor = 0;
        int n = arr.length;

        for(int i = 0 ; i < n ; i++)
        {
            xor = xor ^ arr[i];
        }
        return xor;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2 , 4};
        int result = single_number(nums);
        System.out.println("The single number is: " + result);
    }
    
}
