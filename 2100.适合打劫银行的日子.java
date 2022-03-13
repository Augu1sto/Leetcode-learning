package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

class goodDaysToRobBank {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> res = new ArrayList<>();
        // time=0
        if (time == 0) {
            for(int i= 0;i<security.length;i++){
                res.add(i);
            }
            return res;
        }
        // 天数不足
        if(security.length<(time*2+1)){
            return res;
        }
        int i = 1; // 遍历数组

        int beforeDays = 0;
        int afterDays = 0;
        while(i+time<security.length){

            if (security[i-1]>=security[i]) { // 非递增
                beforeDays ++;
            } else {
                beforeDays = 0;
            }
            if (security[i+time-1] <= security[i+time]) {
                afterDays ++;
            } else {
                afterDays = 0;
            }
            if (beforeDays>=time && afterDays >= time) {
                res.add(i);
            }
            i++;

        }
        return res;
    }
}
