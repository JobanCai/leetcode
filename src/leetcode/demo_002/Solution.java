package leetcode.demo_002;

/**
 * 设计一个算法，判断玩家是否赢了井字游戏。输入是一个 N x N 的数组棋盘，由字符" "，"X"和"O"组成，其中字符" "代表一个空位。
 *
 * 以下是井字游戏的规则：
 *
 * 玩家轮流将字符放入空位（" "）中。
 * 第一个玩家总是放字符"O"，且第二个玩家总是放字符"X"。
 * "X"和"O"只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有N个相同（且非空）的字符填充任何行、列或对角线时，游戏结束，对应该字符的玩家获胜。
 * 当所有位置非空时，也算为游戏结束。
 * 如果游戏结束，玩家不允许再放置字符。
 * 如果游戏存在获胜者，就返回该游戏的获胜者使用的字符（"X"或"O"）；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/tic-tac-toe-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 示例 1：
 *
 * 输入： board = ["O X"," XO","X O"]
 * 输出： "X"
 * 示例 2：
 *
 * 输入： board = ["OOX","XXO","OXO"]
 * 输出： "Draw"
 * 解释： 没有玩家获胜且不存在空位
 * 示例 3：
 *
 * 输入： board = ["OOX","XXO","OX "]
 * 输出： "Pending"
 * 解释： 没有玩家获胜且仍存在空位
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/tic-tac-toe-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 提示：
 *
 * 1 <= board.length == board[i].length <= 100
 * 输入一定遵循井字棋规则
 */
public class Solution {

    public static void main(String[] args) {
        String[] board = new String[]{"   X O  O "," X X    O ","X  X    O ","X    OX O ","X   XO  O ","X  X O  O ","O  X O  O ","     O  OX","     O  O ","   X XXXO "};
        System.out.println(tictactoe(board));
    }

    public static String tictactoe(String[] board) {
        int N = board.length;
        boolean isPending = false; // 矩阵中是否有空位
        boolean[] isRow = new boolean[N]; // 行完成
        boolean[] isCol = new boolean[N]; // 列完成
        for (int i = 0; i < N; i++) {
            isRow[i] = true;
            isCol[i] = true;
        }
        boolean isForwardDiagonal = true; // 正对角线满足
        boolean isBackDiagonal = true; // 反对角线满足

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (' ' == board[i].toCharArray()[j]) {
                    isPending = true;
                    continue;
                }
                if (j < N - 1 && board[i].toCharArray()[j] != board[i].toCharArray()[j + 1]) {
                    isRow[i] = false; // 该行不满足
                }
                if (i < N - 1 && board[i].toCharArray()[j] != board[i + 1].toCharArray()[j]) {
                    isCol[j] = false; // 该列不满足
                }
                if (i == j && board[i].toCharArray()[j] != board[N/2].toCharArray()[N/2]) { // 正对角线
                    isForwardDiagonal = false;
                }
                if (i + j == N - 1 && board[i].toCharArray()[j] != board[N - 1].toCharArray()[0]) { // 反对角线
                    isBackDiagonal = false;
                }
            }
        }

        if (isForwardDiagonal && ' ' != board[0].toCharArray()[0]) {
            return String.valueOf(board[0].toCharArray()[0]);
        }
        if (isBackDiagonal && ' ' != board[0].toCharArray()[N - 1]) {
            return String.valueOf(board[0].toCharArray()[N - 1]);
        }
        for (int i = 0; i < N; i++) {
            if (isRow[i] && ' ' != board[i].toCharArray()[0]) {
                return String.valueOf(board[i].toCharArray()[0]);
            }
            if (isCol[i] && ' ' != board[0].toCharArray()[i]) {
                return String.valueOf(board[0].toCharArray()[i]);
            }
        }
        if (isPending) {
            return "Pending";
        }
        return "Draw";
    }

}

