import java.util.List;
import java.util.LinkedList;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new LinkedList<List<String>>();
        backtrace(n, null,result);
        return result;
    }

    public boolean backtrace(int n, List<String> solt, List<List<String>> result) {
        if (solt == null)
            solt = new LinkedList<String>();

        if (solt.size() == n)
            return true;

        for (int col = 0; col < n; col++) {
            int row = solt.size();
            boolean findPos = true;

            for(int old_row = 0; old_row < solt.size(); old_row++) {
                String prevQ = solt.get(old_row);
                int old_col = prevQ.indexOf('Q');
                if (row == old_row || col == old_col || row+col == old_row+old_col || row-col == old_row-old_col) {
                    findPos = false;
                    break;
                }
            }

            if (findPos) {
                StringBuilder newLine = new StringBuilder();
                for(int i = 0; i < n; i++) {
                    if (i == col)
                        newLine.append("Q");
                    else
                        newLine.append(".");
                }
                solt.add(newLine.toString());
                if (backtrace(n, solt, result)) {
                    result.add(new LINKEDList<String>(solt));
                }
                solt.remove(solt.size()-1);
            }
        }
        return false;
    }

    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.solveNQueens(4));
    }
}
