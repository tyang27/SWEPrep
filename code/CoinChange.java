import java.util.*;
class CoinChange {


  static int coinChange(int amount, int[] coins) {
    if (amount == 0) return 0;

    int[] dp = new int[amount+1];
    Arrays.fill(dp, -1);

    for (int i = 0; i <= amount; i++) {
      for (int c : coins) {
        if (i-c < 0) continue;
        if (i-c == 0) dp[i] = 1;
        if (dp[i - c] != -1 && dp[i] == -1) dp[i] = dp[i-c] + 1;
        else if (dp[i - c] != -1) dp[i] = Math.min(dp[i], dp[i-c] + 1);
      }
    }
    return dp[amount];
  }

  static int coinChange2(int amount, int[] coins) {
    if (amount == 0) return 1;
    if (coins.length == 0) return 0;

    int[] dp = new int[amount+1];
    dp[0] = 1;

    for (int c : coins) { // This ordering prevents double counting.
      for (int i = 0; i <= amount; i++) {
        if (i-c < 0) continue;
        dp[i] += dp[i-c];
      }
    }
    return dp[amount];
  }

  static int coinChange2a(int amount, int[] coins) {
    if (amount == 0) return 1;
    if (coins.length == 0) return 0;

    int[][] dp = new int[amount+1][coins.length];
    Arrays.fill(dp[0], 1); // You can make $0 1 way.
    Arrays.sort(coins);

    for (int i = 0; i <= amount; i++) {
      for (int j = 0; j < coins.length; j++) {
        // f(amt, {1,2,5}) >= f(amt, {1,2})
        if (j-1 >= 0) dp[i][j] = dp[i][j-1];

        // Difference goes past 0.
        int diff = i-coins[j];
        if (diff < 0) continue;

        // Add f(amt-1, {1}) + f(amt-2, {1,2}) + f(amount-5, {1,2,5})
        dp[i][j] += dp[diff][j];
      }
    }
    return dp[amount][coins.length-1];
  }

  public static void main(String[] args) {
    System.out.println(coinChange(11, new int[]{1, 2, 5}));
    System.out.println(coinChange(3, new int[]{2}));
    System.out.println(coinChange2(5, new int[]{1, 2, 5}));
    System.out.println(coinChange2a(5, new int[]{1, 2, 5}));
  }
}
