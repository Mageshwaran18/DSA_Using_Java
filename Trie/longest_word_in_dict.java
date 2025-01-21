package Trie;

/* LeetCode :- 720 https://leetcode.com/problems/longest-word-in-dictionary/ 
 * 
 * For iteration refer DSA notes and for code explanation https://leetcode.com/problems/longest-word-in-dictionary/solutions/634793/java-the-easiest-to-understand-trie-solution-100-explanation/
 * 
 * Hint: Trie will always store the strings in lexicographical order only, while retrieving the string with higher lexicographical order will come first.
*/


public class longest_word_in_dict {

    public String result  = "";

    class Trie
    {
        Trie child [] = new Trie[26];
        String word;

        public void insert(String str) {
            Trie cur = this;
            for(char c : str.toCharArray()) {
                if(cur.child[c-'a'] == null) {
                    cur.child[c-'a'] = new Trie();
                }
                cur = cur.child[c-'a'];
            }   
            cur.word = str;
        }

        public void dfs(Trie trie)
        {
            if(trie==null)
            {
                return;
            }
            
            if(trie.word!=null)
            {
                    
                if(result.length() < trie.word.length() )
                {
                    result = trie.word;
                }
            }

            for(Trie cur : trie.child)
            {
                if(cur!=null && cur.word!=null)
                {
                    dfs(cur);
                }
            }
        }

        public String longest_word_in_dict(String []str)
        {
            Trie cur = this;
            for(String c : str)
            {
                this.insert(c);
            }
            this.dfs(this);

            return result;


        }

    }

    public static void main(String args[])
    {
        String[] words = {"a","banana","app","appl","ap","apply","apple"};
        Trie root = new longest_word_in_dict().new Trie();
        System.out.println("Longest word in the dictionary is " + root.longest_word_in_dict(words));
    }

    
}
