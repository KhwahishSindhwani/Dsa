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