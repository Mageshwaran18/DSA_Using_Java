package Graph.Striver;

/* LeetCode :- 127 https://leetcode.com/problems/word-ladder/description/ */

import java.util.*;

class word_ladder_I
{
    static class Pair
    {
        String str;
        int level;
        public Pair(String str,int level)
        {
            this.str=str;
            this.level=level;
        }
    }
    public static int word_ladder_I_my_approach(String bw, String ew, List<String> wordlist)
    {
        Queue<Pair> q = new LinkedList<>();
        Set<String> wl = new HashSet<>();
        for(String str: wordlist)
        {
            wl.add(str);
        }
        Set<String> visited = new HashSet<>();
        q.add(new Pair(bw,1));
        while(!q.isEmpty())
        {
            Pair temp = q.poll();
            String par = temp.str;
            int par_lev = temp.level;
            if(visited.contains(par))
            {
                continue;
            }
            else
            {
                visited.add(par);
                for(int i = 0 ; i < par.length() ; i++)
                {
                    for(int j = 97 ; j <= 122 ; j++)
                    {
                        char c = (char)j;
                        String chi = par.substring(0,i) + c + par.substring(i+1);
                        if(wl.contains(chi) && !visited.contains(chi))
                        {
                            // System.out.println(chi);
                            if(chi.equals(ew))
                            {
                                return par_lev+1;
                            }
                            else
                            {
                                q.add(new Pair(chi,par_lev+1));
                            }
                        }

                    }
                }
            }
        }

        return 0;
    }

    public static int word_ladder_I_striver(String bw, String ew, List<String> wl)
    {
        Queue<Pair> q = new LinkedList<>();
        Set<String> wordlist = new HashSet<>();
        for(String str: wl)
        {
            wordlist.add(str);
        }
        q.add(new Pair(bw,1));
        while(!q.isEmpty())
        {
            Pair pop = q.poll();
            String par_str = pop.str;
            int par_lev = pop.level;
            for(int i = 0 ; i < par_str.length() ; i++)
            {
                for(int j = 97 ; j <=122 ; j++)
                {
                    char c = (char)j;
                    String child = par_str.substring(0,i)+c+par_str.substring(i+1);
                    if(wordlist.contains(child) && child.equals(ew))
                    {
                        return par_lev+1;
                    }
                    else if(wordlist.contains(child))
                    {
                        wordlist.remove(child);
                        q.add(new Pair(child,par_lev+1));
                    }
                }
            }
        }

        return 0;
        
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log");        
        int result = word_ladder_I_striver(beginWord, endWord, wordList);
        System.out.println("Length of shortest transformation sequence: " + result);
    }
}