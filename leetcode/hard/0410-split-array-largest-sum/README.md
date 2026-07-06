# Split Array Largest Sum

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

Given an integer array `nums` and an integer `k`, split `nums` into `k` non-empty subarrays such that the largest sum of any subarray is  **minimized**.

Return  *the minimized largest sum of the split*.

A  **subarray**  is a contiguous part of the array.

 

 **Example 1:** 

```
Input: nums = [7,2,5,10,8], k = 2
Output: 18
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8], where the largest sum among the two subarrays is only 18.

```

 **Example 2:** 

```
Input: nums = [1,2,3,4,5], k = 2
Output: 9
Explanation: There are four ways to split nums into two subarrays.
The best way is to split it into [1,2,3] and [4,5], where the largest sum among the two subarrays is only 9.

```

 

 **Constraints:** 

- 1 <= nums.length <= 1000
- 0 <= nums[i] <= 106
- 1 <= k <= min(50, nums.length)

## Solution

**Language:** Java  
**Runtime:** 0 ms  
**Memory:** 42.4 MB  
**Submitted:** 2026-07-06T22:26:44.705Z  

```java
class Solution {
    public int splitArray(int[] nums, int k) {

        int start = 0; 
        int end = 0;
        for(int i : nums){
            start = Math.max(start, i);
            end += i;
        }

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(isSub(nums, k, mid)){
                end = mid -1;
            } else{
                start = mid +1;
            }

        }
        return start;
    }

    public static boolean isSub(int [] nums, int k, int checkValue){
        int cA = 1; // cA: current array
        int value = 0;
        for (int num : nums){

            if ( ( value + num ) <= checkValue){
                value += num;
            }else{
                cA++;
                value = num;

                if (cA > k){
                    return false;
                }
            }
        }
        return true ;
    }

}



/*
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
*/
```

---

[View on LeetCode](https://leetcode.com/problems/split-array-largest-sum/)