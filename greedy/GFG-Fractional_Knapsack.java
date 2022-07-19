// https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1

/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution {
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr, (Item i1, Item i2) -> {
            double r1 = (double) i1.value / (double) i1.weight;
            double r2 = (double) i2.value / (double) i2.weight;
            
            return (r1 > r2) ? -1 : (r1 < r2) ? 1 : 0;
        });
        
        int remaining = W;
        double totalV = 0;
        for(Item item: arr){
            if(remaining - item.weight >= 0){
                remaining -= item.weight;
                totalV += item.value;
            } else {
                double temp = (double) remaining / item.weight;
                totalV +=  (double) item.value * temp;
                break;
            }
        }
        
        return totalV;
    }
}
