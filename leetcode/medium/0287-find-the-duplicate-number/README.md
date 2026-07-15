# Find the Duplicate Number

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array of integers `nums` containing `n + 1` integers where each integer is in the range `[1, n]` inclusive.

There is only  **one repeated number**  in `nums`, return  *this repeated number*.

You must solve the problem  **without**  modifying the array `nums` and using only constant extra space.

 

 **Example 1:** 

```
Input: nums = [1,3,4,2,2]
Output: 2

```

 **Example 2:** 

```
Input: nums = [3,1,3,4,2]
Output: 3

```

 **Example 3:** 

```
Input: nums = [3,3,3,3,3]
Output: 3
```

 

 **Constraints:** 

- 1 <= n <= 105
- nums.length == n + 1
- 1 <= nums[i] <= n
- All the integers in nums appear only once except for precisely one integer which appears two or more times.

 

 **Follow up:** 

- How can we prove that at least one duplicate number must exist in nums?
- Can you solve the problem in linear runtime complexity?

## Solution

**Language:** Java  
**Runtime:** 0 ms  
**Memory:** 42.2 MB  
**Submitted:** 2026-07-15T19:46:03.353Z  

```java
class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length){
            if (nums[i] != i){
            int correct = nums[i] -1;
            if (nums[i] != nums[correct]){
                swap(nums, correct, i);
            }
            else {
                return nums[i];
            }
            }else {
                i++;
            }
        }
        
        return -1;
    }
/*class Solution {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length){
            int correct = nums[i] -1;
            if (nums[i] != nums[correct]){
                swap(nums, correct, i);
            }
            else {
                i++;
            }
        }
        for (int index = 0; index<nums.length; index++){
            if (nums[index] != index +1){
                return nums[index];
            }
        }
        return -1;
    }*/
    void swap (int [] nums, int first , int second ){
        int temp = nums[first];
    nums[first] = nums[second];
    nums[second] = temp;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/find-the-duplicate-number/)