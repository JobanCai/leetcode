package leetcode.demo_019;

/**
 * 给你由 n 个小写字母字符串组成的数组 strs，其中每个字符串长度相等。
 *
 * 这些字符串可以每个一行，排成一个网格。例如，strs = ["abc", "bce", "cae"] 可以排列为：
 *
 * abc
 * bce
 * cae
 * 你需要找出并删除 不是按字典序升序排列的 列。在上面的例子（下标从 0 开始）中，列 0（'a', 'b', 'c'）和列 2（'c', 'e', 'e'）都是按升序排列的，而列 1（'b', 'c', 'a'）不是，所以要删除列 1 。
 *
 * 返回你需要删除的列数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-columns-to-make-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    
    public static void main (String[] args) {
        String[] strs = new String[]{"zyx","wvu","tsr"};
        System.out.println(minDeletionSize(strs));
    }

    public static int minDeletionSize(String[] strs) {
        int n = strs.length; // 行
        int m = strs[0].length(); // 列
        int result = 0;
        for (int i = 0; i < m; i++) {
            int row = 0;
            while (row < n - 1) {
                if (strs[row].charAt(i) > strs[++row].charAt(i)) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }
    
}
