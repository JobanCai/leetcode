package leetcode.demo_009;

import java.util.Arrays;

/**
 * 小力将 N 个零件的报价存于数组 nums。小力预算为 target，假定小力仅购买两个零件，要求购买零件的花费不超过预算，请问他有多少种采购方案。
 *
 * 注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
 *
 * 示例 1：
 *
 * 输入：nums = [2,5,3,5], target = 6
 *
 * 输出：1
 *
 * 解释：预算内仅能购买 nums[0] 与 nums[2]。
 *
 * 示例 2：
 *
 * 输入：nums = [2,2,1,9], target = 10
 *
 * 输出：4
 *
 * 解释：符合预算的采购方案如下：
 * nums[0] + nums[1] = 4
 * nums[0] + nums[2] = 3
 * nums[1] + nums[2] = 3
 * nums[2] + nums[3] = 10
 *
 * 提示：
 *
 * 2 <= nums.length <= 10^5
 * 1 <= nums[i], target <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4xy4Wx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main (String[] args) {
        int[] nums = new int[]{40330,31957,63879,13204,47923,56282,75126,3423,98483};
        int target = 60482;
        System.out.println(purchasePlansB(nums, target));
    }

    // 暴力解法，超时不通过
    public static int purchasePlansA(int[] nums, int target) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= target) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] <= target) {
                    result++;
                } else {
                    break;
                }
            }
        }
        return result % 1000000007;
    }

    // 双指针法
    public static int purchasePlansB(int[] nums, int target) {
        int result = 0;
        Arrays.sort(nums); // 先排序
        // 右指针向左侧移动，nums[low] + nums[high] <= target, 则区间的组合都满足
        // 继续移动左指针
        for (int i = 0, j = nums.length - 1; i < j; i++) {
            while (nums[i] + nums[j] > target && i < j) { // 此处i < j 保证右指针不会越过左指针
                j--;
            }
            result += j - i;
            result %= 1000000007;
        }

        return result % 1000000007;
    }

}
