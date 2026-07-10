# Find in Mountain Array

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

*(This problem is an  **interactive problem**.)* 

You may recall that an array `arr` is a  **mountain array**  if and only if:

- arr.length >= 3
- There exists some i with 0 < i < arr.length - 1 such that: arr[0] < arr[1] <... < arr[i - 1] < arr[i] arr[i] > arr[i + 1] >... > arr[arr.length - 1]

Given a mountain array `mountainArr`, return the  **minimum**  `index` such that `mountainArr.get(index) == target`. If such an `index` does not exist, return `-1`.

 **You cannot access the mountain array directly.**  You may only access the array using a `MountainArray` interface:

- MountainArray.get(k) returns the element of the array at index k (0-indexed).
- MountainArray.length() returns the length of the array.

Submissions making more than `100` calls to `MountainArray.get` will be judged  *Wrong Answer*. Also, any solutions that attempt to circumvent the judge will result in disqualification.

 

 **Example 1:** 

```
Input: mountainArr = [1,2,3,4,5,3,1], target = 3
Output: 2
Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
```

 **Example 2:** 

```
Input: mountainArr = [0,1,2,4,2,1], target = 3
Output: -1
Explanation: 3 does not exist in the array, so we return -1.

```

 

 **Constraints:** 

- 3 <= mountainArr.length() <= 104
- 0 <= target <= 109
- 0 <= mountainArr.get(index) <= 109

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 46.5 MB (beats 61.16%)  
**Submitted:** 2026-07-10T17:43:51.415Z  

```java
/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {

    public int findInMountainArray(int target, MountainArray mountainArr) {

        int peak = peakIndex(mountainArr);

        int firstTry = orderAgnosticBS(mountainArr, target, 0, peak);

        if (firstTry != -1) {
            return firstTry;
        }

        return orderAgnosticBS(
                mountainArr,
                target,
                peak + 1,
                mountainArr.length() - 1
        );
    }

    private int peakIndex(MountainArray arr) {

        int start = 0;
        int end = arr.length() - 1;

        while (start < end) {

            int mid = start + (end - start) / 2;

            if (arr.get(mid) > arr.get(mid + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    private int orderAgnosticBS(MountainArray arr, int target, int start, int end) {

        boolean isAsc = arr.get(start) < arr.get(end);

        while (start <= end) {

            int mid = start + (end - start) / 2;
            int value = arr.get(mid);

            if (value == target) {
                return mid;
            }

            if (isAsc) {

                if (target < value) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            } else {

                if (target > value) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            }
        }

        return -1;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/find-in-mountain-array/)