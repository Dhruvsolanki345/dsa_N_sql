// https://www.codingninjas.com/codestudio/problems/graph-valid-tree_1376618?leftPanelTab=0

import java.util.*;

public class Solution {
    
    // TC n+m
    public static Boolean checkGraph(int[][] edges, int n, int m) {
        if(n-1 != m) return false;
        
        int[] visited = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        
        // TC n
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        // TC m
        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        Queue<Pair> q = new LinkedList<>();
        int count = 0;
        q.add(new Pair(0, -1));
        
        // TC n+m
        while(!q.isEmpty()) {
            Pair pair = q.poll();
            int curr = pair.n, p = pair.p;
            visited[curr] = 1;
            count++;
            
            // TC e
            for(int neigh: adj.get(curr)) {
                if(neigh == p) continue;
                if(visited[neigh] == 1) return false;
                q.add(new Pair(neigh, curr));
            }
        }
        
        return count == n;
    }
}
    
class Pair {
    int n; // curr node
    int p; // parent node
    Pair(int _n, int _p) {
        n = _n;
        p = _p;
    }
}
