package leetcode.demo_003;

/**
 * Created by Jerliner on 2022/1/17.
 */
public class Solution {

    // 爬楼梯，一次可以爬一级或者两级，需要消耗当前数值，消耗最小爬到顶
    // 爬楼梯最少成本,一次可以跳两级。楼层顶部为第i + 1个阶梯
    // dp[0] = dp[1] = 0; 状态转移方程: dp[i] =MIN(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2])
    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i < cost.length + 1; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }

}
