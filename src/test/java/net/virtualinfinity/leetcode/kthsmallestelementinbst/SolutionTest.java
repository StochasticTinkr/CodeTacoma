package net.virtualinfinity.leetcode.kthsmallestelementinbst;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    @ParameterizedTest
    @MethodSource
    void kthSmallest(TreeNode root, int k, int expected) {
        assertEquals(expected, new Solution().kthSmallest(root, k));
    }

    private static Stream<Arguments> kthSmallest() {
        return Stream.of(
                arguments(tree(3, 1, 4, null, 2), 1, 1)
        );
    }

    private static TreeNode tree(Integer...values) {
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