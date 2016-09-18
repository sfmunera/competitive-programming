package leetcode;

public class LC223_RectangleArea {
    static int findOverlap(int a, int b, int c, int d) {
        if (b <= c || d <= a) return 0; // disjoint
        
        if (c <= a && b <= d) return b - a;
        if (a <= c && d <= b) return d - c;
        
        if (a <= d && d <= b) {
            return d - a;
        } else {
            return b - c;
        }
    }
    
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int intersection = findOverlap(A, C, E, G) * findOverlap(B, D, F, H);
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);
                
        return area1 + area2 - intersection;
    }
    
    public static void main(String[] args) {
    	int A = -2;
    	int B = -2;
    	int C = 2;
    	int D = 2;
    	int E = 1;
    	int F = -3;
    	int G = 3;
    	int H = -1;
    	
    	System.out.println(computeArea(A, B, C, D, E, F, G, H));
    }
}
