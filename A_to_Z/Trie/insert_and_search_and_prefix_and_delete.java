package Trie;

/* For the basics refers DSA notes and https://www.geeksforgeeks.org/trie-insert-and-search/ 
 * 
 * LeetCode : 208 https://leetcode.com/problems/implement-trie-prefix-tree/submissions/1514380624/
 * 
*/

public class insert_and_search_and_prefix_and_delete {

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

        public  boolean starts_with(String str)
        {
            Trie cur = this;
            for(char c : str.toCharArray()) {
                if(cur.child[c-'a'] == null) {
                    return false;
                }
                cur = cur.child[c-'a'];
            }   
            return true;
        }

        public void delete(String str) {
            Trie cur = this;
            for(char c : str.toCharArray()) {
                if(cur.child[c-'a'] == null) {
                    return; // String not found
                }
                cur = cur.child[c-'a'];
            }
            cur.eow = false; // Mark as not end of word
        }
    }

    public static void main(String args[]) {
        Trie root = new insert_and_search_and_prefix_and_delete().new Trie();
        String str = "apple";
        root.insert(str);
        System.out.println("Inserted string : " + str);
        System.out.println("Search for 'app': " + root.search("app"));
        System.out.println("Search for 'apple': " + root.search("apple"));
        System.out.println("Starts with 'app': " + root.starts_with("app"));    }
}