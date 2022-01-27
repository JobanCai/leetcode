package leetcode.demo_018;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *  
 *
 * 提示：
 *
 * 1 <= n <= 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    
    public static void main (String[] args) {
        generateParenthesis(3);
//        System.out.println((1 << 4) - 1);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        int range = (1 << 2 * n) - 1;
        for (int i = (1 << n) - 1; i <= range; i++) { // 起始位置
            if (Integer.bitCount(i) == n) { // 有n对括号
                Stack<Character> stack = new Stack<>();
                StringBuilder s = new StringBuilder(Integer.toBinaryString(i));
                while (s.length() < 2 * n) { // 补齐前导零
                    s.insert(0, "0");
                }
                // 判断是否符合括号, 利用栈
                char[] array = s.toString().toCharArray();
                boolean flag = true;
                for (char c : array) {
                    if ('0' == c) {
                        stack.push(c);
                    } else {
                        if (stack.isEmpty() || stack.pop() != '0') {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    result.add(s.toString().replace("0", "(").replace("1", ")"));
                }
            }
        }
        return result;
    }
    
}
