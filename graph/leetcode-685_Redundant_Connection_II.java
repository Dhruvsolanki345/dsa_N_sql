// https://leetcode.com/problems/redundant-connection-ii/

// Topic: indegree, Disjoint set

class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length + 1;
        
        int[] indegree = new int[n]; // indegree storing edge index
        int b1 = -1, b2 = -1;        // blacklisted edge index
        
        Arrays.fill(indegree, -1);
        for(int i = 0; i < n-1; i++) {
            int p = edges[i][0], c = edges[i][1];
            
            if(indegree[c] != -1) {
                b1 = indegree[c];
                b2 = i;
                break;
            }
            
            indegree[c] = i;
        }
        
        int[] parent = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
        
        for(int i = 0; i < n-1; i++) {
            if(i == b2) continue;
            
            int p = edges[i][0], c = edges[i][1];
            
            if(union(p, c, parent) == false) {
                if(b2 != -1) {
                    return edges[b1];
                } else {
                    return edges[i];
                }
            }
        }
        
        return edges[b2];
    }
    
    private boolean union(int p, int c, int[] parent) {
        int pp = find(p, parent);  // parent of p
        int pc = find(c, parent);  // parent of c
        
        if(pp == pc) return false;
        
        parent[pc] = parent[pp];
        
        return true;
    }
    
    private int find(int n, int[] parent) {
        if(parent[n] == n) return n;
        
        return parent[n] = find(parent[n], parent);
    }
}
