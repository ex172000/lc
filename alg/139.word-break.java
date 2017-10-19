import java.util.*;
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < dp.length; i++) {
            if (!dp[i]) continue;
            else {
                for (String word : wordDict) {
                    int len = i + word.length();
                    if (len <= s.length() && 
                        word.equals(s.substring(i, len)))
                        dp[len] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
