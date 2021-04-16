package com.zgf.Test.aligorthm.normal;

/**
 * @author zgf
 * @date 2021-04-12 下午1:39
 */
public class FindNthDigit {
    public static void main(String[] args) {
        FindNthDigit findNthDigit = new FindNthDigit();
        System.out.println(findNthDigit.findNthDigit(1000000000));
    }

    private int findNthDigit(int i) {
        if (i <= 10) {
            return "0123456789".charAt(i) - 48;
        }

        // 定位范围区间
        int m = 10;
        int charIdxStart = 10;
        int charIdxMax = 10;
        String ms = null;
        while (true) {
            ms = String.valueOf(m);
            charIdxStart = charIdxMax;
            charIdxMax = charIdxStart + ms.length() * (m * 10 - 1);
            if (charIdxMax >= i) {
                break;
            }
            m = m * 10;
        }

        int mMin = m / 10;
        int start = mMin;
        int end = m;
        int charIdx;
        int mid;
        while (true) {
            mid = start + (end - start) / 2;
            charIdx = charIdxStart + ms.length() * (mid - mMin);
            if (charIdx < i) {
                start = mid + 1;
            } else if (charIdx - ms.length() > i) {
                end = mid - 1;
            } else {
                break;
            }
        }
//        System.out.println(mid);
        String midStr = String.valueOf(mid);
        return midStr.charAt((midStr.length() - 1) - (charIdx - i)) - 48;
    }

    /**
     * 速度太慢，超时了
     *
     * @param n
     * @return
     */
    public int findNthDigit_low(int n) {
        int i = 0;
        int charIdx = -1;
        while (true) {
            if (i < 10) {
                charIdx++;
                if (charIdx == n) {
                    return i;
                }
            } else {
                String s = String.valueOf(i);
                for (int j = 0; j < s.length(); j++) {
                    charIdx++;
                    if (charIdx == n) {
                        return s.charAt(j) - 48;
                    }
                }
            }
            i++;
        }
    }
}
