import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                while( i < path.length() && path.charAt(i) == '/' ) i++; // ..//..
                int j = i;
                for (j = i; j < path.length() && path.charAt(j) != '/'; j++) ;
                if (j - i == 2 && path.charAt(i) == '.' && path.charAt(i + 1) == '.') {
                    if (!stack.isEmpty()) stack.pop();
                }
                else if (!(j - i == 1 && path.charAt(i) == '.'))
                    stack.push(path.substring(i, j));
                i = j-1;
            }

        }

        String result = "";

        while(!stack.isEmpty()) {
            String folder = stack.pop();
            if (folder.equals("") && stack.isEmpty())
                result = "/" + result;

            if (!folder.equals("")) {
                result = "/" + folder +result;
            }
        }
        return result.length() == 0 ? "/" : result;
    }

    //better solution use split("/")
    public String bettersimplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!skip.contains(dir)) stack.push(dir);
        }
        String res = "";
        for (String dir : stack) res = "/" + dir + res;
        return res.isEmpty() ? "/" : res;
    }
}


