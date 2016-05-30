
public class AntsMeet {
	
    public int countAnts(int[] x, int[] y, String direction) {
        int N = x.length;
        
        String dir = "NESW";
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        boolean[] inactive = new boolean[N];
        for (int k = 1; k <= 5000; ++k) {
        	for (int i = 0; i < N; ++i)
        		if (!inactive[i]) {
        			int di = dir.indexOf(direction.charAt(i));
	        		for (int j = i + 1; j < N; ++j)
	        			if (!inactive[j]) {
	        				int dj = dir.indexOf(direction.charAt(j));
	        				if (2 * x[i] + dx[di] * k == 2 * x[j] + dx[dj] * k && 
	        					2 * y[i] + dy[di] * k == 2 * y[j] + dy[dj] * k)
	        					inactive[i] = inactive[j] = true;
	        			}
        		}
        }
        
        int ans = 0;
        for (int i = 0; i < N; ++i)
        	if (!inactive[i])
        		++ans;
        return ans;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(AntsMeet.class, "test.*");
    }

	public void test0() {
		RETester.eq(countAnts(new int[] {0,10,20,30}, new int[] {0,10,20,30}, "NWNE"), 2);
	}

	public void test1() {
		RETester.eq(countAnts(new int[] {-10,0,0,10}, new int[] {0,-10,10,0}, "NEWS"), 0);
	}

	public void test2() {
		RETester.eq(countAnts(new int[] {-1,-1,-1,0,0,0,1,1,1}, new int[] {-1,0,1,-1,0,1,-1,0,1}, "ESEWNNEWW"), 4);
	}

	public void test3() {
		RETester.eq(countAnts(new int[] {4,7,6,2,6,5,7,7,8,4,7,8,8,8,5,4,8,9,1,5,9,3,4,0,0,1,0,7,2,6,9,6,3,0,5,5,1,2,0,4,9,7,7,1,8,1,9,2,7,3}, new int[] {2,3,0,6,8,4,9,0,5,0,2,4,3,8,1,5,0,7,3,7,0,9,8,1,9,4,7,8,1,1,6,6,6,2,8,5,1,9,0,1,1,1,7,0,2,5,4,7,5,3}, "SSNWSWSENSWSESWEWSWSENWNNNESWSWSWWSSWEEWWNWWWNWENN" ), 25);
	}

	public void test4() {
		RETester.eq(countAnts(new int[] {
			478,-664,759,434,-405,513,565,-396,311,-174,56,993,251,-341,993,-112,242,129,383,513,-78,-341,-148,129,423
			,493,434,-405,478,-148,929,251,56,242,929,-78,423,-664,802,251,759,383,-112,-591,-591,-248,660,660,735,493},
			new int[] {
			-186,98,948,795,289,-678,948,-170,-195,290,-354,-424,289,-157,-166,150,706,-678,684,-294,-234,36,36,-294,-216
			,-234,427,945,265,-157,265,715,275,715,-186,337,798,-170,427,706,754,961,286,-216,798,286,961,684,-424,337},
			"WNSNNSSWWWEENWESNSWSWSEWWEWEWWWNWESNSSNNSNNWWWNESE"), 44);
	}
	
	public void test5() {
		RETester.eq(countAnts(new int[] {0, 9, 0, 0}, new int[] {0, 0, 4, 5}, "EWSS" ), 2);
	}

// END CUT HERE
}
