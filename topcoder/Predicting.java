
public class Predicting {
	double[] weights = {-1.0, -0.9, -0.8, -0.7, -0.6, -0.5, -0.4, -0.3, -0.2, -0.1, 0.0,
            0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0};
	double[] data;
	int nweights = weights.length;
	double best;
	
	void solve(int k, double sum, double[] w) {
		if (k == 0) {
			if (Math.abs(sum) > 1e-6)
				return;
    		sum = 0.0;
    		for (int i = 5; i < data.length; ++i) {
    			double pred = 0.0;
    			for (int j = 1; j <= 5; ++j)
    				pred += w[j - 1] * data[i - j];
    			sum += Math.abs(data[i] - pred);
    		}
    		best = Math.min(best, sum / (data.length - 5));
    		return;
		}
		
		for (int i = 0; i < nweights; ++i) {
			w[k - 1] = weights[i];
			solve(k - 1, sum - weights[i], w);
		}
	}
	
    public double avgError(double[] _data) {
        
        data = _data.clone();
        best = Double.MAX_VALUE;

        solve(5, 1.0, new double[5]);
        return best;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(Predicting.class, "test.*");
    }

	public void test0() {
		RETester.eq(avgError(new double[] {10,10,10,10,10,10}), 0.0);
	}

	public void test1() {
		RETester.eq(avgError(new double[] {50,10,50,10,50,10,50,10,50,10,50,10}), 0.0);
	}

	public void test2() {
		RETester.eq(avgError(new double[] {50,60,50,60,50,60,60}), 5.0);
	}

	public void test3() {
		RETester.eq(avgError(new double[] {
			82.9102, 70.6848, 21.503, 61.4588, 54.7789,
			48.9889, 57.6766, 91.1859, 26.3674, 55.4601,
			53.9357, 87.2005, 78.4771, 65.0102, 18.619,
			90.296, 26.3894, 53.8588, 91.8369, 58.8028,
			74.0577, 28.2406, 65.609, 59.4867, 27.7544,
			54.6992, 69.2428, 22.6264, 87.0083, 58.5116,
			60.286, 20.4318, 65.6475, 11.8348, 36.3488,
			92.8092, 60.7392, 98.124, 48.1292, 39.5459,
			52.2657, 34.3519, 38.9279, 93.0152, 11.3157}),
			22.0175905);
	}

// END CUT HERE
}
