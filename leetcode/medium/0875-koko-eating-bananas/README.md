# Koko Eating Bananas

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Koko loves to eat bananas. There are `n` piles of bananas, the `ith` pile has `piles[i]` bananas. The guards have gone and will come back in `h` hours.

Koko can decide her bananas-per-hour eating speed of `k`. Each hour, she chooses some pile of bananas and eats `k` bananas from that pile. If the pile has less than `k` bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return  *the minimum integer*  `k`  *such that she can eat all the bananas within*  `h`  *hours*.

 

 **Example 1:** 

```
Input: piles = [3,6,7,11], h = 8
Output: 4

```

 **Example 2:** 

```
Input: piles = [30,11,23,4,20], h = 5
Output: 30

```

 **Example 3:** 

```
Input: piles = [30,11,23,4,20], h = 6
Output: 23

```

 

 **Constraints:** 

- 1 <= piles.length <= 104
- piles.length <= h <= 109
- 1 <= piles[i] <= 109

## Solution

**Language:** Java  
**Runtime:** 0 ms  
**Memory:** 42.2 MB  
**Submitted:** 2026-07-06T01:15:07.523Z  

```java
class Solution {
    public static int maxIN(int [] piles){
        int max= Integer.MIN_VALUE;
        for(int pile : piles){
            max = Math.max(pile, max);
        }
        return max;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = maxIN(piles);
        int ans = 0;


        while (start <= end){
            int mid = start + ( end - start ) / 2;

            if (canEat(piles, h, mid)){
                ans = mid;
                end = mid-1;
            } 
            else{
                start = mid + 1;
            }
        }
        return ans;
        
    }
    public static boolean canEat(int [] piles, int h, int speed){

        int hour = 0;

        for (int pile : piles){
            
            // celing of no :
            hour = hour + (pile + speed - 1 ) / speed;
            if (hour < h){
                return true;
            }
        }
        return false;
    }
}
```

---

[View on LeetCode](https://leetcode.com/problems/koko-eating-bananas/)