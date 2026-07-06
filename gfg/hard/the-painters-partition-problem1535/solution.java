        for(int i : arr){
            start = Math.max(start, i);
            end += i;
        }

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(isPaint(arr, k, mid)){
                end = mid -1;
            } else{
                start = mid +1;
            }

        }
        return start;
    }
    
    public static boolean isPaint(int [] arr, int k, int checkValue){
        int painter = 1; // cA: current array
        int value = 0;
        for (int part : arr){

            if ( ( value + part ) <= checkValue){
                value += part;
            }else{
                painter++;
                value = part;

                if (painter > k){
                    return false;
                }
            }
        }
        return true ;
    }
}
