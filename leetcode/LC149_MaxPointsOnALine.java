package leetcode;

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class LC149_MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        int N = points.length;
        
        if (N == 1) return 1;
        
        int ans = 0;
        for (int i = 0; i < N - 1; ++i)
            for (int j = i + 1; j < N; ++j) {
                int cnt = 0;
                if (points[i].x == points[j].x) {
                    for (int k = 0; k < N; ++k) {
                        if (points[k].x == points[i].x) {
                            ++cnt;
                        }
                    }
                } else if (points[i].y == points[j].y) {
                    for (int k = 0; k < N; ++k) {
                        if (points[k].y == points[i].y) {
                            ++cnt;
                        }
                    }
                } else {
                    double m = (double) (points[j].y - points[i].y) / (points[j].x - points[i].x);
                    double b = points[i].y - m * points[i].x;
                    
                    for (int k = 0; k < N; ++k) {
                        if (Math.abs(points[k].y - (m * points[k].x + b)) < 1e-6) {
                            ++cnt;
                        }
                    }
                }
                ans = Math.max(ans, cnt);
            }
        return ans;
    }
}
