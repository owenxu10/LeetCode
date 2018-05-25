// 265. Paint House II
// DescriptionHintsSubmissionsDiscussSolution
// There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

// The cost of painting each house with a certain color is represented by a n x k cost matrix. For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.

// Note:
// All costs are positive integers.

// Example:

// Input: [[1,5,3],[2,9,4]]
// Output: 5
// Explanation: Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5; 
//              Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5. 
// Follow up:
// Could you solve it in O(nk) runtime?


class Solution {
    public int minCostII(int[][] costs) {
    	int last_min = 0, last_min2 = 0, 
            min = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
    	for (int row = 0; row < costs.length; row++) {
    		for (int col = 0; col < costs[row].length; col++) {
    			if (row == 0) {
    				// first row
    				if (costs[row][col] < min) {
    					min2 = min;
    					min = costs[row][col];
    				} else if (costs[row][col] < min2) {
    					min2 = costs[row][col];
    				}
    			} else {
    				// update the column to current cost
    				if (costs[row-1][col] == last_min) {
    					costs[row][col] += last_min2;
    				} else {
    					costs[row][col] += last_min;
    				}

    				if (costs[row][col] < min) {
    					min2 = min;
                        min =costs[row][col];
    				} else if (costs[row][col] < min2) {
    					min2 = costs[row][col];
    				}
    			}
    		}
            last_min = min;
            last_min2 = min2;
            min = Integer.MAX_VALUE;
            min2 = Integer.MAX_VALUE;
    	}
    	return last_min;
    }

}
 