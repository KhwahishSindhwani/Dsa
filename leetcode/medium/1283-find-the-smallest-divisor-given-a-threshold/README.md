# Find the Smallest Divisor Given a Threshold

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array of integers `nums` and an integer `threshold`, we will choose a positive integer `divisor`, divide all the array by it, and sum the division's result. Find the  **smallest**  `divisor` such that the result mentioned above is less than or equal to `threshold`.

Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: `7/3 = 3` and `10/2 = 5`).

The test cases are generated so that there will be an answer.

 

 **Example 1:** 

```
Input: nums = [1,2,5,9], threshold = 6
Output: 5
Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
If the divisor is 4 we can get a sum of 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2). 

```

 **Example 2:** 

```
Input: nums = [44,22,33,11,1], threshold = 5
Output: 44

```

 

 **Constraints:** 

- 1 <= nums.length <= 5 * 104
- 1 <= nums[i] <= 106
- nums.length <= threshold <= 106

## Solution

**Language:** Java  
**Runtime:** 0 ms  
**Memory:** 42.3 MB  
**Submitted:** 2026-07-06T08:16:04.387Z  

```java
class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for(int num : nums){
            start = Math.min(start, num);
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
        boolean is = false;
        for(int num : nums){
            //celling as there is approx equal to oe greater then
            sumResult = sumResult + (num + divisor -1)/divisor;

            if (sumResult > threshold){
                is = false;
            }
            else {
                is = true;
            }
        }
       return is; 
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/)