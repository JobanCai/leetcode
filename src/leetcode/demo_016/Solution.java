package leetcode.demo_016;

/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 差值是一个正数，其数值等于两值之差的绝对值。
 */
public class Solution {
    
    public static void main (String[] args) {
        // 1.方法一:遍历二叉树，保存到数组中，在遍历数组求最小值
        // 2.方法二:遍历二叉树，使用一个变量保存前序节点
    }

    static int pre = -1;
    static int result = Integer.MAX_VALUE;

    // 中根遍历，设置变量pre记录前序节点值
    public static int minDiffInBST(TreeNode root) {
        dfs(root);
        return result;
    }

    // 中根遍历
    public static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);

        // 更新pre的值、更新结果值
        if (pre == -1) { // 整棵树最左边的节点
            pre = root.val;
        } else {
            result = Math.min(result, Math.abs(root.val - pre));
            pre = root.val;
        }


        dfs(root.right);
    }
    
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
