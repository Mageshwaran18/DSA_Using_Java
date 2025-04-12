import java.util.*;

/* https://www.naukri.com/code360/problems/count-distinct-substrings_985292?leftPanelTabValue=PROBLEM */

/* Refer DSA notes - 2 */

class count_distinct_substring{

    static class Trie 
	{
		Trie[] child = new Trie[26];


		public static int insert(String str , int count , Trie root)
		{
			Trie cur = root;

			for(char c : str.toCharArray())
			{
				if(cur.child[c-'a']==null)
				{
					count++;
					cur.child[c-'a']=new Trie();
				}
				cur = cur.child[c-'a'];
			}
			return count;
		}
	}


	public static int countDistinctSubstrings(String s) 
	{
		Trie root = new Trie();
		int count = 1;
		for(int i = 0 ; i < s.length() ; i++)
		{
			String temp = "";
			for(int j = i ; j < s.length() ; j++)
			{
				temp = temp + s.charAt(j);
				count = Trie.insert(temp,count,root);
			}
		}

		return count;
	}

    public static void main(String[] args) {
        String str = "abab";
        System.out.println("Number of distinct substrings: " + countDistinctSubstrings(str));
    }
    
}