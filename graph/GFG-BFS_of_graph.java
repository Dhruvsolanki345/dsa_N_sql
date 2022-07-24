// https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

class Solution {
    
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(0);
        while(!q.isEmpty()) {
            int i = q.poll();
            
            if(visited[i]) continue;
            res.add(i);
            visited[i] = true;
            
            for(int n: adj.get(i)) {
                q.offer(n);
            }
        }
        
        return res;
    }
}
