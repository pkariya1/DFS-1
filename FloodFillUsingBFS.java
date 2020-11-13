import java.util.LinkedList;
import java.util.Queue;

public class FloodFillUsingBFS {
	 public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
			int color;

			if (image == null || image.length == 0 || image[sr][sc] == newColor)
				return image; // check if the new color == old color then return image bcoz otherwise cycle
								// repeats in recursion

			color = image[sr][sc];
			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] { sr, sc });
			int[][] dirs = { { 0, 1 }, {0,-1},{1,0},{-1,0} };
	       image[sr][sc] = newColor;
			while (!q.isEmpty()) {
				int[] curr = q.poll();
				for (int[] dir : dirs) {
					int r = curr[0] + dir[0];
					int c = curr[1] + dir[1];

					if (r >= 0 && r < image.length && c >= 0 && c < image[0].length && image[r][c] == color) {
						q.add(new int[] { r, c });
						image[r][c] = newColor;
					}
				}

			}

			return image;
		}
}
