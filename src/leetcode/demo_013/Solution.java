package leetcode.demo_013;


/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 *  
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main (String[] args) {

    }


    public static ListNode getKthFromEnd(ListNode head, int k) {
        // 计算链表的长度
        ListNode node = head;
        int count = 0;
        while (node != null) {
            count++;
            node = node.next;
        }
        int i = 0;
        node = head;
        // 找到倒数第K个节点
        while (node != null && i < count - k) {
            i++;
            node = node.next;
        }
        return node;
    }

}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
