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