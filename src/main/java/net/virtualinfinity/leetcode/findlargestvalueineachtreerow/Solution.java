package net.virtualinfinity.leetcode.findlargestvalueineachtreerow;

import net.virtualinfinity.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * solves https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        final List<Integer> result = new ArrayList<>();
        List<TreeNode> depth = root == null ? Collections.emptyList() : Collections.singletonList(root);
        while (!depth.isEmpty()) {
            Iterator<TreeNode> iterator = depth.iterator();
            int max = depth.get(0).val;
            depth = new ArrayList<>(depth.size()*2);
            while (iterator.hasNext()) {
                TreeNode next = iterator.next();
                max = Math.max(max, next.val);
                if (next.left != null) {
                    depth.add(next.left);
                }
                if (next.right != null) {
                    depth.add(next.right);
                }
            }
            result.add(max);

        }
        return result;
    }
}



