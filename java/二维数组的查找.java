// 找到减小解空间的高效方法，这里需要考虑二维数组的边界情况（a=[], a=[[]], a=null）
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || (matrix.length==1 && matrix[0].length==0)){
            return false;
        }
        int h = matrix.length;
        int w = matrix[0].length;
        
        int i = w-1;
        int j = 0;
        while (i >= 0 && j <h) {
            if (target < matrix[j][i]) i--;
            else if (target > matrix[j][i]) j++;
            else return true;
        }
        return false;

    }
}