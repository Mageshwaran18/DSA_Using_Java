package Priority_Queue;
import java.util.*;

/* LeetCode :- 621  https://leetcode.com/problems/task-scheduler/description/
 * 
 * Refer the DSA notes and also https://leetcode.com/problems/task-scheduler/solutions/3280549/full-explanation-using-priority-queue-and-formula-based-approach/
 */
public class task_scheduling {

    public static int leastInterval(char[] tasks, int n) {

        int time = 0;

        HashMap<Character, Integer> hm = new HashMap<>();

        for (char c : tasks) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            pq.add(entry);
        }

        List<Map.Entry<Character, Integer>> temp = new ArrayList<>();

        while (!pq.isEmpty()) {
            for (int i = 1; i <= n+1 ; i++) {
                if(!pq.isEmpty()){
                Map.Entry<Character, Integer> polled = pq.poll();
                polled.setValue(polled.getValue() - 1);
                if (polled.getValue() != 0) {
                    temp.add(polled);
                }
                }
                time++;
                if(temp.isEmpty())
                {
                    break;
                }
            }
            while(!temp.isEmpty())
            {
                pq.add(temp.remove(0));
            }
        }
        return time;
    }
    
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        System.out.println("Minimum intervals needed: " + leastInterval(tasks, n));
    }
    
}
