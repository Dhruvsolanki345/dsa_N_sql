// https://leetcode.com/problems/game-of-life/description/

// Conversion
// old || new || mapped
// 0      0      0
// 1      0      1
// 0      1      2
// 1      1      3

class Solution {
    int[][] board;

    public void gameOfLife(int[][] board) {
        this.board = board;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int neigh = countNeigh(i, j);

                if (board[i][j] == 1) {
                    if (neigh == 2 || neigh == 3) board[i][j] = 3;
                } else {
                    if (neigh == 3) board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = 0;
                } else if (board[i][j] == 2 || board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int countNeigh(int r, int c) {
        int count = 0;

        for (int i = r-1; i <= r+1; i++) {
            for (int j = c-1; j <= c+1; j++) {
                if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || (i == r && j == c)) {
                    continue;
                }

                if (board[i][j] == 1 || board[i][j] == 3) {
                    count++;
                }
            }
        }

        return count;
    }
}
