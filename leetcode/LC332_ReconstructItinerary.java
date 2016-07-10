package leetcode;

import java.util.*;

public class LC332_ReconstructItinerary {
	
	Map<String, Set<String>> buildGraph(String[][] tickets) {
		Map<String, Set<String>> graph = new HashMap<String, Set<String>>();
        
        for (String[] pair : tickets) {
        	if (!graph.containsKey(pair[0])) graph.put(pair[0], new TreeSet<String>());
        	if (!graph.containsKey(pair[1])) graph.put(pair[1], new TreeSet<String>());
        	
        	graph.get(pair[0]).add(pair[1]);
        }
        
        return graph;
	}
	
	Map<String, Integer> buildEdgeFrequency(String[][] tickets) {
		seen = new HashMap<String, Integer>();
		
		for (String[] pair : tickets) {
			String edge = pair[0] + pair[1];
			if (!seen.containsKey(edge)) seen.put(edge, 0);
			seen.put(edge, seen.get(edge) + 1);
		}
		
		return seen;
	}
	
	Map<String, Set<String>> graph;
	Map<String, Integer> seen;
	List<String> itinerary;
	
	void dfs(String u, Stack<String> tmp, int numEdges) {
		if (itinerary != null) return;
		if (tmp.size() == numEdges + 1) {
			itinerary = new ArrayList<String>(tmp);
			return;
		}
		for (String v : graph.get(u)) {
			if (seen.get(u + v) > 0) {
    			seen.put(u + v, seen.get(u + v) - 1);
    			tmp.push(v);
    			dfs(v, tmp, numEdges);
    			tmp.pop();
    			seen.put(u + v, seen.get(u + v) + 1);
    		}
		}
	}
	
	public List<String> findItinerary(String[][] tickets) {
        graph = buildGraph(tickets);
        seen = buildEdgeFrequency(tickets);
        itinerary = null;
        
        String start = "JFK";
        Stack<String> tmp = new Stack<String>();
        tmp.push(start);
        dfs(start, tmp, tickets.length);

        return itinerary;
    }
}
