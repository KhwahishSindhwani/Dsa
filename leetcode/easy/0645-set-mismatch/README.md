# Set Mismatch

![Difficulty](https://img.shields.io/badge/Difficulty-Easy-green)

## Problem

You have a set of integers `s`, which originally contains all the numbers from `1` to `n`. Unfortunately, due to some error, one of the numbers in `s` got duplicated to another number in the set, which results in  **repetition of one**  number and  **loss of another**  number.

You are given an integer array `nums` representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return  *them in the form of an array*.

 

 **Example 1:** 

```
Input: nums = [1,2,2,4]
Output: [2,3]

```

 **Example 2:** 

```
Input: nums = [1,1]
Output: [1,2]

```

 

 **Constraints:** 

- 2 <= nums.length <= 104
- 1 <= nums[i] <= 104

## Solution

**Language:** Java  
**Runtime:** 0 ms  
**Memory:** 42.6 MB  
**Submitted:** 2026-07-15T20:05:02.490Z  

```java
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
        int [] ans = new int [2];
        for (int index = 0; index<nums.length; index++){
            if (nums[index] != index +1){
                ans[0] = nums[index];
                ans[1] = index;
            }
        }
        return ans;
    }
     void swap (int [] nums, int first , int second ){
        int temp = nums[first];
    nums[first] = nums[second];
    nums[second] = temp;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/set-mismatch/)