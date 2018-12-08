package net.virtualinfinity.leetcode.findlargestvalueineachtreerow;

import net.virtualinfinity.leetcode.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static net.virtualinfinity.leetcode.TreeNodeHelper.tree;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    @ParameterizedTest
    @MethodSource
    void largestValues(TreeNode node, List<Integer> expected) {
        List<Integer> actual = new Solution().largestValues(node);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> largestValues() {
        return Stream.of(
                arguments(tree(1, 3, 2, 5, 3, null, 9), Arrays.asList(1, 3, 9))
        );
    }


}