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