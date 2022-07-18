// https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1#

class Solution {
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        JobComparator comp = new JobComparator();
        Arrays.sort(arr, comp);
        
        int maxDead = 0;
        for(Job job: arr) maxDead = Math.max(maxDead, job.deadline);
        
        int count = 0, profit = 0, seq[] = new int[maxDead];
        for(Job job: arr) {
            if(count == maxDead) break;
            
            int i = job.deadline - 1;
            while(i >= 0 && seq[i] != 0) i--;
            
            if(i < 0) continue;
            seq[i] = job.id;
            
            count++;
            profit += job.profit;
        }
        
        return new int[]{count, profit};
    }
}

class JobComparator implements Comparator<Job> {
    @Override
    public int compare(Job j1, Job j2){
        if(j1.profit > j2.profit) return -1;
        else if(j1.profit < j2.profit) return 1;
        else if(j1.deadline < j2.deadline) return -1;
        else return 1;
    }
}
