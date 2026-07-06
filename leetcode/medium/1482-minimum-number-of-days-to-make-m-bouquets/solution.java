class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        for (int i : bloomDay){

            start = Math.min(start, i);
            end = Math.max(end, i);
            
        }
        //m1
        //int ans =-1 ;
        //m2
        if ((long)k*m > bloomDay.length){
            return -1;
        }

        while(start <= end){
            int mid = start + (end - start ) /2;

            if (isMade(bloomDay, m, k, mid)){
                //m1
                //ans = mid ;
                //m2
                end = mid -1;
            }
            else{
                start = mid +1;
            }
        }
        return start;
        
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