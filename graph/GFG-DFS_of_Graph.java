// https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

class Solution {
    ArrayList<Integer> res;
    ArrayList<ArrayList<Integer>> adj;
    boolean[] visited;
    
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        res = new ArrayList<>();
        visited = new boolean[adj.size()];
        this.adj = adj;
        
        dfs(0);
        
        return res;
    }
    
    private void dfs(int i) {
        visited[i] = true;
        res.add(i);
        
        for(int n: adj.get(i)) {
            if(visited[n]) continue;
            
            dfs(n);
        }
    }
    
}
