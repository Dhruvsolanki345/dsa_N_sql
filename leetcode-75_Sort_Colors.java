import java.util.Map;
import java.util.HashMap;

class Solution {
    public void sortColors(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            Integer temp = nums[i];
            if(map.containsKey(temp)) map.put(temp, map.get(temp)+1);
            else map.put(temp, 1);
        }
        
        int id = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            for(int i = 0; i < entry.getValue(); i++){
                nums[id++] = entry.getKey();
            }
        }
    }
}
