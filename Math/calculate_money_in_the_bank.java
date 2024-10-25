
/* LeetCode :- 1716  https://leetcode.com/problems/calculate-money-in-leetcode-bank/ */




public class calculate_money_in_the_bank {

    public int totalMoney(int n) {

        int res = 0;
        int count = 0;
        int arr[] = {0,0,0,0,0,0,0};
        int i = 0;
        while(count < n)
        {
            if(i==0)
            {
                arr[i]+=1;
                res+=arr[i];
                i++;
            }
            else if (i!=7)
            {
                arr[i] = arr[i-1]+1;
                res+=arr[i];
                i++;
            }
            if(i==7)
            {
                i=0;
                for(int j=0; j<7; j++) {
                    arr[j]++;
                }
            }
            count++;
        }
        return res;
        
    }
    
}