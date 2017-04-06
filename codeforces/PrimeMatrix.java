import java.util.*;

public class PrimeMatrix {
	
	static final int MAX = 1000000;
	static List<Integer> primes;
	
	static void sieve() {
		boolean[] prime = new boolean[MAX + 1];
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		
		for (int p = 2; p * p <= MAX; p++) {
			if (prime[p]) {
				for (int i = p * p; i <= MAX; i += p) {
					prime[i] = false;
				}
			}
		}
		
		primes = new ArrayList<Integer>();
		for (int i = 2; i <= MAX; i++) {
			if (prime[i]) primes.add(i);
		}
	}
	
	static long getMinMoves(int[] arr) {
		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			int p = findNextPrime(arr[i]);
			sum += (long)p - arr[i];
		}
		
		return sum;
	}
	
	static int findNextPrime(int x) {
		int low = 0;
		int high = primes.size() - 1;
		
		int next = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			int p = primes.get(mid);
			if (p >= x) {
				next = p;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		
		return next;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		sieve();
		
		int[][] matrix = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = in.nextInt();
			}
		}
		
		long ans = Long.MAX_VALUE;
		// try rows
		for (int r = 0; r < n; r++) {
			int[] row = new int[m];
			for (int i = 0; i < m; i++) {
				row[i] = matrix[r][i];
			}
			long cnt = getMinMoves(row);
			ans = Math.min(ans, cnt);
		}
		// try cols
		for (int c = 0; c < m; c++) {
			int[] col = new int[n];
			for (int i = 0; i < n; i++) {
				col[i] = matrix[i][c];
			}
			long cnt = getMinMoves(col);
			ans = Math.min(ans, cnt);
		}
		
		System.out.println(ans);
		
		in.close();
		System.exit(0);
	}
}
