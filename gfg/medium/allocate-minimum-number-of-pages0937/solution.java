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
                