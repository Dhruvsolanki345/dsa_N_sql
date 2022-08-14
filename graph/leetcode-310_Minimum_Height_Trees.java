// https://leetcode.com/problems/minimum-height-trees/

// Reference: https://www.youtube.com/watch?v=1ZDg3jk7dUE

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        
        if(n == 1) {
            res.add(0);
            return res;
        }
        
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        int[] degree = new int[n];
        
        for(int[] edge: edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
            
            adj.putIfAbsent(edge[0], new HashSet<>());
            adj.get(edge[0]).add(edge[1]);
            
            adj.putIfAbsent(edge[1], new HashSet<>());
            adj.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++) {
            if(degree[i] == 1) q.offer(i);
        }
        
        int count = n;
        
        while(count > 2) {
            int size = q.size();
            count -= size;
            
            while(size-- > 0) {
                int curr = q.poll();
                
                for(int neigh: adj.get(curr)) {
                    degree[neigh]--;
                    // adj.get(curr).remove(neigh);
                    
                    if(degree[neigh] == 1) q.offer(neigh);
                }
            }
        }
        
        return new ArrayList<>(q);
    }
}
