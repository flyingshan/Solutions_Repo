// 暴力解法 n2
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] rst = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                // int delta = target - cur;
                if ((target - nums[i]) == nums[j]) {
                    rst[0] = i;
                    rst[1] = j;
                } 
            }
        }
        return rst;
    }
}

// 改善时间复杂度nlgn
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] delta = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if (i == 0) {
                delta[i] = target - nums[i];
                continue;
            }
            else {
                for(int j = 0; j < i; j++){
                    if (delta[j] == nums[i]) {return new int[]{j,i};}
                }
            delta[i] = target - nums[i];
            }

                } 
            throw new IllegalArgumentException("No two sum solution");
            }
        
        }