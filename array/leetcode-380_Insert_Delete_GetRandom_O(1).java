// https://leetcode.com/problems/insert-delete-getrandom-o1/

class RandomizedSet {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random random;
    
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        
        map.put(val, list.size());
        list.add(val);
        
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        
        int id = map.get(val), last = list.get(list.size() - 1);
        
        list.set(id, last);
        map.put(last, id);
        map.remove(val);
        list.remove(list.size() - 1);
        
        return true;
    }
    
    public int getRandom() {
        int id = random.nextInt(list.size());
        
        return list.get(id);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
