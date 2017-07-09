public class Intersections {
	
	static final int UNIVERSE_SIZE = 10;
	static final int A_SIZE = 9;
	static final int B_SIZE = 8;
	static final int C_SIZE = 7;
	
	public static void main(String[] args) {
		int min = UNIVERSE_SIZE;
		int max = 0;
		for (int maskA = 0; maskA < (1 << UNIVERSE_SIZE); maskA++) {
			if (Integer.bitCount(maskA) != A_SIZE) continue;
			for (int maskB = 0; maskB < (1 << UNIVERSE_SIZE); maskB++) {
				if (Integer.bitCount(maskB) != B_SIZE) continue;
				for (int maskC = 0; maskC < (1 << UNIVERSE_SIZE); maskC++) {
					if (Integer.bitCount(maskC) == C_SIZE) {
						int intersection = maskA & maskB & maskC;
						int size = Integer.bitCount(intersection);
						max = Math.max(max, size);
						min = Math.min(min, size);
					}
				}
			}
		}
		
		System.out.println("max = " + max);
		System.out.println("min = " + min);
	}
}
