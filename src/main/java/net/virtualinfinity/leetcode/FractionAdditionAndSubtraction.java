package net.virtualinfinity.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://leetcode.com/problems/fraction-addition-and-subtraction/
 */
public class FractionAdditionAndSubtraction {
    private final static Pattern fractionPattern = Pattern.compile("((?:[-+]?)\\d+)/(\\d+)");

    public String fractionAddition(String expression) {
        Matcher matcher = fractionPattern.matcher(expression);
        Fraction total = new Fraction(0, 1);
        while (matcher.lookingAt()) {
            long numerator = Long.parseLong(matcher.group(1));
            long denominator = Long.parseLong(matcher.group(2));
            total = total.add(new Fraction(numerator, denominator));
            matcher.region(matcher.end(), expression.length());
        }

        return total.toString();
    }

    static class Fraction {
        final long numerator;
        final long denominator;

        public Fraction(long numerator, long denominator) {
            this.numerator = denominator > 0 ? numerator : -numerator;
            this.denominator = Math.abs(denominator);
        }

        @Override
        public String toString() {
            return String.format("%d/%d", numerator, denominator);
        }

        public Fraction add(Fraction other) {
            long g = gcd(this.denominator, other.denominator);
            long numerator = this.numerator * (other.denominator / g) + other.numerator * (this.denominator / g);
            long denominator = other.denominator / g * this.denominator;
            return of(numerator, denominator);
        }

        private static Fraction of(long numerator, long denominator) {
            long g = gcd(numerator, denominator);
            return new Fraction(numerator / g, denominator / g);
        }

        /**
         *
         * @param a a number
         * @param b another number
         *
         * @return the greatest common denominator
         */
        static long gcd(long a, long b) {
            while (b != 0) {
                long tmp = b;
                b = a % b;
                a = tmp;
            }
            return a;
        }
    }
}
