import java.util.Arrays;

public class DeleteOperationForTwoStrings583 {


    public static int solve(String w1,String w2,int i,int j,int[][]dp){
        if (i == w1.length() && j == w2.length()) return 0;
        if (i == w1.length() || j == w2.length()) return Math.max(w1.length() - i, w2.length() - j);
        if(dp[i][j] != -1) return dp[i][j];
        if (w1.charAt(i) == w2.charAt(j)) return solve(w1, w2, i + 1, j + 1, dp);
        return dp[i][j] = 1 + Math.min(solve(w1, w2, i + 1, j, dp), solve(w1, w2, i, j + 1, dp));
    }
    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int[] d : dp) Arrays.fill(d, -1);
        return solve(word1,word2,0,0,dp);
    }

    public static void main(String[] args) {
        String word1= "leetcode",word2="etco";
        System.out.println(minDistance(word1,word2));
    }
}
