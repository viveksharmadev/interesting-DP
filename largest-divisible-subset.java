// https://leetcode.com/problems/largest-divisible-subset/
class largest-divisible-subset {
    // tc -> nlogn + n^2, sc-> n^2
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums.length==0) return new ArrayList<>();
        Arrays.sort(nums);
        ArrayList<Integer>[] cache = new ArrayList[nums.length];
        int maxIndex = 0;
        int maxSize = -1;
        int finalIndex = 0;
        int finalSize = -1;
        
        for(int i=0; i<nums.length; i++){
            cache[i] = new ArrayList<Integer>();
            for(int j=i-1; j>=0; j--){
                if(nums[i]%nums[j]==0){
                    if(maxSize < cache[j].size()){
                        maxSize = cache[j].size();
                        maxIndex = j;
                    }
                }
            }
            if(maxSize!=-1) cache[i].addAll(cache[maxIndex]); 
            cache[i].add(nums[i]);
            if(finalSize < cache[i].size()){
                finalSize = cache[i].size();
                finalIndex = i;
            }
            maxIndex = 0;
            maxSize = -1;            
        }
        return cache[finalIndex];
    }
}
