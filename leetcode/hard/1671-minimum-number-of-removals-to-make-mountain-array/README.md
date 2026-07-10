# Minimum Number of Removals to Make Mountain Array

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

You may recall that an array `arr` is a  **mountain array**  if and only if:

- arr.length >= 3
- There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that: arr[0] < arr[1] <... < arr[i - 1] < arr[i] arr[i] > arr[i + 1] >... > arr[arr.length - 1]

Given an integer array `nums`​​​, return  *the  **minimum**  number of elements to remove to make* `nums​​​`  *a  **mountain array**.* 

 

 **Example 1:** 

```
Input: nums = [1,3,1]
Output: 0
Explanation: The array itself is a mountain array so we do not need to remove any elements.

```

 **Example 2:** 

```
Input: nums = [2,1,1,5,6,2,3,1]
Output: 3
Explanation: One solution is to remove the elements at indices 0, 1, and 5, making the array nums = [1,5,6,3,1].

```

 

 **Constraints:** 

- 3 <= nums.length <= 1000
- 1 <= nums[i] <= 109
- It is guaranteed that you can make a mountain array out of nums.

## Solution

**Language:** Java  
**Runtime:** 9 ms (beats 96.34%)  
**Memory:** 46.4 MB (beats 42.80%)  
**Submitted:** 2026-07-10T18:05:28.367Z  

```java
class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;

        int[] lis = getLIS(nums);
        int[] lds = getLDS(nums);

        int maxMountain = 0;

        for (int i = 1; i < n - 1; i++) {
            if (lis[i] > 1 && lds[i] > 1) {
                maxMountain = Math.max(maxMountain, lis[i] + lds[i] - 1);
            }
        }

        return n - maxMountain;
    }

    private int[] getLIS(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        int[] tail = new int[n];
        int len = 0;

        for (int i = 0; i < n; i++) {
            int pos = lowerBound(tail, 0, len, nums[i]);
            tail[pos] = nums[i];

            if (pos == len) len++;

            lis[i] = pos + 1;
        }

        return lis;
    }

    private int[] getLDS(int[] nums) {
        int n = nums.length;
        int[] lds = new int[n];
        int[] tail = new int[n];
        int len = 0;

        for (int i = n - 1; i >= 0; i--) {
            int pos = lowerBound(tail, 0, len, nums[i]);
            tail[pos] = nums[i];

            if (pos == len) len++;

            lds[i] = pos + 1;
        }

        return lds;
    }

    private int lowerBound(int[] arr, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/)