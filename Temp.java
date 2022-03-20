package leetcode.editor.cn;

import java.util.*;

public class Temp {


    public static void main(String[] args) {

    }

    static Map<Long, Integer> map = new HashMap<>();
    // 用栈存储时间戳，获取以前时间的时候再弹出来
    static Deque<Long> allTime = new LinkedList<>();
    // 当前cpu使用率

    public static int getCurrent (){
        Random r = new Random();
        int cpu = r.nextInt(100);
        Date nowDate = new Date();
        long timestamp = nowDate.getTime();
        map.put(timestamp, cpu);
        allTime.push(timestamp);
        return cpu;
    }

    // 过去一段时间的使用率
    public static int getIntervalAverage(long ms){
        // 获取当前时间
        Date nowDate = new Date();
        long current_time = nowDate.getTime();
        long old_time = current_time-ms; // 毫秒，根据间隔计算以前的时间
        // 暂存弹出来的时间
        Deque<Long> stack = new LinkedList<>();
        int sum = 0;
        int n = 0;
        while (!allTime.isEmpty()&&allTime.peek()!=old_time){
            long timestamp = allTime.pop();
            int i = map.get(timestamp);
            sum += i;
            n ++;
            stack.push(timestamp);
        }

        sum+=map.get(old_time);
        n++;
        while (!stack.isEmpty()){
            long timestamp = stack.pop();
            allTime.push(timestamp);
        }
        return sum/n;
    }
}
