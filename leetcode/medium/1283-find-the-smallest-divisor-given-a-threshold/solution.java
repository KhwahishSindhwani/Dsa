class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = Integer.MIN_VALUE;
        for(int num : nums){
          
            end = Math.max(end, num);
        }
        while(start <= end){
            int mid = start + (end - start)/2;

            if(isDivisor(nums, threshold, mid)){
                end = mid -1;
            }
            else {
                start = mid +1;
            }
        }
        return start;

    }
    static boolean isDivisor(int [] nums, int threshold, int divisor){

        int sumResult = 0;
       
        for(int num : nums){
            //celling as there is approx equal to oe greater then
            sumResult = sumResult + (num + divisor -1)/divisor;

            if (sumResult > threshold){
                  return false;
            }
            
        }
       return true; 
    }
}