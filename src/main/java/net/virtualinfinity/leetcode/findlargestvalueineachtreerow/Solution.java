package net.virtualinfinity.leetcode.findlargestvalueineachtreerow;

import net.virtualinfinity.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * solves https://leetcode.com/problems/find-largest-value-in-each-tree-row/
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        final List<Integer> result = new ArrayList<>();
        List<TreeNode> depth = root == null ? Collections.emptyList() : Collections.singletonList(root);
        while (!depth.isEmpty()) {
            int min = depth.stream().mapToInt(treeNode -> treeNode.val).max().getAsInt();
            result.add(min);
            depth = depth.stream().flatMap(treeNode -> Stream.of(treeNode.left, treeNode.right)).filter(Objects::nonNull).collect(Collectors.toList());
        }
        return result;
    }
}



