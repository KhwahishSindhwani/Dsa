class Solution {
    public int minSwapsCouples(int[] row) {
        int i = 0;
        int count = 0 ;
        while (i < row.length){
            int correct = row[i];
            if (row[i] != row[correct]){
                swap(row, i, correct);
                count ++;
            }
            else {
                i++;
            }
        }
        return count;
    }
    void swap (int [] nums, int first , int second ){
        int temp = nums[first];
    nums[first] = nums[second];
    nums[second] = temp;
    }
}