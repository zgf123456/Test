package com.zgf.Test.aligorthm.bfs;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/path-with-minimum-effort/
 * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 * <p>
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 * <p>
 * 请你返回从左上角走到右下角的最小 体力消耗值 。
 */
public class BfsMinimumEffortPath {
    public static void main(String[] args) {
        BfsMinimumEffortPath bfsMinimumEffortPath = new BfsMinimumEffortPath();
        System.out.println(bfsMinimumEffortPath.minimumEffortPath(new int[][]{{1, 2, 3}, {3, 8, 4}, {5, 3, 5}}));
        System.out.println(bfsMinimumEffortPath.minimumEffortPath(new int[][]{{1, 2, 2}, {3, 8, 2}, {5, 3, 5}}));
    }

    public int minimumEffortPath(int[][] heights) {
        if (heights.length == 0) return 0;
        if (heights.length == 1 && heights[0].length <= 1) return 0;
        int tx = heights.length - 1;
        int ty = heights[0].length - 1;

        List<Point> path = new ArrayList<>();
        Point point = new Point(0, 0);
        path.add(point);
        int[] allMin = new int[]{-1};
        doMinimumEffortPath(heights, path, 0, 0, tx, ty, -1, allMin);
        return allMin[0];
    }

    /**
     * @param heights   地图
     * @param path      已走路径
     * @param x         当前坐标
     * @param y         当前坐标
     * @param tx        目标坐标
     * @param ty        目标坐标
     * @param maxHeight 最大高度落差
     * @param allMin    全局最小值
     * @return
     */
    private void doMinimumEffortPath(int[][] heights, List<Point> path, int x, int y, int tx, int ty, int maxHeight, int[] allMin) {
        // 遍历当前节点的四周节点
        ArrayList<Point> points = new ArrayList<>();
        if (x - 1 >= 0) {
            points.add(new Point(x - 1, y));
        }
        if (x + 1 <= tx) {
            points.add(new Point(x + 1, y));
        }
        if (y - 1 >= 0) {
            points.add(new Point(x, y - 1));
        }
        if (y + 1 <= ty) {
            points.add(new Point(x, y + 1));
        }

        for (Point p : points) {
            // 判断是否已经走过
            if (path.contains(p)) {
                continue;
            }

            // 计算高度落差
            Point lastPoint = path.get(path.size() - 1);
            int sub = Math.abs(heights[lastPoint.x][lastPoint.y] - heights[p.x][p.y]);
            int tempMaxHeight = Math.max(sub, maxHeight);

            // 判断是否终点
            if (p.x == tx && p.y == ty) {
                if (allMin[0] == -1) {
                    allMin[0] = tempMaxHeight;
                } else {
                    allMin[0] = Math.min(allMin[0], tempMaxHeight);
                }
                continue;
            }

            // 判断当前路径是否需要继续走
            if (allMin[0] == 0) {
                return; // 已经是最小
            }
            if (allMin[0] != -1) {
                if (tempMaxHeight >= allMin[0]) {
                    // 落差已超过最小值，不必再走
                    continue;
                }
            }

            path.add(p);
            doMinimumEffortPath(heights, path, p.x, p.y, tx, ty, tempMaxHeight, allMin);
            // 回溯
            path.remove(p);
        }
        // 表示不通
    }
}
