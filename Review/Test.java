/**
 * Given a string s and a dictionary of words dict,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * For example, given s ="leetcode", dict =["leet", "code"].
 * Return true because"leetcode"can be segmented as"leet code". bool wordBreak(string s, unordered_set &dict)
 *
 */

import java.util.*;

public class Test {
    public boolean wordBreak(String s, Set<String> dict) {
        if(s.length() == 0){
            return false;
        }
        if(dict.isEmpty()){
            return false;
        }
        boolean[] wb = new boolean[s.length()+1];
        wb[0] = true;
        for(int i = 1; i <= s.length();++i){
            for(int j = 0; j < i; ++j){
                if(wb[j] && dict.contains(s.substring(j, i))){
                    wb[i] = true;
                    break;
                }
            }
        }
        return wb[s.length()];
    }
}
