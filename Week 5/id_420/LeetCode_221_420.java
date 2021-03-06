package geekbang.myleetcode.week05;

/**
 * @author: jimmy.wong
 * @date: 2019-11-17 23:46
 */
public class LeetCode_221_420 {
    public static void main(String[] args) {

    }

    class Solution {
        public int maximalSquare(char[][] matrix) {
            int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
            int[][] dp = new int[rows + 1][cols + 1];
            int maxsqlen = 0;
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= cols; j++) {
                    if (matrix[i-1][j-1] == '1'){
                        dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                        maxsqlen = Math.max(maxsqlen, dp[i][j]);
                    }
                }
            }
            return maxsqlen * maxsqlen;
        }
    }
}
