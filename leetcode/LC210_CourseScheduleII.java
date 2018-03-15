import java.util.*;

public class LC210_CourseScheduleII {
	
	private class QueueItem implements Comparable<QueueItem> {
		int id, degree;
		QueueItem(int id, int degree) {
			this.id = id;
			this.degree = degree;
		}
		@Override
		public int compareTo(QueueItem that) {
			if (this.degree != that.degree) {
				return this.degree - that.degree;
			} else {
				return this.id - that.id;
			}
		}
	}
	
	private List<List<Integer>> getGraph(int numCourses, int[][] prerequisites) {
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			graph.add(new ArrayList<>());		
		}
		for (int[] edge : prerequisites) {
			graph.get(edge[1]).add(edge[0]);
		}
		return graph;
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		List<List<Integer>> graph = getGraph(numCourses, prerequisites);
		int[] degree = new int[numCourses];
		for (int[] edge : prerequisites) {
			degree[edge[0]]++;
		}
		
		PriorityQueue<QueueItem> Q = new PriorityQueue<>();
		for (int i = 0; i < numCourses; i++) {
			Q.add(new QueueItem(i, degree[i]));
		}
		
		int[] ans = new int[numCourses];
		for (int i = 0; i < numCourses; i++) {
			QueueItem current = Q.poll();
			if (current.degree != 0) return new int[]{};
			ans[i] = current.id;
			for (int neighbor : graph.get(current.id)) {
				Q.add(new QueueItem(neighbor, --degree[neighbor]));
			}
		}
		return ans;
	}
}
