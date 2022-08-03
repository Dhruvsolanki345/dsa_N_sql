// https://leetcode.com/problems/word-search/
class Solution {
    char[][] board;
    String word;
    int m, n, wc;
    
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        m = board.length;
        n = board[0].length;
        wc = word.length();
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(findRecursive(i, j, 0)) return true;
            }
        }
        
        return false;
    }
    
    private boolean findRecursive(int i, int j, int wi) {
        if(wi == wc) return true;
        if(i == m || i < 0 || j == n || j < 0 || board[i][j] != word.charAt(wi)) return false;
        
        char ch = board[i][j];
        board[i][j] = '-';
        
        boolean take = findRecursive(i-1,j, wi+1) || findRecursive(i,j-1, wi+1) || 
                findRecursive(i,j+1, wi+1) || findRecursive(i+1,j, wi+1);
        
        board[i][j] = ch;
        
        return take;
    }
}
