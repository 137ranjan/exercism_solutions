public class SquareRoot {
	public int squareRoot(int radicand) {
		int left = 0;
		int right = radicand + 1;

		while (left != right - 1) {
			int mid = (left + right) / 2;
			if (mid * mid <= radicand) {
				left = mid;
			} else {
				right = mid;
			}
		}

		return left;
	}
}
