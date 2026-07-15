class Solution {
    public int missingNumber(int[] nums) {
        int i =0;
        int correct;
        while(i < nums.length){
             correct = i -1;
             if(nums[i] == 0){
                break;
             }
            if (nums[i] != correct ){
                return correct;
            }
            else{
                i++;
            }
        }
        return -1;
    }
}