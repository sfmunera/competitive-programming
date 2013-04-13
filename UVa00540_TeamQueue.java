package uva;
/* USER: 46724 (sfmunera) */
/* PROBLEM: 481 (540 - Team Queue) */
/* SUBMISSION: 10093991 */
/* SUBMISSION TIME: 2012-05-09 18:39:38 */
/* LANGUAGE: 2 */

import java.util.*;
import java.io.*;

public class UVa00540_TeamQueue {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int k = 1;
		while (true) {
			int t = Integer.parseInt(in.readLine());
			if (t == 0)
				break;
			
			Map<Integer, Integer> member = new HashMap<Integer, Integer>();
			for (int i = 0; i < t; ++i) {
				String[] parts = in.readLine().split("[ ]+");
				for (int j = 1; j < parts.length; ++j) {
					int m = Integer.parseInt(parts[j]);
					member.put(m, i);
				}
			}
			
			System.out.println("Scenario #" + k);
			
			List<Queue<Integer>> queues = new ArrayList<Queue<Integer>>();
			Queue<Integer> teams = new LinkedList<Integer>();
			
			for (int i = 0; i < t; ++i)
				queues.add(new LinkedList<Integer>());
			
			String command;
			while (!(command = in.readLine()).equals("STOP")) {
				String[] parts = command.split("[ ]+");
				if (parts[0].equals("ENQUEUE")) {
					int val = Integer.parseInt(parts[1]);
					int team = member.get(val);
					
					if (queues.get(team).isEmpty()) {
						teams.offer(team);
					}
					queues.get(team).offer(val);
				} else {
					if (!teams.isEmpty()) {
						int team = teams.peek();
						int val = queues.get(team).poll();
						System.out.println(val);
						
						if (queues.get(team).isEmpty())
							teams.poll();
					}
				}
			}
			System.out.println();
			++k;
		}
		
		in.close();
		System.exit(0);
	}
}
