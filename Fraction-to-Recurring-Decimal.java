import java.util.*;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder result = new StringBuilder();

        // Handle sign
        if ((numerator < 0) ^ (denominator < 0)) result.append("-");

        // Convert to long to handle overflow (like Integer.MIN_VALUE)
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Append integer part
        result.append(num / den);
        num %= den;
        if (num == 0) return result.toString();

        result.append(".");
        Map<Long, Integer> remainderIndexMap = new HashMap<>();

        while (num != 0) {
            if (remainderIndexMap.containsKey(num)) {
                int index = remainderIndexMap.get(num);
                result.insert(index, "(");
                result.append(")");
                break;
            }
            remainderIndexMap.put(num, result.length());
            num *= 10;
            result.append(num / den);
            num %= den;
        }

        return result.toString();
    }
}
