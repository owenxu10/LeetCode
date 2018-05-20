/**
 * Created by owen on 2017/5/18.
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        String[] strs = s.split(" ");
        String lastWord = "";
        if (strs.length > 0) {
            lastWord = strs[strs.length-1];
        }

        return lastWord.length();
    }

    public static void main(String args[]) {

        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord("hello word"));
    }

}
