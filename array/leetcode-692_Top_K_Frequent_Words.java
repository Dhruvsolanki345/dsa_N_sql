// https://leetcode.com/problems/top-k-frequent-words/

// reference: 
// https://www.youtube.com/watch?v=cupg2TGIkyM&list=PLtQWXpf5JNGJagakc_kBtOH5-gd8btjEW&index=21

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        
        for(String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        int count = 0;
        PriorityQueue<String> q = new PriorityQueue<>((String w1, String w2) -> {
            int freq1 = map.get(w1);
            int freq2 = map.get(w2);
            
            if(freq1 == freq2) return w2.compareTo(w1);
            return freq1 - freq2;
        });
        
        for(String word: map.keySet()) {
            q.add(word);
            
            if(q.size() > k) q.poll();
        }
        
        List<String> res = new ArrayList<>();
        
        while(!q.isEmpty()) res.add(q.poll());
        Collections.reverse(res);
        
        return res;
    }
}
