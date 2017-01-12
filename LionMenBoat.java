
public class LionMenBoat {
	
	static final int TOTAL_MEN = 3;
	static final int TOTAL_LIONS = 3;
	
	static enum BoatState {
		EMPTY, LION, MAN;
	}
	
	static int getBoatStateId(BoatState boat) {
		return boat == BoatState.EMPTY ? 0 : (boat == BoatState.LION ? 1 : 2);
	}
	
	static boolean isValid(int menLeft, int lionsLeft, BoatState boat, boolean[][][] seen) {
		int menRight = TOTAL_MEN - menLeft - (boat == BoatState.MAN ? 1 : 0);
		int lionsRight = TOTAL_LIONS - lionsLeft - (boat == BoatState.LION ? 1 : 0);
		
		return validQuantities(menLeft, lionsLeft, menRight, lionsRight) &&
				!lionCanEatMan(menLeft, lionsLeft, menRight, lionsRight) && 
				!seen[menLeft][lionsLeft][getBoatStateId(boat)];
	}
	
	static boolean lionCanEatMan(int menLeft, int lionsLeft, int menRight, int lionsRight) {
		return lionsLeft > menLeft || lionsRight > menRight;
	}
	
	static boolean validQuantities(int menLeft, int lionsLeft, int menRight, int lionsRight) {
		return menLeft >= 0 && lionsLeft >= 0 && menRight >= 0 && lionsRight >= 0 &&
				menLeft <= TOTAL_MEN && lionsLeft <= TOTAL_LIONS && menRight <= TOTAL_MEN && lionsRight <= TOTAL_LIONS;
	}
	
	static boolean solve(int menLeft, int lionsLeft, BoatState boat, boolean[][][] seen) {
		if (menLeft == TOTAL_MEN && lionsLeft == TOTAL_LIONS) {
			return true;
		}
		
		seen[menLeft][lionsLeft][getBoatStateId(boat)] = true;

		boolean can = false;
		if (boat == BoatState.EMPTY) {
			if (isValid(menLeft    , lionsLeft - 1, BoatState.LION , seen)) can |= solve(menLeft    , lionsLeft - 1, BoatState.LION , seen);
			if (isValid(menLeft    , lionsLeft    , BoatState.LION , seen)) can |= solve(menLeft    , lionsLeft    , BoatState.LION , seen);
			if (isValid(menLeft - 1, lionsLeft    , BoatState.MAN  , seen)) can |= solve(menLeft - 1, lionsLeft    , BoatState.MAN  , seen);
			if (isValid(menLeft    , lionsLeft    , BoatState.MAN  , seen)) can |= solve(menLeft    , lionsLeft    , BoatState.MAN  , seen);
		} else if (boat == BoatState.LION) {
			if (isValid(menLeft    , lionsLeft + 1, BoatState.EMPTY, seen)) can |= solve(menLeft    , lionsLeft + 1, BoatState.EMPTY, seen);
			if (isValid(menLeft    , lionsLeft    , BoatState.EMPTY, seen)) can |= solve(menLeft    , lionsLeft    , BoatState.EMPTY, seen);
		} else { // (boat == BoatState.MAN)
			if (isValid(menLeft + 1, lionsLeft    , BoatState.EMPTY, seen)) can |= solve(menLeft + 1, lionsLeft    , BoatState.EMPTY, seen);
			if (isValid(menLeft    , lionsLeft    , BoatState.EMPTY, seen)) can |= solve(menLeft    , lionsLeft    , BoatState.EMPTY, seen);
		}
		
		return can;
	}
	
	public static void main(String[] args) {
		boolean ans = solve(0, 0,BoatState.EMPTY, new boolean[4][4][4]);
		System.out.println(ans ? "Possible" : "Impossible");
	}
}
