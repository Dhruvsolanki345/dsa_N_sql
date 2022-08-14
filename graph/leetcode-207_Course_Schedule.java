// https://leetcode.com/problems/course-schedule/

// Topic: indegree array with bfs

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses], visited = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        
        for(int[] edge: prerequisites) {
            indegree[edge[0]]++;
            adj.get(edge[1]).add(edge[0]);
        }
        
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) q.add(i);
        }
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            visited[curr] = 1;
            
            for(int neigh: adj.get(curr)) {
                indegree[neigh]--;
                if(visited[neigh] == 0 && indegree[neigh] == 0) {
                    q.add(neigh);
                }
            }
        }
        
        for(int curr: visited) {
            if(curr == 0) return false;
        }
        
        return true;
    }
}
