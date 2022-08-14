// https://leetcode.com/problems/course-schedule-iii/

class Solution {
    
    // TC nlogn
    public int scheduleCourse(int[][] courses) {
        // TC nlogn         
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int time = 0;
        
        // TC nlogn         
        for(int[] course: courses) {
            if(time + course[0] <= course[1]) {
                pq.offer(course[0]);
                time += course[0];
            } else if(!pq.isEmpty() && pq.peek() > course[0]) {
                // TC logn
                time += course[0] - pq.poll();
                pq.offer(course[0]);
            }
        }
        
        return pq.size();
    }
}
