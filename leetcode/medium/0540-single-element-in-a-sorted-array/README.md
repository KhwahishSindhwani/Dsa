# Single Element in a Sorted Array

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.

Return  *the single element that appears only once*.

Your solution must run in `O(log n)` time and `O(1)` space.

 

 **Example 1:** 

```
Input: nums = [1,1,2,3,3,4,4,8,8]
Output: 2

```

 **Example 2:** 

```
Input: nums = [3,3,7,7,10,11,11]
Output: 10

```

 

 **Constraints:** 

- 1 <= nums.length <= 105
- 0 <= nums[i] <= 105

## Solution

**Language:** Java  
**Runtime:** 0 ms  
**Memory:** 42.7 MB  
**Submitted:** 2026-07-04T19:52:43.405Z  

```java
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start =0;
        int end = nums.length-1;
        // if only one element in array 
        if(nums.length == 1){
            return nums[0];
        }

        // checking edge case :if check for first elment as it does no have left only right element
        if(nums[start] != nums[start+1]){
            return nums[start];
        }

        // checking edge case :if check for last elment as it does no have right only left element
        if(nums[end-1] != nums[end]){
            return nums[end];
        }

        start = start +1;
        end = end-1;

        while(start <= end ){
            int mid = start + (end-start)/2;

            if(nums[mid-1] != nums[mid] && nums[mid] != nums[mid+1] ){
                return nums[mid];
            }

            // if my elment is not prensent in left then element left or same for left 
            // 1 1 2 3 3 4 4 8 8
            // e o e o e o e o e   even - e and odd -o 

            if ( (mid % 2 == 0) && (nums [mid-1] == nums[mid]) || ( mid % 2 == 1) && (nums[mid] == nums[mid+1])){
                end = mid -1;
            } else{
                start = mid +1;
            }
        }

        return -1;
        
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/single-element-in-a-sorted-array/)