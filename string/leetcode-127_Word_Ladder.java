// https://leetcode.com/problems/word-ladder/

// reference: 
// https://www.youtube.com/watch?v=5iFZP-f40iI&list=PLtQWXpf5JNGJagakc_kBtOH5-gd8btjEW&index=24

// Topic: breadth first search

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        
        if(!set.contains(endWord)) return 0;
        
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int count = 1;
        
        q.offer(beginWord);
        visited.add(beginWord);
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            for(int i = 0; i < size; i++) {
                String word = q.poll();
                if(word.equals(endWord)) return count;
                
                char[] str = word.toCharArray();                
                for(int j = 0; j < str.length; j++) {
                    char curr = str[j];
                    
                    for(int k = 'a'; k <= 'z'; k++) {
                        str[j] = (char) k;
                        
                        String generated = new String(str);
                        if(!set.contains(generated) || visited.contains(generated)) continue;
                        
                        q.offer(generated);
                        visited.add(generated);
                    }
                    
                    str[j] = curr;
                }
            }
            
            count++;
        }
        
        return 0;
    }
}
