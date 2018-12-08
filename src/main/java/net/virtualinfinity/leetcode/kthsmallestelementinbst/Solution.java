package net.virtualinfinity.leetcode.kthsmallestelementinbst;

import net.virtualinfinity.leetcode.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int k;
    private int value;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k-1;
        walk(root);
        return value;
    }

    private boolean walk(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!walk(root.left)) {
            return false;
        } else {
            if (accept(root.val)) {
                return false;
            }
        }
        return walk(root.right);
    }

    private boolean accept(int val) {
        if (k == 0) {
            value = val;
            return true;
        } else {
            --k;
            return false;
        }
    }
}


