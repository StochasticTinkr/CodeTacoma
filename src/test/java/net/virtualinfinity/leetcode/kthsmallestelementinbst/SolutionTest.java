package net.virtualinfinity.leetcode.kthsmallestelementinbst;

import net.virtualinfinity.leetcode.TreeNode;
import net.virtualinfinity.leetcode.TreeNodeHelper;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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
                arguments(TreeNodeHelper.tree(3, 1, 4, null, 2), 1, 1)
        );
    }

}