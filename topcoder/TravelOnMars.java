import java.util.*;

public class TravelOnMars {
    public int minTimes(int[] range, int startCity, int endCity) {
    	int N = range.length;
        Queue<Integer> Q = new LinkedList<Integer>();
        int[] dist = new int[N];
        boolean[] seen = new boolean[N];
        
        Arrays.fill(dist, -1);
        Q.offer(startCity);
        dist[startCity] = 0;
        seen[startCity] = true;
        
        while (!Q.isEmpty()) {
        	int x = Q.poll();
        	if (x == endCity)
        		return dist[x];
        	
        	for (int i = 1; i <= range[x]; ++i) {
        		int nx = ((x - i) % N + N) % N;
        		if (!seen[nx]) {
        			seen[nx] = true;
        			dist[nx] = dist[x] + 1;
        			Q.offer(nx);
        		}
        	}
        	for (int i = 1; i <= range[x]; ++i) {
        		int nx = (x + i) % N;
        		if (!seen[nx]) {
        			seen[nx] = true;
        			dist[nx] = dist[x] + 1;
        			Q.offer(nx);
        		}
        	}
        }
        return -1;
    }

}


// Powered by FileEdit
// Powered by RETester [based on ExampleBuilder]
// Powered by CodeProcessor
