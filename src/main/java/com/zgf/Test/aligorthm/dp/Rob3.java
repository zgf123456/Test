package com.zgf.Test.aligorthm.dp;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/house-robber/
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * 树形房屋
 */
public class Rob3 {
    public static void main(String[] args) {
        Rob3 rob1 = new Rob3();
        // [3,2,3,null,3,null,1]
        TreeNode treeNodeRoot = new TreeNode(3);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(1);

        treeNodeRoot.setLeft(treeNode1);
        treeNodeRoot.setRight(treeNode2);
        treeNode1.setRight(treeNode3);
        treeNode2.setRight(treeNode4);

        System.out.println(rob1.rob(treeNodeRoot));
    }

    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;

        // 备忘录 - 解决重复计算
        HashMap<TreeNode, Integer> dbTable = new HashMap<TreeNode, Integer>();
        return doRob(root, dbTable);
    }

    private int doRob(TreeNode node, HashMap<TreeNode, Integer> dbTable) {
        if (node == null) return 0;
        if (dbTable.get(node) != null) return dbTable.get(node);

        // 状态转移方程
        if (node.left == null && node.right == null) {
            return node.val;
        } else {
            // dp状态转移方程，当前房间偷或不偷 -- 第一个手动写出
            int selectCur = node.val;
            if (node.left != null) {
                selectCur += doRob(node.left.left, dbTable) + doRob(node.left.right, dbTable);
            }
            if (node.right != null) {
                selectCur += doRob(node.right.left, dbTable) + doRob(node.right.right, dbTable);
            }

            int noSelectCur = doRob(node.left, dbTable) + doRob(node.right, dbTable);
            int max = Math.max(selectCur, noSelectCur);
            dbTable.put(node, max);
            return max;
        }
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
