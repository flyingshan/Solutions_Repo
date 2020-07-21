// 暴力解法

class Solution {
    // coding style should be uniform.
    public int maxArea(int[] height) {
        int max_area = 0;
        for(int i = 0; i < height.length-1; i++) {
            for (int j = i+1; j < height.length; j++) {
                int cur_area = 0;
                if (height[i] < height[j]) cur_area = (j-i) * height[i];
                else cur_area = (j-i) * height[j];
                if (cur_area > max_area) max_area = cur_area;
            }
        }
        return max_area;
    }
}

// 双指针算法，一开始自己也往这方面在想，但是没想清楚双指针从哪里开始，以及为什么双指针移动能够保证答案的正确性。
// 双指针这道题里从两边往中间按照谁小移谁的策略移动。每次能够保证解空间在缩小（正确性），以及非常高效。
class Solution {
    // coding style should be uniform.
    public int maxArea(int[] height) {
        int p = 0;
        int q = height.length-1;
        int max_area = 0;
        int cur_area = 0;
        while(p < q) {
            if (height[p] < height[q]) {
                cur_area = (q-p) * height[p];
                p++;
            }
            else {
                cur_area = (q-p) * height[q];
                q--;
            }
            if (cur_area > max_area) max_area = cur_area;
        }
        return max_area;
    }
}