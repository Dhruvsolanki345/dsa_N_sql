// https://leetcode.com/problems/time-based-key-value-store/

class TimeMap {
    Map<String, List<Data>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) map.put(key, new ArrayList<>());
        
        map.get(key).add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        
        List<Data> list = map.get(key);
        int low = 0, high = list.size() - 1;
        String res = "";
        
        while(low <= high) {
            int mid = low + (high - low) / 2;
            Data curr = list.get(mid);
            
            if(timestamp == curr.timestamp) {
                res = curr.val;
                break;
            } else if(timestamp < curr.timestamp) {
                high = mid - 1;
            } else {
                res = curr.val;
                low = mid + 1;
            }
        }
        
        return res;
    }
    
    class Data {
        int timestamp;
        String val;
        Data(String _val, int _timestamp) {
            val = _val;
            timestamp = _timestamp;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
