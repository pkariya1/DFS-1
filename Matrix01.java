import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
	public int[][] updateMatrix(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return matrix;

		int row = matrix.length;
		int col = matrix[0].length;
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == 0)
					q.add(new int[] { i, j });

				if (matrix[i][j] == 1)
					matrix[i][j] = -1;
			}
		}
		int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		int dist = 1;
		while (!q.isEmpty()) {
			int size = q.size();

			for (int i = 0; i < size; i++) {
				int[] curr = q.poll();
				for (int[] dir : dirs) {

					int r = curr[0] + dir[0];
					int c = curr[1] + dir[1];

					if (r > 0 && r < row && c > 0 && c < col && matrix[r][c] == -1) {
						matrix[r][c] = dist;
						q.add(new int[] { r, c });
					}

				}

			}
			dist++;

		}

		return matrix;

	}
}
