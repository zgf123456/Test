package com.zgf.Test.aligorthm.backtrack;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法 - 八皇后问题 - 92种解法
 */
public class BtEightQueen {
    public static void main(String[] args) {
        BtEightQueen btEightQueen = new BtEightQueen();
        int[][] map = new int[8][8];
        ArrayList<List<int[]>> result = new ArrayList<List<int[]>>();
        List<int[]> path = new ArrayList<>();
        btEightQueen.find(map, 1, path, result);

        System.out.println(result.size());
        System.out.println(JSON.toJSONString(result));
    }

    /**
     * @param map    地图
     * @param depth  层次,从1开始
     * @param path   路径
     * @param result
     */
    private void find(int[][] map, int depth, List<int[]> path, ArrayList<List<int[]>> result) {
        if (path.size() == map.length) {
            List<int[]> newPath = new ArrayList<>();
            newPath.addAll(path);
            result.add(newPath);
            return;
        }

        int[] mapY = map[depth - 1];
        for (int j = 0; j < mapY.length; j++) {
            if (mapY[j] == -1) continue;
            if (isValid(map, depth - 1, j)) {
                mapY[j] = -1;
                path.add(new int[]{depth - 1, j});
                // 递归
                find(map, depth + 1, path, result);

//                // 只寻找一种解法时
//                if(result.size() >0 ) {
//                    break;
//                }

                path.remove(path.size() - 1);
                mapY[j] = 0;
            } else {
                continue;
            }
        }
    }

    // 判断位置是否合法
    private boolean isValid(int[][] map, int i, int j) {
        // 上下
        for (int k = 0; k < map.length; k++) {
            if (k != i && map[k][j] == -1) {
                return false;
            }
        }
        // 左右
        for (int k = 0; k < map.length; k++) {
            if (k != j && map[i][k] == -1) {
                return false;
            }
        }

        // 斜线
        int k = i - 1, m = j - 1;
        for (; k >= 0 && m >= 0; k--, m--) {
            if (map[k][m] == -1) {
                return false;
            }
        }

        k = i + 1;
        m = j + 1;
        for (; k < map.length && m < map.length; k++, m++) {
            if (map[k][m] == -1) {
                return false;
            }
        }

        k = i + 1;
        m = j - 1;
        for (; k < map.length && m >= 0; k++, m--) {
            if (map[k][m] == -1) {
                return false;
            }
        }

        k = i - 1;
        m = j + 1;
        for (; k >= 0 && m < map.length; k--, m++) {
            if (map[k][m] == -1) {
                return false;
            }
        }
        return true;
    }
}
