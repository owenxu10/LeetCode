import java.util.Stack;

//Dijkstra's two-stack algorithm
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> num = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/") ) {
                int num1 = num.pop();
                int num2 = num.pop();
                if (tokens[i].equals("+"))
                    num.push(num2 + num1);
                else if (tokens[i].equals("-"))
                    num.push(num2 - num1);
                else if (tokens[i].equals("*"))
                    num.push(num2 * num1);
                else if (tokens[i].equals("/"))
                    num.push(num2 / num1);
            }
            else
                num.push(Integer.parseInt(tokens[i]));
        }

        int ret = num.pop();
        return ret;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.evalRPN(new String[]{"3","3","/"}));
    }
}