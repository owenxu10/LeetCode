class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<String>();
        dfs(s, 0, 0, new char[]{'(', ')'}, result);
        return result;
    }
    
    public void dfs(String s, int last_i, int last_j, char[] pairs, List<String> result){
        int count = 0;    
        
        for(int i = last_i; i < s.length(); i++){
            if (s.charAt(i) == pairs[0]) count++;
            if (s.charAt(i) == pairs[1]) count--;
            if (count < 0) {
                for (int j = last_j; j <= i; j++) { 
                    //situation 1: first char is )
                    //situation 2: delete the last ) if stright ) : )))
                    if (s.charAt(j) == pairs[1] && ( j == last_j || s.charAt(j-1) != pairs[1])){
                        String news = s.substring(0, j) + s.substring(j+1, s.length());
                        dfs(news, i, j, pairs, result);
                    }
                }
                return;
            }
        }
        
        //check whether more ( than )
        String reverse_s = new StringBuilder(s).reverse().toString();
        if(pairs[0] == '('){
            dfs(reverse_s, 0, 0, new char[]{')', '('}, result);
        }
        else{
            result.add(reverse_s);
        }
            
    }
}
