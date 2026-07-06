class Solution {
    public int aggressiveCows(int[] arr, int k) {
       Arrays.sort(arr);
       
       int start = 1;
       int end = arr[arr.length-1] - arr[0];
       
       while(start <= end){
           int mid = start + (end - start) / 2;
           // this mid is give distance to check between cow 
           if(canPlace(arr, k, mid)){
               start = mid +1;
           }
           else {
               end = mid -1;
           }
       }
       return end;
        
    }
    public static boolean canPlace(int [] arr, int k , int distance){
        int cPC = 1; // Current Placed Cow
        
        int pAt = arr[0]; // pAt : Position at 
        // k : Total cow to br placed
        for (int p : arr){ // p: position
            if (p - pAt >= distance){
                cPC++;
                pAt = p;
                
                if( cPC == k){
                    return true;
                }
            }
        }
        return false;
    }
}