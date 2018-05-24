// 301. Remove Invalid Parentheses

// Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

// Note: The input string may contain letters other than the parentheses ( and ).

// Example 1:

// Input: "()())()"
// Output: ["()()()", "(())()"]
// Example 2:

// Input: "(a)())()"
// Output: ["(a)()()", "(a())()"]
// Example 3:

// Input: ")("
// Output: [""]

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        dfs(s, result, 0, 0, new char[] {'(', ')'});
        return result;
    }
    
    public void dfs(String s, List<String> result, int last_i, int last_j, char[] pair) {
        int count = 0;
        for (int i = last_i; i < s.length(); i++) {
            if (s.charAt(i) == pair[0]) count++;
            if (s.charAt(i) == pair[1]) count--;
            if (count >= 0) continue;
            
            for (int j = last_j; j <= i; j++) {
                // if ()) just remove the first ) / and consider the situation )( which ) is the first.
                if (s.charAt(j) == pair[1] && (j == last_j || s.charAt(j-1) != s.charAt(j)))
                    dfs(s.substring(0, j) + s.substring(j+1, s.length()), result, i, j, pair);
            }
            return;
        }
        
        String reverse = new StringBuilder(s).reverse().toString();
        if(pair[0] == '(') 
            dfs(reverse, result, 0, 0, new char[] {')','('});
        else 
            // here means scan for two times and string is reversed.
            // just reverse back.
            result.add(reverse);
        
    }
}