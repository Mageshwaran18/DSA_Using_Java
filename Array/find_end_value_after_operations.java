package Array;

/* LeetCode:- 2011  https://leetcode.com/problems/final-value-of-variable-after-performing-operations/description/ */


public class find_end_value_after_operations {
    
    public static int finalValueAfterOperations(String[] operations) {

        int ans = 0;
        for(String str : operations)
        {
            if(str.charAt(1)=='-')
            {
                ans--;
            }
            else
            {
                ans++;
            }
        }

        return ans;
        
    }

    public static void main(String[] args) {
        String[] operations = {"--X", "X++", "X++"};
        int result = finalValueAfterOperations(operations);
        System.out.println("Final value after operations: " + result);
    }
}
