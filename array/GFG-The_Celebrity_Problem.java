// https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1

// time: O(n2), space: O(n)
class Solution { 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n) {
    	int[] follow = new int[n], follower = new int[n];
    	
    	for(int i = 0; i < n; i++) {
    	    for(int j = 0; j < n; j++) {
    	        if(M[i][j] == 0) continue;
    	        
    	        follow[i] = 1;
    	        follower[j]++;
    	        
    	        if(follower[j] == n-1 && follow[j] == 0) return j;
    	    }
    	}
    	
    	return -1;
    }
}

// time: O(n), space: O(n)
class Solution { 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n) {
    	Stack<Integer> st = new Stack<>();
    	
    	for(int i = 0; i < n; i++) st.push(i);
    	
    	while(st.size() >= 2) {
    	    int i = st.pop();
    	    int j = st.pop();
    	    
    	    if(M[i][j] == 1) {
    	        st.push(j);
    	    } else {
    	        st.push(i);
    	    }
    	}
    	
    	int e = st.pop();
    	
    	for(int i = 0; i < n; i++) {
    	    if(i == e) continue;
    	    
    	    if(M[e][i] == 1 || M[i][e] == 0) return -1;
    	}
    	
    	return e;
    }
}

// time: O(n), space: O(1)
class Solution { 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n) {
    	int i = n-1, j = n-2;
    	
    	while(j > -1) {
    	    if(M[i][j] == 1) i = j;
    	    
    	    j--;
    	}
    	
    	for(j = 0; j < n; j++) {
    	    if(i == j) continue;
    	    
    	    if(M[i][j] == 1 || M[j][i] == 0) return -1;
    	}
    	
    	return i;
    }
}
