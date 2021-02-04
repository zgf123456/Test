package com.zgf.Test.aligorthm.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations-ii/
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * 回溯算法 - 全排列 - 字符串
 */
public class BtPermute3 {
    public static void main(String[] args) {
        BtPermute3 btPermute = new BtPermute3();
        int[] nums = new int[]{1, 1, 2, 2};
        List<List<Integer>> permutes = btPermute.permuteUnique(nums);
        System.out.println(permutes.size() + "," + permutes);
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();
        Arrays.sort(nums);
        int ex = nums[0] - 1;
        List<List<Integer>> trackList = new ArrayList<>();
        ArrayList<Integer> track = new ArrayList<>();
        doPermute(nums, track, ex, trackList);
        return trackList;
    }

    private void doPermute(int[] nums, ArrayList<Integer> track, int ex, List<List<Integer>> trackList) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ex) continue;
            int stmp = nums[i];
            track.add(stmp); // 构建链条
            if (track.size() == nums.length) {
                ArrayList<Integer> temp = (ArrayList<Integer>) track.clone();
                if(!trackList.contains(temp)) {
                    trackList.add(temp);
                }
            }
            nums[i] = ex;
            doPermute(nums, track, ex, trackList);
            nums[i] = stmp;
            track.remove(track.size() - 1);
        }
    }
}