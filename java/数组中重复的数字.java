// Hash表
// 时间O(N),空间O(N)
class Solution {
    public int findRepeatNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap();
        int result;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) return nums[i];
            else map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No repeatation!");
    }
}

//很聪明的方法，利用数字位于0~n-1的特性。
class Solution {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while(nums[i] != i){
                int j = nums[i];
                if (nums[j] == j) return j;
                else {
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
            }
        }
        // put before the bracket of the main method, if no return.
        throw new IllegalArgumentException("!No repeatation!"); 
    }
}