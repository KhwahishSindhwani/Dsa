# Search Insert Position

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with `O(log n)` runtime complexity.

 

 **Example 1:** 

```
Input: nums = [1,3,5,6], target = 5
Output: 2

```

 **Example 2:** 

```
Input: nums = [1,3,5,6], target = 2
Output: 1

```

 **Example 3:** 

```
Input: nums = [1,3,5,6], target = 7
Output: 4

```

 

 **Constraints:** 

- 1 <= nums.length <= 104
- -104 <= nums[i] <= 104
- nums contains distinct values sorted in ascending order.
- -104 <= target <= 104

## Solution

**Language:** Java  
**Runtime:** 0 ms  
**Memory:** 42.8 MB  
**Submitted:** 2026-07-04T18:36:41.864Z  

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int index = floor(nums,target);
        if (index == -1){
            return nums[0];
        }else if (nums[index] == target) {
            return index;
        }
        return index+1;
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
```

---

[View on LeetCode](https://leetcode.com/problems/search-insert-position/)