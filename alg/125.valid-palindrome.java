class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuffer sb = new StringBuffer();
        for (char c : s.toCharArray())
            if ((c >= '0' && c <= '9') ||
                (c >= 'a' && c <= 'z'))
                sb.append(c);
        int i = 0, j = sb.length() - 1;
        while (i < j) {
            if (sb.charAt(i++) != sb.charAt(j--))
                return false;
        }
        return true;
    }
}
