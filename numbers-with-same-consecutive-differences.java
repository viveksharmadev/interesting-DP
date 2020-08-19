// https://leetcode.com/problems/numbers-with-same-consecutive-differences/
class Solution {
    //tc - N*2^N sc - 2^N
    public int[] numsSameConsecDiff(int N, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i=1; i<=9; i++){
            set.add(i);
        }
        
        for(int j=1; j<=N-1; j++){
            Set<Integer> curr = new HashSet<>();
            for(int num : set){
                int d = num%10;
                if(d-k>=0) curr.add(num*10 + d-k);
                if(d+k<=9) curr.add(num*10 + d+k);
            }
            set = curr;
        }
        
        if(N==1) set.add(0);
        
        int[] ans = new int[set.size()];
        int m = 0;
        for(int s : set){
            ans[m++] = s;
        }
        return ans;
    }
}
