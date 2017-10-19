import java.util.*;
class Solution {
    List<String> res = new ArrayList<>();
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        helper(num / 1000000000, "Billion");
        num = num % 1000000000;
        helper(num / 1000000, "Million");
        num = num % 1000000;
        helper(num / 1000, "Thousand");
        num = num  % 1000;
        helper(num, null);
        StringBuffer sb = new StringBuffer();
        for (String s : res) {
            sb.append(s);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    private void helper(int num, String toAdd) {
        if (num == 0) return;
        helperLastTwo(num / 100, "Hundred");
        helperLastTwo(num % 100, null);
        if (toAdd != null) res.add(toAdd);
    }

    private void helperLastTwo(int num, String toAdd) {
        if (num == 0) return;
        String[] oneToNineteen = new String[]
                {"One", "Two", "Three", "Four", "Five",
                 "Six", "Seven", "Eight", "Nine", "Ten",
                 "Eleven", "Twelve", "Thirteen", "Fourteen",
                 "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String[] twentyUp = new String[]{"Twenty", "Thirty", "Forty",
                                         "Fifty", "Sixty", "Seventy",
                                         "Eighty", "Ninety"};
        if (num  < 20)
           res.add(oneToNineteen[num - 1]);
        else {
            res.add(twentyUp[num / 10 - 2]);
            helperLastTwo(num % 10, null);
        }
        if (toAdd != null) res.add(toAdd);
    }
}
