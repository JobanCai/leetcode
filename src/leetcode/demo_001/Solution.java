package leetcode.demo_001;

public class Solution {

    public static void main(String[] args) {
        // 021
        int[] arr = {0, 5};
        System.out.println(maxChunksToSorted(arr));
    }

    public static int maxChunksToSorted(int[] arr) {
        int res = 0, max = 0;
        for (int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);//统计前i个位置的最大元素
            if (max == i) res++;
        }
        return res;
    }

}
