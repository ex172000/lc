/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int p = 0;
        while (p < n) {
            char[] buf4 = new char[4];
            int c = read4(buf4);
            for (int i = 0; i < c && p + i < n; i++) {
                buf[p++] = buf4[i];
            }
            if (c < 4) break;
        }
        return p;
    }
}
