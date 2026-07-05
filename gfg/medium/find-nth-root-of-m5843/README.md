# Find nth root of m

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are given 2 numbers  **n and m,**  the task is to find  **n√m**  (nth root of m). If the root is not integer then return  **-1**.

 **Examples :** 

```
Input: n = 3, m = 8
Output: 2
Explanation: 23 = 8

```

```
Input: n = 3, m = 9
Output: -1
Explanation: 3rd root of 9 is not integer.
```

```
Input: n = 4, m = 16
Output: 2
Explanation: 24 = 16
```

 **Constraints:** 
1 ≤ n ≤ 9
0 ≤ m ≤ 20

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-05T12:58:00.687Z  

```java
class Solution {
    public int nthRoot(int n, int m) {
        // code here
         // Set low and high for binary search
        int low = 1, high = m;
        if (m == 0){
            return 0;
        }

        // Start binary search
        while (low <= high) {
            // Calculate mid
            int mid = (low + high) / 2;

            // Store result of mid^n
            long ans = 1;
            for (int i = 0; i < n; i++) {
                ans *= mid;
                if (ans > m) break;
            }

            // If mid^n equals m
            if (ans == m) return mid;

            // If mid^n is less than m
            if (ans < m) low = mid + 1;

            // If mid^n is more than m
            else high = mid - 1;
        }

        // Return -1 if not found
        return -1;
    }
}
/* brute force 
class Solution {
    // Function to find Nth root of M
    public int nthRoot(int n, int m) {
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/find-nth-root-of-m5843/1)