package Graph.Striver;
import java.util.*;
public class alien_dictionary {


    public static String findOrder(String[] words) {
        
        String ans = new String();
        int ttv=0;
        int in[] = new int[26];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Set<Integer>> adj = new ArrayList<>();
        boolean visited[] = new boolean[26];  
        for(int i = 0 ; i < 26 ; i++)
        {
            adj.add(new HashSet<>());
        }
        for(int i = 1 ; i < words.length ; i++)
        {
            int j = 0 ;
            boolean k = false;
            String pre = words[i-1];
            String cur = words[i];
            while(j<pre.length() && j < cur.length())
            {
                
                int pc = pre.charAt(j)-97;
                int cc = cur.charAt(j)-97;
                visited[pc]=true;
                visited[cc]=true;
                if(pre.charAt(j)!=cur.charAt(j))
                {
                    k=true;
                    adj.get(pc).add(cc);
                    break;
                }
                j++;
            }
            if(j<words[i-1].length() && j==words[i].length() && k==false) return "";
            
        }
        for(int i = 0 ; i < 26;i++)
        {
            if(visited[i])
            {
                System.out.print("[");
                for(int j : adj.get(i))
                {
                    System.out.print(j + ",");
                }
                System.out.print("]");
            }
        }
        System.out.println("Visited characters :- ");
        for(int i = 0 ; i < 26 ; i++)
        {

            if(visited[i])
            {
                System.out.print((char)(i+97)+ " ");
            }
        }
        for(int i = 0 ; i < 26 ; i++)
        {
            if(visited[i])
            {
                ttv++;
                for(int j : adj.get(i))
                {
                    in[j]++;
                }
            }
        }

        for(int i = 0 ; i < 26 ; i++)
        {
            if(visited[i])
            {
                if(in[i]==0)
                {
                    q.add(i);
                }
            }
        }

        int poped = 0;
        while(!q.isEmpty())
        {
            int node = q.poll();
            ans=ans+(char)(node+97);
            poped++;
            for(int neigh : adj.get(node))
            {
                in[neigh]--;
                if(in[neigh]==0)
                {
                    q.add(neigh);
                }
            }
        }
        if(ttv==poped)
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
