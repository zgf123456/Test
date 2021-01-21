package com.zgf.Test.aligorthm.backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 回溯算法 - 全排列
 */
public class BtPermute {
    public static void main(String[] args) {
        BtPermute btPermute = new BtPermute();
        String[] chars = new String[]{"a", "b", "c", "d", "e"};
        List<List<String>> permute = btPermute.permute(chars);
        System.out.println(permute.size() + "," + permute);
    }

    private List<List<String>> permute(String[] chars) {
        if (chars == null || chars.length == 0) return Collections.emptyList();
        List<List<String>> trackList = new ArrayList<>();
        ArrayList<String> track = new ArrayList<>();
        doPermute(chars, track, trackList);
        return trackList;
    }

    private void doPermute(String[] chars, ArrayList<String> track, List<List<String>> trackList) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i].equals("-1")) continue;
            String stmp = chars[i];
            track.add(stmp); // 构建链条
            if (track.size() == chars.length) {
                trackList.add((ArrayList<String>) track.clone());
            }
            chars[i] = "-1";
            doPermute(chars, track, trackList);
            chars[i] = stmp;
            track.remove(track.size() - 1);
        }
    }
}