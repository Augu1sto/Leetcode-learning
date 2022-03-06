参考 [2100. 适合打劫银行的日子](https://leetcode-cn.com/problems/find-good-days-to-rob-the-bank/) （？

枚举山脚

![img](https://gitee.com/Augu1sto/imageHost/raw/master/BlogImg/202203061643704.png)

left+2<n

- 左侧山脚 left，保证arr\[left]<arr\[left+1]

- 右侧山脚 right，起始=left+1
  - arr[right]<arr[right+1]：说明在上山，否则两种情况：
    - right = n-1 遍历结束（提前判断，不然越界
    - arr[right]>arr[right+1] 到达山顶，开始下山，循环，直到不满足条件，此时right是山脚
- 将right山脚赋给left山脚继续



