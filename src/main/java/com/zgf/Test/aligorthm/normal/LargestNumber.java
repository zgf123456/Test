package com.zgf.Test.aligorthm.normal;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 *
 * @author zgf
 * @date 2021-04-12 上午11:18
 */
public class LargestNumber {
    public static void main(String[] args) {
        LargestNumber largestNumber = new LargestNumber();
        System.out.println(largestNumber.largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(largestNumber.largestNumber(new int[]{34323, 3432}));
    }

    public String largestNumber(int[] nums) {
        StringBuffer collect = Arrays.stream(nums)
                .mapToObj(x -> String.valueOf(x))
                .sorted(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
//                        // 按位进行比较
//                        int i = 0, j = 0;
//                        while (i <= o1.length() && j <= o2.length()) {
//                            int v = o2.charAt(j) - o1.charAt(i);
//                            if (v == 0) {
//                                if (i + 1 == o1.length() && j + 1 == o2.length()) {
//                                    return v;
//                                }
//                                if (i + 1 < o1.length()) {
//                                    i++;
//                                }
//                                if (j + 1 < o2.length()) {
//                                    j++;
//                                }
//                            } else {
//                                return v;
//                            }
//                        }
                        return (o2 + o1).compareTo(o1 + o2); // 这个比较方式，能明确出大值
                    }
                })
//                .peek(x -> System.out.println(x))
                .collect(StringBuffer::new, (x, y) -> {
                    x.append(y);
                }, (x, y) -> {
                    x.append(y);
                });

        while(collect.length() > 1 && collect.charAt(0) == '0') {
            collect.deleteCharAt(0);
        }

        return collect.toString();
    }
}
