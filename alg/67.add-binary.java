class Solution {
    public String addBinary(String a, String b) {
        a = new StringBuffer(a).reverse().toString();
        b = new StringBuffer(b).reverse().toString();
        int radix = 2, carry = 0, ptr = 0;
        StringBuffer res = new StringBuffer();
        while (ptr < a.length() && ptr < b.length()) {
            int A = a.charAt(ptr) - '0',
                B = b.charAt(ptr) - '0';
            int sum = A + B + carry;
            res.append(sum % radix);
            carry = sum / radix;
            ptr++;
        }
        while (ptr < a.length()) {
            int sum = a.charAt(ptr++) - '0' + carry;
            res.append(sum % radix);
            carry = sum / radix;
        }
        while (ptr < b.length()) {
            int sum = b.charAt(ptr++) - '0' + carry;
            res.append(sum % radix);
            carry = sum / radix;
        }
        if (carry > 0) res.append(carry);
        return res.reverse().toString();
    }
}
