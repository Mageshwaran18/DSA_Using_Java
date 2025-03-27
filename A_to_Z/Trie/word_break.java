package Trie;

/* LeetCode :- 139 https://leetcode.com/problems/word-break/description/ */

/* 
 * It just the brute force approach , just see the code you can understand .For every substring for the given string check whether the word is present in the trie or not 
 *  But in leetcode it will not get accepted becuase of the stack overflow due to recursion
 */

import java.util.*;

public class word_break {
    
    class Trie {
        Trie child[] = new Trie[26];
        boolean eow = false;

        public Trie() {
            // for(int i = 0; i < 26; i++) {
            //     child[i] = null;
            // }
        }

        public void insert(String str) {
            Trie cur = this;
            for(char c : str.toCharArray()) {
                if(cur.child[c-'a'] == null) {
                    cur.child[c-'a'] = new Trie();
                }
                cur = cur.child[c-'a'];
            }   
            cur.eow = true;
        }

        public boolean search(String str) {
            Trie cur = this;
            for(char c : str.toCharArray()) {
                if(cur.child[c-'a'] == null) {
                    return false;
                }
                cur = cur.child[c-'a'];
            }   
            return cur.eow;
        }

       

        public boolean word_break(String s ,int st , Trie trie)
        {
            if(st == s.length())
            {
                return true;
            }

            for(int i = st ; i < s.length() ; i++)
            {
                String prefix = s.substring(st,i+1);

                if(trie.search(prefix))
                {
                    if(trie.word_break(s,i+1,trie))
                    {
                        return true;
                    }
                }
            }

            return false;

        }
    }

    public static void main(String args[]) {
        Trie root = new word_break().new Trie();
        String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict = new ArrayList<>(Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));
        for(String s : wordDict)
        {
            root.insert(s);
        }
        System.out.println(root.word_break(str,0,root));
    }

}
