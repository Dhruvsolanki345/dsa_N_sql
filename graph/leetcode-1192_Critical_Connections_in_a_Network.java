// https://leetcode.com/problems/critical-connections-in-a-network/

// Topic: Tarjan's Algorithm
// Reference: https://www.youtube.com/watch?v=RYaakWv5m6o

class Solution {
    List<List<Integer>> adj, res;
    int[] dis, low;
    int time;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for(List<Integer> pair: connections) {
            adj.get(pair.get(0)).add(pair.get(1));
            adj.get(pair.get(1)).add(pair.get(0));
        }
        
        time = 0;
        res = new ArrayList<>();
        dis = new int[n];
        low = new int[n];
        Arrays.fill(dis, -1);
        
        dfs(0, -1);
        
        return res;
    }
    
    private void dfs(int c, int p) {
        dis[c] = low[c] = time++;
        
        for(int neigh: adj.get(c)) {
            if(neigh == p) continue;
            
            if(dis[neigh] == -1) {
                dfs(neigh, c);
                low[c] = Math.min(low[c], low[neigh]);
            } else {
                low[c] = Math.min(low[c], dis[neigh]);
            }
            
            if(dis[c] < low[neigh]) {
                List<Integer> pair = new ArrayList<>();
                pair.add(c); pair.add(neigh);
                res.add(pair);
            }
        }
    }
}
