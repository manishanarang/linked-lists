class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int result = r;

        while(l<=r){
            int hours = 0;
            int k_mid = (l+r)/2;

            for(int i = 0; i<piles.length;i++){
                hours += Math.ceil((double)piles[i]/k_mid);
            }

            if(hours <= h){
                result = Math.min(result, k_mid);
                r = k_mid-1;
            }
            else{
                l = k_mid+1;
            }
        }
        return result;
    }
}