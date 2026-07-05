class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long required = (long) m * k;
        if (required > bloomDay.length) return -1; // not enough flowers

        int minDay = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;

        // Find the minimum and maximum bloom day
        for (int bloom : bloomDay) {
            minDay = Math.min(minDay, bloom);
            maxDay = Math.max(maxDay, bloom);
        }

        // Binary search between minDay and maxDay
        int low = minDay, high = maxDay, result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (ifBloomed(bloomDay, mid, m, k)) {
                result = mid; // possible to form bouquets, try earlier
                high = mid - 1;
            } else {
                low = mid + 1; // need more days
            }
        }

        return result;
    }
    // check if flower is bloom 
    public static boolean ifBloomed(int [] bloomDay, int day, int m, int k){
        int count = 0;
        int bouquet =0;

        for(int i =0; i < bloomDay.length; i++){
            if (bloomDay[i] >= day ){
                count++;
                if(count == k){
                    bouquet++;
                    count = 0;
                    return true;
                }
        
            }
            else{
                count =0;
            }
            
        }
        return false; 

    }
}