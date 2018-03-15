import java.util.*;

public class LC554_BrickWall {
	
	// Time: O(B lg B), Space: O(B)
	public int leastBricks(List<List<Integer>> wall) {
		if (wall == null || wall.isEmpty()) {
			return 0;
		}
		int height = wall.size();
        int wallWidth = 0;
        for (int brickWidth : wall.get(0)) {
        	wallWidth += brickWidth;
        }
        List<List<Integer>> positions = getPositions(wall);
        Set<Integer> stopPoints = new TreeSet<>();
        for (List<Integer> row : positions) {
        	for (int position : row) {
        		stopPoints.add(position);
        	}
        }
        stopPoints.remove(wallWidth);
        
        Map<Integer, Set<Integer>> rowsPerPosition = getRowsPerPosition(positions);
        int min = height;
        for (int stop : stopPoints) {
        	min = Math.min(min, height - rowsPerPosition.get(stop).size());
        }
        
        return min;
    }
	
	// Time: O(B), Space: O(B)
	private List<List<Integer>> getPositions(List<List<Integer>> wall) {
		List<List<Integer>> positions = new ArrayList<>();
		for (List<Integer> row : wall) {
			List<Integer> positionRow = new ArrayList<>();
			int position = 0;
			for (int x : row) {
				position += x;
				positionRow.add(position);
			}
			positions.add(positionRow);
		}
		return positions;
	}
	
	// Time: O(B), Space: O(B)
	private Map<Integer, Set<Integer>> getRowsPerPosition(List<List<Integer>> positions) {
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int rowIndex = 0; rowIndex < positions.size(); rowIndex++) {
			List<Integer> row = positions.get(rowIndex);
			for (int position : row) {
				if (!map.containsKey(position)) {
					map.put(position, new HashSet<Integer>());
				}
				map.get(position).add(rowIndex);
			}
		}
		return map;
	}
}
