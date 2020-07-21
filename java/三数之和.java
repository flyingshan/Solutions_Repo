// 七拼八凑算法，结果应该是对的，但是超时（不可行）

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        for (int i = 0; i < nums.length-2; i++) {
            for(int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i]+nums[j]+nums[k]==0) {
                        result.add(0, Arrays.asList(nums[i],nums[j],nums[k]));
                    }
                }
            }
        }
        int[] h = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            List<Integer> t = result.get(i);
            Collections.sort(t);
            h[i] = t.hashCode();
            // System.out.println(h[i]);
        }
        int s = result.size();
        int[] f = new int[s];
        for (int i = 0; i < s; i++) {
            f[i] = 0;
        }
        for (int m = s-1; m > 0; m--) {
            for (int n = m-1; n >= 0; n--) {
                // System.out.println(n);
                if (h[n] == h[m]) {
                    f[m] = 1;
                }
            }
        }

        List<List<Integer>> real_result = new ArrayList();
        for (int i = 0; i < result.size(); i++) {
            if (f[i] == 0) {
                real_result.add(result.get(i));
            }
        }

        return real_result;

    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
// 排序LR算法 （多指针策略）
// [为了避免重复，采用的策略]
// 1. 对nums进行排序；
// 2. 选择nums[i]，在其右侧选择L和R两个指针；
// 3. 判断nums[i] + nums[L] + nums[R] == 0 是否成立；
// 4. 若不成立，结果小于0向右移动L，大于0向左移动R，当nums[L+1]==nums[L],则继续移动；若成立，则添加到结果中，同时向左向右移动RL；
// 5. 当L<R不成立的时候，移动i，当nums[i+1] == nums[i]，则继续移动i直到不相等。
// 6. nums[i] > 0, 或者 i > nums.length - 3时，返回结果
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int L = i+1;
            int R = nums.length - 1;
            while(L < R) {
                if (nums[i]+nums[L]+nums[R]==0) {
                    result.add(0, Arrays.asList(nums[i],nums[L],nums[R]));
                    while(nums[L+1] == nums[L]) {
                        if (L+1 >= nums.length-1) {break;}
                        L++;
                    }
                    while(nums[R-1] == nums[R]) {
                        if (R -1 <= 0) {break;}
                        R--;
                        }
                    L++;
                    R--;
                    }
                else if (nums[i]+nums[L]+nums[R] > 0) {
                    while(nums[R-1] == nums[R]) {
                        if (R -1 <= 0) {break;}
                        R--;
                        }
                    R--;
                }
                else {
                    while(nums[L+1] == nums[L]) {
                        if (L+1 >= nums.length-1) {break;}
                        L++;
                    }
                    L++;
                }
            }


            while (nums[i+1] == nums[i]) {
                if (i+1 >= nums.length-1) {break;}
                i++;
            }
            if (nums[i] > 0) {return result;}
        }
        return result;
    }
}

// 总结：排序对唯一性有作用；边界情况有助于改善算法性能；while语句的应用