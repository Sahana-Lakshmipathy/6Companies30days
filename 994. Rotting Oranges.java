import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        // Edge case: empty grid
        if (grid == null || grid.length == 0) return -1;

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        int time = 0;

        // Directions for moving up, down, left, right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Add all rotten oranges to the queue and count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j}); // Rotten orange position
                } else if (grid[i][j] == 1) {
                    freshOranges++; // Count fresh oranges
                }
            }
        }

        // If there are no fresh oranges, return 0 (no time needed)
        if (freshOranges == 0) return 0;

        // Perform BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundFresh = false; // Track if fresh oranges rot in this round

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0], y = current[1];

                // Check all 4 directions
                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    // If within bounds and fresh orange is found
                    if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2; // Rot the fresh orange
                        queue.add(new int[]{newX, newY}); // Add newly rotten orange to queue
                        freshOranges--; // Decrease fresh orange count
                        foundFresh = true; // Mark fresh orange as found
                    }
                }
            }

            // Increment time only if at least one orange rotted in this round
            if (foundFresh) time++;
        }

        // If there are still fresh oranges left, return -1
        return freshOranges == 0 ? time : -1;
    }
}
