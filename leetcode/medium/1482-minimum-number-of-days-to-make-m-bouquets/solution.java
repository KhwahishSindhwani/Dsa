class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        for (int i : bloomDay){

            start = Math.min(start, i);
            end = Math.max(end, i);
            
        }
        int ans =0 ;

        while(start <= end){
            int mid = start + (end - start ) /2;

            if (isMade(bloomDay, m, k, mid)){
                ans = mid ;
                end = mid -1;
            }
            else{
                start = mid +1;
            }
        }
        return ans;
        
    }
    public static boolean isMade(int[] bloomDay, int m, int k, int day){
        int bloomed = 0;
        int bouquet = 0;

        for (int fDay : bloomDay){

            if (fDay <= day ){
                bloomed++;
                if (bloomed == k){
                    bouquet++;
                    bloomed = 0;
                    if (bouquet >= m){
                        return true;
                    }
                }            
            }
            else {
                bloomed = 0;
            }
        }
        return false;
    }
}