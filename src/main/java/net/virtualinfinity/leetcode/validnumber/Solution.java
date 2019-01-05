package net.virtualinfinity.leetcode.validnumber;

class Solution {
    public boolean isNumber(String s) {
        final int len = s.length();
        char c;
        int i = 0;
        while (i < len && s.charAt(i) == ' ') {
            ++i;
        }
        if (i == len) {
            return false;
        }
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            ++i;
        }
        boolean point = false;
        boolean digit = false;
        do {
            c = s.charAt(i);
            if (c == '.') {
                if (point) {
                    return false;
                }
                point = true;
            } else {
                if (c == 'e' || c == ' ') {
                    break;
                }
                if (c < '0' || c > '9') {
                    return false;
                }
                digit = true;
            }
            ++i;
        } while (i < len);
        if (!digit) {
            return false;
        }
        if (i == len) {
            return true;
        }
        if (s.charAt(i) == 'e') {
            digit = false;
            if (++i >= len) {
                return false;
            }
            c = s.charAt(i);
            if (c == '-' || c == '+') {
                if (++i >= len) {
                    return false;
                }
            }
            do {
                c = s.charAt(i++);
                if (c == ' ') {
                    break;
                }
                if (c < '0' || c > '9') {
                    return false;
                }
                digit = true;
            } while (i < len);
            if (!digit) {
                return false;
            }
        }
        while (i < len) {
            if (s.charAt(i++) != ' ') {
                return false;
            }
        }
        return true;
    }
}