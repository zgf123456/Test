package com.zgf.Test.aligorthm.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum-ii/
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 */
public class BfsCombinationSum2 {
    public static void main(String[] args) {
        BfsCombinationSum2 bfsCombinationSum = new BfsCombinationSum2();
//        System.out.println(bfsCombinationSum.combinationSum2(new int[]{2, 3, 6, 7}, 7));
        System.out.println(bfsCombinationSum.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) return Collections.emptyList();
        // 先排序
        Arrays.sort(candidates);
        ArrayList<List<Integer>> allResult = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int sum = 0;
        doCombinationSum(candidates, target, 0, sum, result, allResult);
        return allResult;
    }

    /**
     * @param candidates
     * @param target
     * @param idx        数组下标
     * @param sum        当前和
     * @param result
     * @param allResult
     */
    private void doCombinationSum(int[] candidates, int target, int idx, int sum, List<Integer> result, ArrayList<List<Integer>> allResult) {
        if (idx >= candidates.length) {
            return;
        }

        for (int i = idx; i < candidates.length; i++) {
            int tempSum = sum + candidates[i];
            if (tempSum > target) {
                // 有序数组，停止查询
                return;
            }

            if (tempSum == target) {
                result.add(candidates[i]);
                ArrayList<Integer> temp = new ArrayList<>(result);
                if (!allResult.contains(temp)) {
                    allResult.add(temp);
                }
                result.remove(result.size() - 1);
                return;
            }

            result.add(candidates[i]);
            // 不可重复选择
            doCombinationSum(candidates, target, i + 1, tempSum, result, allResult);
            result.remove(result.size() - 1);
        }
    }
}
