// https://leetcode.com/problems/surrounded-regions/

class Solution {
    char[][] board;
    int m, n;
    
    public void solve(char[][] board) {
        m = board.length; 
        n = board[0].length;
        this.board = board;
        
        if(m == 1 || n == 1) return;
        
        for(int i = 0; i < m; i++) {
            if(board[i][0] == 'O') resolveBorder(i, 0);    // left border
            if(board[i][n-1] == 'O') resolveBorder(i, n-1);  // right border
        }
        
        for(int j = 0; j < n; j++) {
            if(board[0][j] == 'O') resolveBorder(0, j);    // top border
            if(board[m-1][j] == 'O') resolveBorder(m-1, j);  // bottom border
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'R') board[i][j] = 'O';
                else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
    
    private void resolveBorder(int i, int j) {
        board[i][j] = 'R';
        
        if(i-1 > -1 && board[i-1][j] == 'O') resolveBorder(i-1, j);
        if(i+1 < m && board[i+1][j] == 'O') resolveBorder(i+1, j);
        if(j-1 > -1 && board[i][j-1] == 'O') resolveBorder(i, j-1);
        if(j+1 < n && board[i][j+1] == 'O') resolveBorder(i, j+1);
    }
}
