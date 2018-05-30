// 311. Sparse Matrix Multiplication

// Given two sparse matrices A and B, return the result of AB.

// You may assume that A's column number is equal to B's row number.

// Example:

// Input:

// A = [
//   [ 1, 0, 0],
//   [-1, 0, 3]
// ]

// B = [
//   [ 7, 0, 0 ],
//   [ 0, 0, 0 ],
//   [ 0, 0, 1 ]
// ]

// Output:

//      |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
// AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
//                   | 0 0 1 |

class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int row_A = A.length, col_A = A[0].length;
        int row_B = B.length, col_B = B[0].length;
        int [][] result = new int[row_A][col_B];
        for (int row = 0; row < row_A; row++) {
            result[row] = mult(A[row], B);
        }
        return result;
    }
    
    public int[] mult(int[] row, int[][] cols) {
        int col_num = cols[0].length;
        int[] result = new int[col_num];
        for (int r = 0; r < cols.length; r++) {
            if (row[r] != 0) {
                for (int col = 0; col < col_num; col++) {
                    if (cols[r][col] != 0)               
                        result[col] += row[r] * cols[r][col];
                }
            }
        }
        return result;
    }
}

//Remark: save time if remove useless calculation.