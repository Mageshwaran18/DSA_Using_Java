package Recursion;

import java.util.*;

class subsets_string {
    static List<String> sub = new ArrayList<>();
    static List<List<String>> res = new ArrayList<>();

    public static void fun(String[] strs, int i) {
        if(i == strs.length) {
            res.add(new ArrayList<>(sub));
            return;
        }

        sub.add(strs[i]);
        fun(strs, i+1);
        sub.remove(sub.size()-1);
        fun(strs, i+1);
        return;
    }

    public static List<List<String>> subsets(String[] strs) {
        sub.clear();
        res.clear();
        fun(strs, 0);
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"a", "b", "c"};
        List<List<String>> ans = subsets(strs);
        for(List<String> i: ans) {
            System.out.println(i);
        }
    }
}
