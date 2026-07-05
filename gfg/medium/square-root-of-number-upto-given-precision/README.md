# Square root of number upto given precision

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given a positive number  **n**  and an integer  **p**  representing the desired precision, your task is to find the  **square root**  of  **n**, accurate to  **p decimal places**. The solution should avoid using built-in square root functions.

 **Note:**  Precision control is required to ensure the output is correctly rounded or truncated at p digits after the decimal.

 **Examples:** 

```
Input: n = 50, p = 3
Output: 7.071
Explanation: The square root of 50 up to 3 decimal places is 7.071
```

```
Input: n = 10, p = 4
Output: 3.1622
Explanation: The square root of 10 up to 4 decimal places is 3.1622
```

**Constraints:
**1 ≤ n ≤ 104
1 ≤ p ≤ 6

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-05T08:18:24.177Z  

```java
class Solution {
    public double squareRoot(int n, int p) {
        // code here
        
        int start = 0, end = n, mid;
        double ans = 0.0;

        // Binary search for integral part
        while (start <= end) {
            mid = (start + end) / 2;
            if (mid * mid == n) {
                ans = mid;
                break;
            }
            if (mid * mid < n) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // Decimal precision refinement
        double increment = 0.1;
        for (int i = 0; i < p; i++) {
            while ((ans + increment) * (ans + increment) <= n) {
                ans += increment;
            }
            increment /= 10;
        }

        return ans;
    

    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/square-root-of-number-upto-given-precision/1)