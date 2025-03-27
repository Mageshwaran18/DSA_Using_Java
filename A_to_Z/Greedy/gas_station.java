package Greedy;


/* LeetCode :- 134 https://leetcode.com/problems/gas-station/description/ */
/* Refer DSA notes , https://youtu.be/ZG_gHl12qf0?si=rwyEKcek6mG60_hY */
public class gas_station {

    public static int gas_station(int gas[], int cost[])
    {
        int total_cost = 0;
        int n = gas.length;
        for(int i = 0 ; i < n ; i++)
        {
            total_cost += gas[i] - cost[i];
        }

        if(total_cost < 0)
        {
            //If total cost is negative , then there is gas with a distance to another gas , which will not be statisfied by any other gas station
            return -1; // To handle no solution test cases.
        }

        int cur_gas = 0 , start_index = 0;
        for(int i = 0 ; i < n ; i++)
        {
            cur_gas += gas[i]-cost[i];

            if(cur_gas < 0)
            {
                cur_gas = 0;
                start_index = i +1;
            }
        }
        
        return start_index;
    }

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        int result = gas_station(gas, cost);
        System.out.println("Starting station index: " + result);
    }
}
