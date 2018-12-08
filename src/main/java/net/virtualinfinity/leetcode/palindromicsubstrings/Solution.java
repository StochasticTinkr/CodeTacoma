package net.virtualinfinity.leetcode.palindromicsubstrings;

/**
 * Solves https://leetcode.com/problems/palindromic-substrings/
 */
class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length() * 2; ++i) {
            count += countPalindromsAt(s, i);
        }

        return count;
    }

    private int countPalindromsAt(String s, int index) {
        int l = index / 2;
        int r = (index + 1) / 2;
        int count = 0;
        do {
            if (l < 0 || r >= s.length() || s.charAt(l) != s.charAt(r)) {
                break;
            }
            ++count;
            --l;
            ++r;
        } while (true);

        return count;
    }
}