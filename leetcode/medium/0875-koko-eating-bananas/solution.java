class Solution {
    public static int maxIN(int [] piles){
        int max= Integer.MIN_VALUE;
        for(int pile : piles){
            max = Math.max(pile, max);
        }
        return max;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = maxIN(piles);
        int ans = 0;


        while (start <= end){
            int mid = start + ( end - start ) / 2;

            if (canEat(piles, h, mid)){
                ans = mid;
                end = mid-1;
            } 
            else{
                start = mid + 1;
            }
        }
        return ans;
        
    }
    public static boolean canEat(int [] piles, int h, int speed){

        int hour = 0;

        for (int pile : piles){
            
            // celing of no :
            hour = hour + (pile + speed - 1 ) / speed;
            if (hour < h){
                return true;
            }
        }
        return false;
    }
}