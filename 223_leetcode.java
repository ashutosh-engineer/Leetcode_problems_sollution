class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, 
                           int bx1, int by1, int bx2, int by2) {
        // Area of first rectangle
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        
        // Area of second rectangle
        int area2 = (bx2 - bx1) * (by2 - by1);
        
        // Overlapping area (if any)
        int overlapWidth = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
        int overlapHeight = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
        int overlapArea = overlapWidth * overlapHeight;

        // Total area = area1 + area2 - overlapping area
        return area1 + area2 - overlapArea;
    }
}
