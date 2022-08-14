// https://leetcode.com/problems/course-schedule-iv/

// Topic: dp, graph, floyd warshall

class Solution {
    
    // TC n3 + p + q ... numCourses == n, prerequisites == p, queries.length == q
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int[][] dist = new int[numCourses][numCourses];
        
        // TC n2
        for(int[] inner: dist) {
            Arrays.fill(inner, (int) 1e9);
        }
        
        // TC p
        for(int[] edge: prerequisites) {
            dist[edge[0]][edge[1]] = 1;
        }
        
        // TC n3
        for(int k = 0; k < numCourses; k++) {
            for(int i = 0; i < numCourses; i++) {
                for(int j = 0; j < numCourses; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        
        List<Boolean> op = new ArrayList<>();  
        
        // TC q
        for(int[] query: queries) {
            op.add(dist[query[0]][query[1]] < (int) 1e9);
        }
        
        return op;
    }
}
