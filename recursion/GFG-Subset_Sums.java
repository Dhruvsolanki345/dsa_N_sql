// https://practice.geeksforgeeks.org/problems/subset-sums2234/1

//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        return helper(arr, N, 0, 0, new ArrayList<Integer>());
    }
    
    private ArrayList<Integer> helper(ArrayList<Integer> arr, int N, int i, int sum, ArrayList<Integer> res){
        if(i == N) {
            res.add(sum);
            return res;
        }
        
        res = helper(arr, N, i + 1, sum + arr.get(i), res);
        res = helper(arr, N, i + 1, sum, res);
        
        return res;
    }
}
