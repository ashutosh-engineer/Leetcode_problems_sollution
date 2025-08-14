class Solution {
    public String largestGoodInteger(String num) {
        String maxGood = "";
        
        for (int i = 0; i <= num.length() - 3; i++) {
            char a = num.charAt(i);
            char b = num.charAt(i + 1);
            char c = num.charAt(i + 2);
            
            // Check if all three digits are the same
            if (a == b && b == c) {
                String good = num.substring(i, i + 3);
                // Compare strings lexicographically to get the largest
                if (maxGood.isEmpty() || good.compareTo(maxGood) > 0) {
                    maxGood = good;
                }
            }
        }
        
        return maxGood;
    }
}
