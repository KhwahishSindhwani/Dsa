class Solution {
    public int searchInsert(int[] nums, int target) {
        if (floor(nums, target) == -1){
            return nums[0];
        }
        return floor(nums,target)+1;
    }
    static int floor(int [] nums , int target ){
        int start = 0;
        int end = nums.length-1;

        // if target no smaller than the intert no 

        if(target < nums[start]){
            return -1;
        }
        while (start <= end){
            int mid = start +(end-start)/2;

            if(nums[mid]== target){
                return mid;
            }
            if(nums[mid] < target ){
                start = mid + 1;
            }else{
                end = mid -1;
            }
        }
        return end;
    }
}