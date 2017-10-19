public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        helper(s, new char[]{'(', ')'}, 0, 0, res);
        return res;
    }
    
    private void helper(String s, char[] pair, int last_i, int last_j, List<String> res) {
        for (int i = last_i, stack = 0; i < s.length(); i++) {
            if (s.charAt(i) == pair[0]) stack++;
            if (s.charAt(i) == pair[1]) stack--;
            if (stack >= 0) continue;
            for (int j = last_j; j <= i; j++) {
                if (s.charAt(j) == pair[1] && (j == last_j || s.charAt(j - 1) != pair[1]))
                    helper(s.substring(0, j) + s.substring(j + 1), pair, i, j, res);
            }
            return;
        }
        String reversed = new StringBuffer(s).reverse().toString();
        if (pair[0] == '(')
            helper(reversed, new char[]{')', '('}, 0, 0, res);
        else
            res.add(reversed);
    }
}
