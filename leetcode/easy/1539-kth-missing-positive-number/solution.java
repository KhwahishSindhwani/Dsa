class Solution {
    public int findKthPositive(int[] arr, int k) {
      
      for (int no : arr){
        if(no <= k){
            k++;
        }else{
        break;
      }
      } 
      return k;
    }
    
}