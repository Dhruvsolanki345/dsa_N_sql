// https://leetcode.com/problems/merge-intervals/
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 1) return intervals;
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        LinkedList<int []> merged = new LinkedList<>();
        
        for(int[] interval: intervals){
            if(merged.isEmpty()){
                merged.add(interval);
                continue;
            }
            int[] temp = merged.getLast();
            
            if(temp[1] >= interval[0]) {
                if(temp[1] < interval[1]) merged.getLast()[1] = interval[1];
            } else merged.add(interval);
        }
        
        return merged.toArray(new int[merged.size()][]);
    }
}
