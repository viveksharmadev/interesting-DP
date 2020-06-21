// https://leetcode.com/problems/dungeon-game/
class dungeon-game {
    // tc -> m*n, sc-> m*n
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon==null || dungeon.length==0) return 0;
        
        int m = dungeon.length, n = dungeon[0].length;
        
        int[][] cache = new int[m][n];
        
        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                if(i==m-1 && j==n-1){
                    cache[m-1][n-1] = Math.max(1, 1-dungeon[m-1][n-1]);
                }else if(i==m-1){
                    cache[m-1][j] = Math.max(cache[m-1][j+1] - dungeon[m-1][j], 1);
                }else if(j==n-1){
                    cache[i][n-1] = Math.max(cache[i+1][n-1] - dungeon[i][n-1], 1);
                }else{
                    cache[i][j] = Math.min(Math.max(cache[i+1][j] - dungeon[i][j],1),
                                           Math.max(cache[i][j+1] - dungeon[i][j],1));
                }
            }
        }
        return cache[0][0];
    }
}
