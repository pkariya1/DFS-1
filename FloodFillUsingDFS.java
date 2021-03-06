public class FloodFillUsingDFS {
	int color;

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

		if (image == null || image.length == 0 || image[sr][sc] == newColor)
			return image; // check if the new color == old color then return image bcoz otherwise cycle
							// repeats in recursion

		color = image[sr][sc];
		dfs(image, sr, sc, newColor);
		return image;

	}

	private void dfs(int[][] image, int i, int j, int newColor) {

		// base
		if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != color)
			return;

		// logic
		int[][] dirs = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
		image[i][j] = newColor;
		for (int[] dir : dirs) {
			int r = dir[0] + i;
			int c = dir[1] + j;
			dfs(image, r, c, newColor);
		}

	}

}
