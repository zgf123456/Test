package com.zgf.Test.aligorthm.tree;

/**
 * @author zgf
 * @date 2021-04-13 上午10:41
 */
public class MinDiffInBST {
    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode();
        rootNode.val = 4;
        TreeNode node1 = new TreeNode();
        node1.val = 2;
        TreeNode node2 = new TreeNode();
        node2.val = 6;
        TreeNode node3 = new TreeNode();
        node3.val = 1;
        TreeNode node4 = new TreeNode();
        node4.val = 3;

        rootNode.left = node1;
        rootNode.right = node2;
        node1.left = node3;
        node1.right = node4;


        MinDiffInBST minDiffInBST = new MinDiffInBST();
        System.out.println(minDiffInBST.minDiffInBST(rootNode));
    }

    public int minDiffInBST(TreeNode root) {
        return findMinDiffInBST(null, root, Integer.MAX_VALUE);
    }

    public int findMinDiffInBST(TreeNode preNode, TreeNode node, int minVal) {
        // 中序遍历
        if (node.left != null) {
            if (preNode != null) {
                minVal = Math.min(minVal, Math.abs(node.left.val - preNode.val));
            }
            preNode = node.left;
            minVal = findMinDiffInBST(preNode, node.left, minVal);
        }

        if (preNode != null) {
            minVal = Math.min(minVal, Math.abs(node.val - preNode.val));
        }
        preNode = node;

        if (node.right != null) {
            if (preNode != null) {
                minVal = Math.min(minVal, Math.abs(node.right.val - preNode.val));
            }
            preNode = node.right;
            minVal = findMinDiffInBST(preNode, node.left, minVal);
        }
        return minVal;
    }
}
