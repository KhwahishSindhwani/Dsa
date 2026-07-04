class Solution {
    public int countRotations(int[] nums) {
        /*
        M1
        // write your code here 
        int pivot = findPivot(nums);
         return pivot +1;
        */
        /*
        M2
        // Get size of array
        int n = nums.length;
        // Traverse till second-last element
        for (int i = 0; i < n - 1; i++) {
            // If break in ascending order found
            if (nums[i] > nums[i + 1]) {
                // Index of next element is rotation count
                return i + 1;
            }
        }
        // No rotation found
        return 0;
        */
        int low = 0;
        int high = nums.length - 1;

        // Loop until low meets high
        while (low < high) {
            int mid = low + (high - low) / 2;

            // If mid element is greater than element at high,
            // smallest element lies to the right of mid
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                // Else smallest element is at mid or to the left
                high = mid;
            }
        }

        // When low == high, we found the smallest element
        return low;
    }
    /*
    static int findPivot (int [] nums){

        int start = 0;
        int end = nums.length-1;

        while(start <= end){
            int mid = start + (end - start)/2;

            // 4 Cases :
            // case 1
            if ( mid < end  && nums[mid] > nums[mid+1]){
                return mid;
            }
            //case 2
            if (mid > start && nums[mid - 1] > nums[mid]) {
                return mid - 1;
            }
            // case 3
            if( nums[mid] <= nums[start]){
                end = mid -1;
            }  else{  // case 4
                start = mid+1;
            }

        }
        return -1;
    } 
    */
}
