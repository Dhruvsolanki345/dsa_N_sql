// https://leetcode.com/problems/minimum-time-difference/

// reference: 
// https://www.youtube.com/watch?v=-o_YDXNfRUY&list=PLtQWXpf5JNGJagakc_kBtOH5-gd8btjEW&index=18

class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] bucket = new boolean[1440];  // 1440 -> 24 hours in min  
        int first = 1439, last = 0;
        
        for(String point: timePoints) {
            String[] time = point.split(":");
            int minute = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            
            first = Math.min(first, minute);            
            last = Math.max(last, minute);
            
            if(bucket[minute]) return 0;
            
            bucket[minute] = true;
        }
        
        int prev = first;
        int min = 1440 - last + first;
        
        for(int curr = first+1; curr <= last; curr++) {
            if(!bucket[curr]) continue;
            
            min = Math.min(min, curr-prev);
            prev = curr;
        }
        
        return min;
    }
}
