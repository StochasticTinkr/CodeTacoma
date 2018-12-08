package net.virtualinfinity.leetcode;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TreeNodeHelper {
    public static TreeNode tree(Integer...values) {
        List<TreeNode> nodes = Stream.of(values).map(val -> val == null ? null : new TreeNode(val)).collect(Collectors.toList());
        for (int i = 0; i < values.length/2; ++i) {
            TreeNode current = nodes.get(i);
            if (current != null) {
                current.left = nodes.get(i*2+1);
                current.right = nodes.get(i*2+2);
            }
        }
        return nodes.get(0);
    }
}
