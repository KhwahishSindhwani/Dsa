class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;

        int[] lis = getLIS(nums);
        int[] lds = getLDS(nums);

        int maxMountain = 0;

        for (int i = 1; i < n - 1; i++) {
            if (lis[i] > 1 && lds[i] > 1) {
                maxMountain = Math.max(maxMountain, lis[i] + lds[i] - 1);
            }
        }

        return n - maxMountain;
    }

    private int[] getLIS(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        int[] tail = new int[n];
        int len = 0;

        for (int i = 0; i < n; i++) {
            int pos = lowerBound(tail, 0, len, nums[i]);
            tail[pos] = nums[i];

            if (pos == len) len++;

            lis[i] = pos + 1;
        }

        return lis;
    }

    private int[] getLDS(int[] nums) {
        int n = nums.length;
        int[] lds = new int[n];
        int[] tail = new int[n];
        int len = 0;

        for (int i = n - 1; i >= 0; i--) {
            int pos = lowerBound(tail, 0, len, nums[i]);
            tail[pos] = nums[i];

            if (pos == len) len++;

            lds[i] = pos + 1;
        }

        return lds;
    }

    private int lowerBound(int[] arr, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] >= target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}