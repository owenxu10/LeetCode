package old;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList();
        if (matrix.length == 0)
            return result;

        int row_start = 0;
        int column_start = 0;
        int row_end = matrix.length-1;
        int column_end = matrix[0].length-1;
        int c = 0;
        int r = 0;

        while((column_end>=column_start)&&(row_end>=row_start)){
            for(c = column_start;c <= column_end;c++){
                result.add(matrix[row_start][c]);
            }
            row_start++;

            for(r = row_start;r <= row_end;r++){
                result.add(matrix[r][column_end]);
            }
            column_end--;

            //* two ifs *
            if (row_start <= row_end) {
                for(c = column_end; c >= column_start;c--){
                    result.add(matrix[row_end][c]);
                }
            }
            row_end--;

            if (column_start <= column_end) {
                for(r = row_end; r >= row_start;r--){
                    result.add(matrix[r][column_start]);
                }
            }
            column_start++;
        }
        return result;
    }
}
