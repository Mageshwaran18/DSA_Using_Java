package Hashing;

import java.util.*;

public class frequency {


    public static void Frequency(int arr[])
    {
        int n = arr.length;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i = 0 ; i < n ; i++)
        {
            if(hm.containsKey(arr[i]))
            {
                hm.put(arr[i], hm.get(arr[i])+1);
            }
            else
            {
                hm.put(arr[i], 1);
            }
        }
        /*
         * A "map" is like a dictionary. It stores pairs of information: a "key" and a "value".
         * Think of it like a phone book where names (keys) are paired with phone numbers (values).
         *
         * Map.Entry<Integer,Integer> means we're dealing with a map where both the keys and values
         * are numbers (Integers).
         *
         * The for loop is saying "for each pair in this map, do the following..."
         *
         * entry is the name we're giving to each pair as we go through the map.
         *
         * map.entrySet() is how we get all the pairs in the map.
         */

        for (Map.Entry<Integer, Integer> entry : hm.entrySet())
        {
            System.err.println(entry.getKey() +  " : " + entry.getValue());
        }


    }
    public static void main(String args[]){  
   
        int arr[] = {10,5,10,15,10,5};
          int n = arr.length;
          Frequency(arr);
       } 


}