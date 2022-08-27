// https://leetcode.com/problems/redundant-connection/

// Topic: disjoint set

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        int[] parent = new int[n], rank = new int[n];
        
        for(int i = 0; i < n; i++) parent[i] = i;
        Arrays.fill(rank, 1);
        
        for(int[] edge: edges) {
            if(union(edge[0], edge[1], parent, rank) == false) {
                return edge;
            }
        }
        
        return new int[2];
    }
    
    private boolean union(int p, int c, int[] parent, int[] rank) {
        int pp = find(p, parent); // parent of p
        int pc = find(c, parent); // parent of c;
        
        if(pp == pc) return false;
        
        if(rank[pp] > rank[pc]) {
            parent[pc] = parent[pp];
            rank[pp] += rank[pc];
        } else {
            parent[pp] = parent[pc];
            rank[pc] += rank[pp];
        } 
        
        return true;
    }
    
    private int find(int n, int[] parent) {
        if(parent[n] == n) return n;
        
        return parent[n] = find(parent[n], parent);
    }
}
