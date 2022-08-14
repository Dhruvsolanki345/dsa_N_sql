// https://leetcode.com/problems/course-schedule-ii/

// Topic: indegree with bfs, topological sort

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses], visited = new int[numCourses];
        int[] op = new int[numCourses];
        
        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        
        for(int[] edge: prerequisites) {
            indegree[edge[0]]++;
            adj.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) q.add(i);
        }
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            visited[curr] = 1;
            op[count++] = curr;
            
            for(int neigh: adj.get(curr)) {
                indegree[neigh]--;
                
                if(visited[neigh] == 0 && indegree[neigh] == 0) {
                    q.add(neigh);
                }
            }
        }
        
        return (count == numCourses) ? op : new int[0];
    }
}
