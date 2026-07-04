# ROOTFINDER

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

### Find how many times the array have been rotated

You are given an array of integers $nums$ of size $n$, which was originally sorted in ascending order with  **unique elements**. The array has been  **rotated to the right**  by an unknown number of steps (ranging from 0 to n - 1).

Your task is to  **find how many times the array has been rotated**.

### Function Declaration
### Function Name

$countRotations$ – This function returns the number of times a sorted array has been rotated.

### Parameters
- $nums$ : A reference to a rotated sorted array of unique integers.
### Return Value
- Returns an integer representing the number of right rotations applied to the array.
## Constraints
- $1 \leq n \leq 10^4$
- $-10^4 \leq nums[i] \leq 10^4$
- All elements in $nums$ are unique
- $nums$ is a rotated version of a sorted array
### Input Format
- The first line contains an integer $T$ — number of test cases.
- For each test case: One line containing an integer $n$ — size of the array One line containing $n$ space-separated integers — the rotated sorted array
### Output Format
- For each test case, print a single integer — number of rotations
### Sample 1:
Input
Output

```
3
7
7 9 12 15 2 4 5
6
10 20 30 5 7 8
5
1 2 3 4 5

```

```
4
3
0
```

### Explanation:
- For the first test case the original sorted array is [2, 4, 5, 7, 9, 12, 15]. It has been rotated 4 times to the right.

## Solution

**Language:** C++  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-04T18:10:05.949Z  

```cpp
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

```

---

[View on CodeChef](https://www.codechef.com/problems/ROOTFINDER)