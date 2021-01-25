package com.zgf.Test.aligorthm.dp;

/**
 * 4键键盘
 * <p>
 * 4个键盘操作
 * A，选中，复制，粘帖，给定按键次数N，计算得到最多的字符数
 */
public class FourKey {
    public static void main(String[] args) {
        FourKey fourKey = new FourKey();
        System.out.println(fourKey.find(4));
        System.out.println(fourKey.find(7));
        System.out.println(fourKey.find(10));
        System.out.println(fourKey.find(20));
    }

    private int find(int n) {
        if (n <= 0) return 0;
        int curNum = 0; // 当前字符数
        int cacheNum = 0; // 缓存字符数
        int lessN = n; // 剩余按键数
        return dofind(curNum, cacheNum, lessN);
    }

    private int dofind(int curNum, int cacheNum, int lessN) {
        if (lessN == 0) return curNum;
        // 状态转移
        // 如果curNum < 3, 则按键1
        // 否则
        // 如果lessN <= 2, 且cacheNum >=1 , 则按键4
        // 如果lessN <= 2, 且cacheNum <1, 则按键1
        // 如果lessN >=3, 且curNum - cacheNum >=3,按键2、键3、键4
        // 否则按键4
        if (curNum < 3) {
            // 按键1
            curNum = curNum + 1;
            lessN = lessN - 1;
            return dofind(curNum, cacheNum, lessN);
        } else {
            if (lessN <= 2) {
                if (cacheNum >= 1) {
                    // 按键4
                    curNum = curNum + cacheNum;
                    lessN = lessN - 1;
                    return dofind(curNum, cacheNum, lessN);
                } else {
                    // 按键1
                    curNum = curNum + 1;
                    lessN = lessN - 1;
                    return dofind(curNum, cacheNum, lessN);
                }
            } else {
                if (curNum - cacheNum >= 3) {
                    // 按键2、键3、键4
                    cacheNum = curNum;
                    curNum = curNum + cacheNum;
                    lessN = lessN - 3;
                    return dofind(curNum, cacheNum, lessN);
                } else {
                    // 按键4
                    curNum = curNum + cacheNum;
                    lessN = lessN - 1;
                    return dofind(curNum, cacheNum, lessN);
                }
            }
        }
    }
}
