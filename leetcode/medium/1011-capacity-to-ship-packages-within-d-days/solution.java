class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        int high = 0 ;
        for(int weight : weights){
            low = Math.max(low,weight);
            high = high + weight;
        } 
        while(low <= high){
            int mid = low + (high-low)/2;

            if (isShipped(weights, days, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return low;
        
    }
    static boolean isShipped(int [] weights, int days, int load){
        int currentLoad = 0;
        int requiredDays = 1; 
        for (int weight : weights){

             currentLoad = currentLoad + weight;
            if (currentLoad > load){
                requiredDays++;
                currentLoad = weight;
            }

            if (requiredDays > days){
                return false;
            }
        }
        return true;
    }
}