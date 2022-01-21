package leetcode.demo_012;

/**
 * 给定一个字符串 s ，验证 s 是否是 回文串 ，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 本题中，将空字符串定义为有效的 回文串 。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * 示例 2:
 *
 * 输入: s = "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 2 * 105
 * 字符串 s 由 ASCII 字符组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/XltzEq
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {

    public static void main (String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

    public static boolean isPalindrome(String s) {
        char[] array = s.toCharArray();
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            while (i < array.length && !isNumOrLetter(array[i])) {
                i++;
            }
            while (j > 0 && !isNumOrLetter(array[j])) {
                j--;
            }
            if (i < j && !String.valueOf(array[i]).toUpperCase().equals(String.valueOf(array[j]).toUpperCase())) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean isNumOrLetter(char a) {
        if ((a >= '0' && a <= '9') || (a >= 'a' && a <= 'z')
                || (a >= 'A' && a <= 'Z')) {
            return true;
        }
        return false;
    }

}

// 官方解答
/*
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left += 1;
            } else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right -= 1;
            } else {
                char char1 = Character.toLowerCase(s.charAt(left++));
                char char2 = Character.toLowerCase(s.charAt(right--));
                if (char1 != char2) {
                    return false;
                }
            }
        }
        return true;
    }
}
 */
