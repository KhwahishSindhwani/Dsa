# Aggressive Cows

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an integer array  **arr[]**, which denotes the positions of stalls. All the positions are distinct. There are **k**  aggressive cows.

Assign the cows to the stalls such that the **minimum**  distance between any two cows is  **maximized.** 

 **Examples:** 

```
Input: arr[] = [1, 2, 4, 8, 9], k = 3
Output: 3
Explanation: The first cow can be placed at arr[0], the second at arr[2], and the third at arr[3]. The minimum distance between any two cows is 3 (between arr[0] and arr[2]), which is the maximum possible among all valid arrangements.
```

```
Input: arr[] = [10, 1, 2, 7, 5], k = 3
Output: 4
Explanation: The first cow can be placed at arr[0], the second at arr[1], and the third at arr[4]. In this arrangement, the minimum distance between any two cows is 4 (between arr[1] and arr[4]), which is the maximum possible among all valid arrangements.
```

 **Constraints:** 
2 ≤ arr.size() ≤ 106
0 ≤ arr[i] ≤ 108
2 ≤ k ≤ arr.size()

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-06T20:52:59.579Z  

```java
class Solution {
    public int aggressiveCows(int[] arr, int k) {
       Arrays.sort(arr);
       
       int start = 1;
       int end = arr[arr.length-1] - arr[0];
       
       while(start <= end){
           int mid = start + (end - start) / 2;
           // this mid is give distance to check between cow 
           if(canPlace(arr, k, mid)){
               start = mid +1;
           }
           else {
               end = mid -1;
           }
       }
       return end;
        
    }
    public static boolean canPlace(int [] arr, int k , int distance){
        int cPC = 1; // Current Placed Cow
        
        int pAt = arr[0]; // pAt : Position at 
        // k : Total cow to br placed
        for (int p : arr){ // p: position
            if (p - pAt >= distance){
                cPC++;
                pAt = p;
                
                if( cPC == k){
                    return true;
                }
            }
        }
        return false;
    }
}
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/aggressive-cows/1)