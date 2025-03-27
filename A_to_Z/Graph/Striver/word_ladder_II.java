package Graph.Striver;
import java.util.*;

/* LeetCode:- 126 https://leetcode.com/problems/word-ladder-ii/description/ */

/* My Approach --> Generate all the possible path and find the minimum paths in it , May lead to TLE 

    Better Approach --> Modified version of the wordladder I ( Refer DSA notes )
 */

public class word_ladder_II {


    public static List<List<String>> ans = new ArrayList<>();

    public static void dfs_helper(String bw,String ew , List<String> wl ,  List<String> visited)
    {

        if(bw.equals(ew))
        {
            ans.add(new ArrayList<>(visited));
            return;
        }
        else if(wl.contains(bw))
        {
            String par = bw;
            for(int i = 0 ; i < par.length();i++)
            {
                for(int j = 97 ; j <= 122 ; j++)
                {
                    char  c = (char)j;
                    String child = par.substring(0,i)+ c +  par.substring(i+1);
                    if(wl.contains(child) && !visited.contains(child))
                    {
                        visited.add(child);
                        dfs_helper(child,ew,wl,visited);
                        visited.remove(child);
                    }

                }
            }
        }
    }


    public static List<List<String>> findShortestSequences(List<List<String>> ans) {
        List<List<String>> shortest = new ArrayList<>();
        
        if (ans.isEmpty()) {
            return shortest;
        }
    
        int minLength = ans.get(0).size();
        shortest.add(ans.get(0));
    
        for (int i = 1; i < ans.size(); i++) {
            List<String> currentList = ans.get(i);
            if (currentList.size() < minLength) {
                shortest.clear();
                shortest.add(currentList);
                minLength = currentList.size();
            } else if (currentList.size() == minLength) {
                shortest.add(currentList);
            }
        }
        
        return shortest;
    }
    

    /* Better Approach  */
    public static List<List<String>> findLadders(String bw, String ew, List<String> wordList) 
    {
        List<String> wl = new ArrayList<>(wordList);  // Create new modifiable list
        List<String> visited = new ArrayList<>();
        wl.add(bw);
        visited.add(bw);
        dfs_helper(bw, ew, wl, visited);
        return ans;
    }

    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        int level = 0;                                                 
        Set<String> st = new HashSet<>();
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> used = new ArrayList<>();
        ArrayList<ArrayList<String>> ans = new ArrayList<>(); 
        
        for(String str : wordList) {
            st.add(str);
        }
        
        q.add(new ArrayList<>(Arrays.asList(startWord)));
        used.add(startWord);
        
        while(!q.isEmpty()) {
            ArrayList<String> poped = q.poll();
            if(poped.size() > level) {
                level++;
                for(String us : used) {
                    st.remove(us);
                }
            }

            if(poped.get(poped.size()-1).equals(targetWord)) {
                if(ans.size()==0) {
                    ans.add(poped);
                }
                else if(ans.get(ans.size()-1).size()==poped.size()) {
                    ans.add(poped);
                }
            }

            String last = poped.get(poped.size()-1);

            for(int i = 0; i < last.length(); i++) {
                for(int j = 97; j <= 122; j++) {
                    char c = (char)j;
                    String child = last.substring(0,i) + c + last.substring(i+1);
                    if(st.contains(child)) {
                        poped.add(child);
                        used.add(child);
                        ArrayList<String> temp = new ArrayList<>(poped);
                        q.add(temp);
                        poped.remove(poped.size()-1);
                    }
                }
            }
        }
        return ans;
    }    

    
    public static void main(String[] args) {
        String beginWord = "qa";
        String endWord = "sq";
        List<String> wordList = Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye");
        List<List<String>> result = findLadders(beginWord, endWord, wordList);
        List<List<String>> shortestPaths = findShortestSequences(result);
        System.out.println("Shortest transformation sequences: " + shortestPaths);
    }
}
