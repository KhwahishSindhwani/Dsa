class Solution {
    public int splitArray(int[] nums, int k) {
        int start = 0;
        int end =0;

        for (int i =0; i < nums.length; i++){
            start = Math.max(start, nums[i]); //in the end of loop this will contain the max of array 
            end = end + nums[i];
        }
        while(start < end){
          // try for the middle as potentail value
          int mid = start + (end-start)/2;

          // calculate how many piece  you can divide this in with this max sum

          int sum = 0;
          int pieces = 1;
          for (int num : nums){
            if (sum + num > mid){
                // you cannot add this in this subarray, make new one 
                // say you add this num in new subarray, then sum = num
                sum = num;
                pieces++;
            } else {
                sum = sum + num;
            }
          }
          if(pieces > k){
            start = mid +1;
          }else{
            end = mid;
          }
        }
        return end;
    }
  
}