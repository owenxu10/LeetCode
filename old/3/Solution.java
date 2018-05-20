// 3. Longest Substring Without Repeating Characters

// Given a string, find the length of the longest substring without repeating characters. 
// For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
// For "bbbbb" the longest substring is "b", with the length of 1.

public class Solution {
	    public int lengthOfLongestSubstring(String s) {
	        int p1,p2;
	    	int max = 0;
	        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
	        for(p1 = 0, p2= 0; p2<=s.length()-1; p2++){
	        	if(map.containsKey(s.charAt(p2)))
	        		p1 = Math.max(p1, map.get(s.charAt(p2))+1);
	        	map.put(s.charAt(p2), p2);
	        	max = Math.max(max,p2-p1+1);
	        }
	            
	        return max;
	    }
	}