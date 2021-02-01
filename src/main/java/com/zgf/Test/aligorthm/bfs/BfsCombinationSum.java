package com.zgf.Test.aligorthm.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/combination-sum/
 * <p>
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的数字可以无限制重复被选取。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 */
public class BfsCombinationSum {
    public static void main(String[] args) {
        BfsCombinationSum bfsCombinationSum = new BfsCombinationSum();
        System.out.println(bfsCombinationSum.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
                allResult.add(new ArrayList<>(result));
                result.remove(result.size() - 1);
                return;
            }

            result.add(candidates[i]);
            // 可重复选择
            doCombinationSum(candidates, target, i, tempSum, result, allResult);
            result.remove(result.size() - 1);
        }
    }
}
