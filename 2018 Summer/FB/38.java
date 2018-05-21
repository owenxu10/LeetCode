/*
38. Count and Say

he count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"


Idea: the (i+1)th sequence is the "count and say" of the ith sequence!

 */
class Solution {
  public String countAndSay(int n) {
    String base = "1";
    for (int i = 1; i < n; i++) {
      int count = 1;
      StringBuilder sb = new StringBuilder();
      int j = 0;
      for (; j < base.length() - 1; j++) {
        if (base.charAt(j) == base.charAt(j + 1)) {
          count++;
        } else {
          sb.append(count);
          sb.append(base.charAt(j));
          count = 1;
        }
      }
      sb.append(count);
      sb.append(base.charAt(j));
      base = sb.toString();
    }
    return base;
  }
}
