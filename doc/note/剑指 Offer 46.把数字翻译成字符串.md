dp[i]表示前n个数有多少种翻译方法

dp[i] = dp[i-1] + k

k=

- num[i-1]!=0&&num[i-1]*10+num[i]<=25 →  1
- else  0

---

以上错误思路

![Picture1.png](https://gitee.com/Augu1sto/imageHost/raw/master/BlogImg/202203091749265.png)

