# Allocate Minimum Pages

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Given an array  **arr[]** of integers, where each element  **arr[i]**  represents the number of pages in the i-th book. You also have an integer  **k**  representing the number of students. The task is to allocate books to each student such that:

- Each student receives atleast one book.
- Each student is assigned a contiguous sequence of books.
- No book is assigned to more than one student.
- All books must be allocated.

The objective is to  **minimize the maximum number of pages** assigned to any student. In other words, out of all possible allocations, find the arrangement where the student who receives the most pages still has the  **smallest possible maximum**. If it is not possible to allocate books to all students, return  **-1** ;

 **Note:** Test cases are generated such that the answer always fits in a 32-bit integer.

 **Examples:** 

```
Input: arr[] = [12, 34, 67, 90], k = 2
Output: 113
Explanation: Allocation can be done in following ways:
=> [12] and [34, 67, 90] Maximum Pages = 191
=> [12, 34] and [67, 90] Maximum Pages = 157
=> [12, 34, 67] and [90] Maximum Pages = 113.
The third combination has the minimum pages assigned to a student which is 113.
```

```
Input: arr[] = [15, 17, 20], k = 5
Output: -1
Explanation: Since there are more students than total books, it's impossible to allocate a book to each student.
```

 **Constraints:** 
1 ≤ arr.size() ≤ 106
1 ≤ arr[i], k ≤ 104

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-06T22:06:12.641Z  

```java
class Solution {
    public int findPages(int[] arr, int k) {
        // code here
        if(k > arr.length){
            return -1;
        }
        long start =0;
        long end = 0;
        
        for(int i : arr){
            start = Math.max(start, i);
            end = end + i;
        }
        
         while(start <= end){
             long mid = start + ( end - start ) / 2;
             if(isGiven(arr, k, mid)){
                 end = mid - 1;
             }else{
                 start = mid+1;
             }
         }
        return (int)start;
    }
    
    public static boolean isGiven(int [] arr, int k, long pages){
        // k : is no of student book will be distributed 
        
        int cS = 1; // cs : Count student 
        long gP = 0; // gp : Given Pages
        
        for(int page : arr ){
            if ( ( gP + page )   <= pages){
                gP = gP + page;
            }
            else{
                cS++;
                gP = page;
                
```

---

[View on GeeksforGeeks](https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1)