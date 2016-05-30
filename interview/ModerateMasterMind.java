package interview;

import java.util.Arrays;

public class ModerateMasterMind {
	
	static int[] hitsPseudoHits(String original, String guess) {
		if (original.length() != guess.length())
			return null;
		
		int hits = 0;
		boolean[] isHit = new boolean[original.length()];
		for (int i = 0; i < original.length(); ++i)
			if (original.charAt(i) == guess.charAt(i)) {
				++hits;
				isHit[i] = true;
			}
		
		int pseudo = 0;
		for (int i = 0; i < original.length(); ++i)
			for (int j = i + 1; j < guess.length(); ++j)
				if (!isHit[i] && !isHit[j] && original.charAt(i) == guess.charAt(j)) {
					++pseudo;
					break;
				}
		
		return new int[]{hits, pseudo};
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(hitsPseudoHits("RGBY", "GGRR")));
	}
}
