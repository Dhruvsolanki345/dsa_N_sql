// https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> res = new ArrayList<>();
        
        if(m[0][0] == 0) return res;
        
        dfs(0, 0, new StringBuilder(), m, n, res);
        
        res.sort((s1, s2) -> s1.compareTo(s2));
        
        return res;
    }
    
    private static void dfs(int i, int j, StringBuilder path, int[][] m, int n, ArrayList<String> res) {
        if(i == n-1 && j == n-1) {
            res.add(path.toString());
            return;
        }
        
        m[i][j] = 0;
        
        if(i-1 > -1 && m[i-1][j] == 1) {
            path.append('U');
            dfs(i-1, j, path, m, n, res);
            path.deleteCharAt(path.length() - 1);
        }
        if(j-1 > -1 && m[i][j-1] == 1) {
            path.append('L');
            dfs(i, j-1, path, m, n, res);
            path.deleteCharAt(path.length() - 1);
        }
        if(j+1 < n && m[i][j+1] == 1) {
            path.append('R');
            dfs(i, j+1, path, m, n, res);
            path.deleteCharAt(path.length() - 1);
        }
        if(i+1 < n && m[i+1][j] == 1) {
            path.append('D');
            dfs(i+1, j, path, m, n, res);
            path.deleteCharAt(path.length() - 1);
        }
        
        m[i][j] = 1;
    }
}
