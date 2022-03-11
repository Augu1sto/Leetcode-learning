package leetcode.editor.cn;

import java.util.Scanner;

public class KaitenSushi {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t>0){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for(int i = 0; i<n; i++){
                nums[i] = scanner.nextInt();
            }
            System.out.println(getMaxSum(nums));

            t--;
        }
    }

    public static int getMaxSum(int[] nums){
        int maxi = 0;
        int mini = 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int sum = 0;
        for (int num:nums) {
            maxi = Math.max(num, maxi+num);
            maxSum = Math.max(maxi, maxSum);
            mini = Math.min(num, mini+num);
            minSum = Math.min(mini, minSum);
            sum+=num;
        }
        return Math.max(sum-minSum,maxSum);

    }
}