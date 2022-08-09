// https://leetcode.com/problems/valid-sudoku/

// costly string operation
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                char ch = board[i][j];
                
                if(ch == '.') continue;
                
                if(!set.add(ch + "-row-" + i) ||
                   !set.add(ch + "-col-" + j) ||
                   !set.add(ch + "-block-" + i/3 + "-" + j/3)) {
                    return false;
                }
            }
        }
        
        return true;
    }
}

// optimized - separate arrays
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9], col = new boolean[9][9], block = new boolean[9][9];
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.') continue;
                
                // i / 3 * 3 != i ... as (i/3) truncates decimal e.g. i=8 then i/3 = 2 and 2*3=6 != 8
                int curr = board[i][j] - '0' - 1, k = i / 3 * 3 + j / 3;
                
                if(row[i][curr] || col[j][curr] || block[k][curr]) return false;
                
                row[i][curr] = col[j][curr] = block[k][curr] = true;
            }
        }
        
        return true;
    }
}
