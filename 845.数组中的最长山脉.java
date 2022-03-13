package leetcode.editor.cn;

class Solution {
    public int longestMountain(int[] arr) {
        int res = 0; // 不存在则返回0
        int n = arr.length;
        int left = 0;
        while(left+2<n){
            if (arr[left] < arr[left+1]) { // 左山脚
                int right = left+1; // 右山脚起始
                while (right < n-1 && arr[right] < arr[right+1]) { // 上山
                    right++;
                }
                if (right < n-1 && arr[right] > arr[right+1] ) { // 到达山顶
                    while (right < n-1 && arr[right] > arr[right+1] ) { // 下山
                        right++;
                    }
                    res = Math.max(res,right-left+1);
                }
                left = right;

            }else{
                left++;
            }
        }

        return res;
    }
}