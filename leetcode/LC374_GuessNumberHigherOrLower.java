package leetcode;

/* The guess API is defined in the parent class GuessGame.
@param num, your guess
@return -1 if my number is lower, 1 if my number is higher, otherwise return 0
   int guess(int num); */

public class LC374_GuessNumberHigherOrLower// extends GuessGame 
{
	// Mock of the GuessGame function
	int guess(int num) {
		return 0;
	}
	
	public int guessNumber(int n) {
		long low = 1;
		long high = n;

		int hiddenNumber = 0;
		while (low <= high) {
			long mid = (low + high) / 2;
			int g = guess((int)mid);
			if (g == 0) {
				hiddenNumber = (int)mid;
				break;
			} else if (g < 0) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return hiddenNumber;
	}
}