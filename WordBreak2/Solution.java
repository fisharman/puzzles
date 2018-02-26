// https://leetcode.com/problems/word-break-ii/description/
// NOT SOLVED!


import java.util.*;

class WordBreak2{

    private static HashMap<String,List<String>> map = new HashMap<String,List<String>>();

    public static List<String> wordBreak(String s, List<String> wordDict) {
        // s = "catsanddog"
        // dict = ["cats and dog", "cat an dog"]

        // expand the string and check if word is in dict
        // if it is, send the array list down and complete the search
        map.clear();
        return wordBreak(s, new HashSet<>(wordDict));

    }

    private static List<String> wordBreak(String s, HashSet<String> wordDict) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() == 0) {
            return res;
        }
        if(map.containsKey(s)) {
            return map.get(s);
        }
        if(wordDict.contains(s)) {
            res.add(s);
        }
        for(int i = 1 ; i < s.length() ; i++) {
            String t = s.substring(i);
            if(wordDict.contains(t)) {
                List<String> temp = wordBreak(s.substring(0 , i) , wordDict);
                if(temp.size() != 0) {
                    for(int j = 0 ; j < temp.size() ; j++) {
                        res.add(temp.get(j) + " " + t);
                    }
                }
            }
        }
        map.put(s , res);
        return res;
    }

    private static List<String> useless_wordBreak(String s, HashSet<String> wordDict){
        ArrayList<String> result = new ArrayList<>();

        int idx = 1;
        while (idx <= s.length()){
            if (wordDict.contains(s.substring(0,idx))){
                // add word to list
                result.add(s.substring(0,idx));
                // watch for null return
                result.addAll(wordBreak(s.substring(idx), wordDict));
            }
            idx++;
        }

        return result;
    }
}

public class Solution {
    public static void main(String[] args) {
        String s = new String("catsanddog");
        List<String> list = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println(WordBreak2.wordBreak(s,list));

        s = new String("aaaaaa");
        list = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa");
        // System.out.println(WordBreak2.wordBreak(s,list));
    }
}
