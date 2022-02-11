package leetcode.demo_020;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 给你两个长度相等的字符串 s 和 t。每一个步骤中，你可以选择将 t 中的 任一字符 替换为 另一个字符。
 *
 * 返回使 t 成为 s 的字母异位词的最小步骤数。
 *
 * 字母异位词 指字母相同，但排列不同（也可能相同）的字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输出：s = "bab", t = "aba"
 * 输出：1
 * 提示：用 'b' 替换 t 中的第一个 'a'，t = "bba" 是 s 的一个字母异位词。
 * 示例 2：
 *
 * 输出：s = "leetcode", t = "practice"
 * 输出：5
 * 提示：用合适的字符替换 t 中的 'p', 'r', 'a', 'i' 和 'c'，使 t 变成 s 的字母异位词。
 * 示例 3：
 *
 * 输出：s = "anagram", t = "mangaar"
 * 输出：0
 * 提示："anagram" 和 "mangaar" 本身就是一组字母异位词。
 * 示例 4：
 *
 * 输出：s = "xxyyzz", t = "xxyyzz"
 * 输出：0
 * 示例 5：
 *
 * 输出：s = "friend", t = "family"
 * 输出：4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-steps-to-make-two-strings-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main (String[] args) {
        System.out.println(minSteps("gctcxyuluxjuxnsvmomavutrrfb",
                "qijrjrhqqjxjtprybrzpyfyqtzf"));
    }

    // 两个map进行比较
    public static int minSteps(String s, String t) {
        Map<Character, Integer> orgin = new HashMap<>();
        Map<Character, Integer> dest = new HashMap<>();
        int n = s.length();
        char[] array1 = s.toCharArray();
        char[] array2 = t.toCharArray();
        for (int i = 0; i < n; i++) {
            orgin.put(array1[i], orgin.getOrDefault(array1[i], 0) + 1);
            dest.put(array2[i], dest.getOrDefault(array2[i], 0) + 1);
        }
        AtomicInteger result = new AtomicInteger(0);

        dest.forEach((k, v) -> {
            if (orgin.get(k) == null) {
                result.addAndGet(v);
            }
            if (orgin.get(k) != null && orgin.get(k) < v) {
                result.addAndGet(v - orgin.get(k));
            }
        });
        return result.get();
    }

}
