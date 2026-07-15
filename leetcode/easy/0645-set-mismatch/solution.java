class Solution {
    public int[] findErrorNums(int[] nums) {
         int i = 0;
        while (i < nums.length){
            int correct = nums[i] -1;
            if (nums[i] != nums[correct]){
                swap(nums, i, correct);
            }
            else {
                i++;
            }
        }
        //int [] ans = new int [2];
        for (int index = 0; index<nums.length; index++){
            if (nums[index] != index +1){
                //ans[0] = nums[index];
                //ans[1] = index+1;
                //ans = {nums[index], index+1};
                // i can do 
                // avoid creating an array it will take space
                 return new int[]{nums[index], index+1};
            }
        }
       // return ans;
        // or if above one retirn is used
         return new int[]{-1,-1};
    }
     void swap (int [] nums, int first , int second ){
        int temp = nums[first];
    nums[first] = nums[second];
    nums[second] = temp;
    }
}