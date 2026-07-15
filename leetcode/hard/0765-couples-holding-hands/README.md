# Couples Holding Hands

![Difficulty](https://img.shields.io/badge/Difficulty-Hard-red)

## Problem

There are `n` couples sitting in `2n` seats arranged in a row and want to hold hands.

The people and seats are represented by an integer array `row` where `row[i]` is the ID of the person sitting in the `ith` seat. The couples are numbered in order, the first couple being `(0, 1)`, the second couple being `(2, 3)`, and so on with the last couple being `(2n - 2, 2n - 1)`.

Return  *the minimum number of swaps so that every couple is sitting side by side*. A swap consists of choosing any two people, then they stand up and switch seats.

 

 **Example 1:** 

```
Input: row = [0,2,1,3]
Output: 1
Explanation: We only need to swap the second (row[1]) and third (row[2]) person.

```

 **Example 2:** 

```
Input: row = [3,2,0,1]
Output: 0
Explanation: All couples are already seated side by side.

```

 

 **Constraints:** 

- 2n == row.length
- 2 <= n <= 30​​​​​​​
- 0 <= row[i] < 2n
- All the elements of row are unique.

## Solution

**Language:** Java  
**Runtime:** 0 ms (beats 100.00%)  
**Memory:** 42.7 MB (beats 76.05%)  
**Submitted:** 2026-07-15T20:41:26.173Z  

```java
class Solution {
    public int minSwapsCouples(int[] row) {

        int swaps = 0;

        for (int i = 0; i < row.length; i += 2) {

            // Find the expected partner
            int partner;
            if (row[i] % 2 == 0) {
                partner = row[i] + 1;
            } else {
                partner = row[i] - 1;
            }

            // Partner is already sitting next to them
            if (row[i + 1] == partner) {
                continue;
            }

            // Find the partner using linear search
            int j;
            for (j = i + 2; j < row.length; j++) {
                if (row[j] == partner) {
                    break;
                }
            }

            // Swap partner into the correct seat
            swap(row, i + 1, j);
            swaps++;
        }

        return swaps;
    }

    void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/couples-holding-hands/)