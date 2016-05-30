
public class QuickExponentiation {
	
	static long quickExpRec(int base, int exp) {
		if (exp == 0) return 1;
		if (exp == 1) return base;
		
		long tmp = quickExpRec(base, exp / 2);
		return (exp % 2 == 0 ? 1 : base) * tmp * tmp;
	}
	
	static long quickExpIt(int base, int exp) {		
		long ans = 1;
		while (exp > 0) {
			if (exp % 2 == 1) ans *= base;
			exp /= 2;
			base *= base;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		int base = 9;
		int exp = 15;
		
		System.out.println(base + "^" + exp + "=" + quickExpRec(base, exp));
		System.out.println(base + "^" + exp + "=" + quickExpIt(base, exp));
	}
}
