// https://leetcode.com/problems/pascals-triangle/submissions/
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        
        List<Integer> inner = new ArrayList<>();
        inner.add(1);
        pascal.add(inner);
        
        for(int i = 1; i < numRows; i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j = 1; j < i; j++){
                List<Integer> prev = pascal.get(i - 1);
                int curr = prev.get(j - 1) + prev.get(j);
                temp.add(curr);
            } 
            temp.add(1);
            pascal.add(temp);
        }
        
        return pascal;
    }
}
