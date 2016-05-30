
import java.util.*;

public class SpaceWarDiv1 {
	
	class Enemy implements Comparable<Enemy> {
		int strength;
		long count;
		public Enemy(int strength, long count) {
			this.strength = strength;
			this.count = count;
		}
		public int compareTo(Enemy e) {
			return this.strength - e.strength;
		}
	}
	
	boolean check(int[] strength, int[] enemyStrength, long[] enemyCount, long F) {
		Enemy[] enemies = new Enemy[enemyCount.length];
        for (int i = 0; i < enemyCount.length; ++i)
        	enemies[i] = new Enemy(enemyStrength[i], enemyCount[i]);
        Arrays.sort(enemies);
        
        for (int i = 0, j = 0; i < strength.length && j < enemies.length; ++i) {
        	long cnt = F;
        	while (j < enemies.length && strength[i] >= enemies[j].strength && cnt > 0) {
	        	long toRem = Math.min(cnt, enemies[j].count);
	        	enemies[j].count -= toRem;
	        	cnt -= toRem;
	    		if (enemies[j].count == 0)
	    			++j;
        	}
        }
        long cnt = 0;
        for (int i = 0; i < enemies.length; ++i)
        	cnt += enemies[i].count;
        
        return cnt > 0;
	}
	
    public long minimalFatigue(int[] magicalGirlStrength, int[] enemyStrength, long[] enemyCount) {
    	
    	boolean ok = true;
    	for (int i = 0; i < enemyStrength.length; ++i) {
    		int cnt = 0;
    		for (int j = 0; j < magicalGirlStrength.length; ++j)
    			if (enemyStrength[i] > magicalGirlStrength[j])
    				++cnt;
    		if (cnt == magicalGirlStrength.length) {
    			ok = false;
    			break;
    		}
    	}
    	if (!ok)
    		return -1;
    	
        long sum = 0;
        for (int i = 0; i < enemyCount.length; ++i)
        	sum += enemyCount[i];

        Arrays.sort(magicalGirlStrength);
        
    	long lo = 0;
        long hi = sum;
        
        while (lo < hi) {
        	long mid = (lo + hi) / 2;
        	if (check(magicalGirlStrength, enemyStrength, enemyCount, mid))
        		lo = mid + 1;
        	else
        		hi = mid;
        }
        return lo;
    }

// BEGIN CUT HERE
    public static void main(String[] args) {
        RETester.test(SpaceWarDiv1.class, "test.*");
    }

	public void test0() {
		RETester.eq(minimalFatigue(new int[] {2, 3, 5}, new int[] {1, 3, 4}, new long[] {2L, 9L, 4L}), 7L);
	}

	public void test1() {
		RETester.eq(minimalFatigue(new int[] {2, 3, 5}, new int[] {1, 1, 2}, new long[] {2L, 9L, 4L}), 5L);
	}

	public void test2() {
		RETester.eq(minimalFatigue(new int[] {14, 6, 22}, new int[] {8, 33}, new long[] {9L, 1L}), -1L);
	}

	public void test3() {
		RETester.eq(minimalFatigue(new int[] {869, 249, 599, 144, 929, 748, 665, 37, 313, 99, 33, 437, 308, 137, 665, 834, 955, 958, 613, 417}, new int[] {789, 57, 684, 741, 128, 794, 542, 367, 937, 739, 568, 872, 127, 261, 103, 763, 864, 360, 618, 307}, new long[] {
			20626770196420L, 45538527263992L, 52807114957507L, 17931716090785L, 65032910980630L, 88711853198687L, 26353250637092L,
			61272534748707L, 89294362230771L, 52058590967576L, 60568594469453L, 23772707032338L, 43019142889727L, 39566072849912L,
			78870845257173L, 68135668032761L, 36844201017584L, 10133804676521L, 6275847412927L, 37492167783296L}),
			75030497287405L);
	}

// END CUT HERE
}
