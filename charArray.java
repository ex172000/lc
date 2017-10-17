// Please implement the serializer and deserializer for char array below.
// For char arrays, we follow the JSON standard according to http://www.json.org/
// Therefore, a single character A is represented as "A" (wrapped in double quotes instead of single quotes).
// A char array containing 3 elements "A", "B", "C" is represented in string as ["A","B","C"].
// For the purpose of this problem, you must not use JSON parser library or eval method. 
// Standard library provided by the language (not including JSON library) is allowed.
import java.util.*;
class charArray {
    private static char[] keys = new char[]{'\b', '\t', '\n', '\f', '\r', '\\', '\"'},
                          values = new char[]{'b', 't', 'n', 'f', 'r', '\\', '\"'};
    public static String charArrayToString(char[] param) throws Exception {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < param.length; i++) {
            char c = param[i];
            sb.append("\"");
            boolean special = false;
            for (int j = 0; j < keys.length; j++)
                if (keys[j] == c) {
                    sb.append('\\');
                    sb.append(values[j]);
                    special = true;
                    break;
                }
            if (!special) sb.append(c);
            sb.append("\"");
            if (i < param.length - 1) sb.append(",");
        }
        sb.insert(0, '['); sb.append(']');
        return sb.toString();
    }

    // Bonus point if your deserializer is able to deal with whitespaces between elements.
    // For example: param = "[  \"a\",  \"b\", \"c\"  ]"
    public static char[] stringToCharArray(String param) throws Exception {
        param = param.trim();
        param = param.substring(1, param.length() - 1);
        String[] arr = param.split(",");
        List<Character> list = new ArrayList<Character>();
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i].trim();
            if (s.length() > 0) {
                s = s.substring(1, s.length() - 1);
                if (s.length() == 2) {
                    char c = s.charAt(1);
                    for (int j = 0; j < keys.length; j++)
                        if (values[j] == c) list.add(keys[j]);
                } else list.add(s.charAt(0));
            }
        }
        char[] res = new char[list.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = list.get(i);
        return res;
    }

    // Note: These tests are basic and passing them does not mean your code is correct.
    // Feel free to write additional tests and test serializer and deserializer individually.
    public static void main(String[] args) {
        String[] testcases = {
            "[]",
            "[\"a\",\"b\",\"c\"]",
            "[\"T\",\"e\",\"!\",\"'\"]",
            "[\"'\",\"\\\"\",\"c\"]",
            "[\"\\n\",\"\\t\",\"'\",\"\\\"\",\"\\\\\"]",
        };
        
        for(String testcase : testcases) {
            try {
                if (!charArrayToString(stringToCharArray(testcase)).equals(testcase)) {
                    System.out.println("TESTCASE FAILED : " + testcase);
                } else {
                    System.out.println("TESTCASE PASSED");
                }
            } catch(Exception e) {
                System.out.println("Exception occured in testcase : " + testcase);
                break;
            }
        }
    }
}

