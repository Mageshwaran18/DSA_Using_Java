package Graph.Striver;
import java.util.*;

/* GFG :- https://www.geeksforgeeks.org/problems/alien-dictionary/1 */
/* Refer the DSA notes */

public class alien_dictionary {


    public static String findOrder(String[] words) {
        
        int cnt = 0 ; 
        String ans = "";
        Set<Character> st = new HashSet<>();
        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> a-b);
        int [] in = new int[26];
        
        for(int i = 0 ; i < words.length ; i++)
        {
            for(int j = 0 ;  j < words[i].length() ; j++)
            {
                st.add(words[i].charAt(j));
            }
        }
        
        for(char c : st)
        {
            graph.put((int)c-'a',new ArrayList<>());
        }
        
        for(int i = 1 ; i < words.length ; i++)
        {
            boolean mean = false;
            int j = 0 ; 
            String pre = words[i-1];
            String cur = words[i];
            while(j<pre.length() && j <cur.length())
            {
                if(pre.charAt(j)!=cur.charAt(j))
                {
                    mean = true; 
                    graph.get((int)pre.charAt(j)-'a').add((int)cur.charAt(j)-'a');
                    break;
                }
                j++;
            }
            
            if(j<pre.length() && j==cur.length() && mean==false) return "";
        }
        
        Arrays.fill(in,-1);
        
        for(int i : graph.keySet())
        {
            if(in[i]==-1)
            {
                in[i]=0;
            }
            for(int neigh : graph.get(i))
            {
                if(in[neigh]==-1)
                {
                    in[neigh]=0;
                }
                in[neigh]++;
            }
        }
        
        for(int i = 0 ; i < 26 ; i++)
        {
            if(in[i]==0)
            {
                pq.add(i);
            }
        }
        
        while(!pq.isEmpty())
        {
            int poll = pq.poll();
            cnt++;
            ans += (char)(poll+'a');
            for(int neigh : graph.get(poll))
            {
                in[neigh]--;
                if(in[neigh]==0)
                {
                    pq.add(neigh);
                }
                
            }
        }
        if(cnt==st.size())        
        {
            return ans;   
        }
        else
        {
            return "";
        }
    }


    public static void main(String[] args) {
        String[] words = {"dddc", "a", "ad", "ab", "b", "be", "cd", "cded"};
        String order = findOrder(words);
        System.out.println("The order of characters is: " + order);
    }
    
    
}
