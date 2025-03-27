package Greedy;
import java.util.*;

/* GeekForGeeks :- Meeting Rooms https://www.geeksforgeeks.org/problems/attend-all-meetings/0 */

/* Sort the pair based on the key , if one of the meeting's starting time is  greater than the all other meeting'e ending time 
 * It's not possible to host that meeting in the same room.
*/

public class meeting_room {

    public static boolean meeting_room(int [][]arr)
    {
        Arrays.sort(arr,(a,b)-> Integer.compare(a[0],b[0]));
        for(int i[]:arr)
        {
            System.out.println(Arrays.toString(i));
        }
        for(int i = 0 ; i < arr.length-1 ;  i++)
        {
           if(arr[i][1] > arr[i+1][0])
           {
            return false;
           }
        }
        return true;

    }
    public static void main(String args[])
    {
        int arr[][] = {{1,4},{10,15},{7,10}};
        System.out.print("Can we conduct all the meeting in a single room ? " + meeting_room(arr)  );
    }

}
