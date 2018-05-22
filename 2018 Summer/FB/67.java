// 67.java

// Given two binary strings, return their sum (also a binary string).

// The input strings are both non-empty and contains only characters 1 or 0.

// Example 1:

// Input: a = "11", b = "1"
// Output: "100"
// Example 2:

// Input: a = "1010", b = "1011"
// Output: "10101"

class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0) {
          int va = i < 0 ? 0 : a.charAt(i) - '0';
          int vb = j < 0 ? 0 : b.charAt(j) - '0';
          int sum = va + vb + carry;
          if (sum >= 2) {
            sb.append(sum - 2);
            carry = 1;
          } else {
            sb.append(sum);
            carry = 0;
          }
          i--;
          j--;
        }
        if (carry != 0) {
          sb.append(carry);
        }
        return sb.reverse().toString();
    }
}