// https://leetcode.com/problems/reachable-nodes-with-restrictions/

class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<List<Integer>> adj = new ArrayList<>();
        Set<Integer> restr = new HashSet<>();
        
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int num: restricted) restr.add(num);
        
        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        
        while(!q.isEmpty()) {
            count++;
            int node = q.poll();
            restr.add(node);
            
            for(int num: adj.get(node)) {
                if(!restr.contains(num)) q.add(num);
            }
        }
        
        return count;
    }
}
