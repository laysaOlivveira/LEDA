class Main
{
	// Function to find the square root of `x` using the binary search algorithm.
	// If `x` is not a perfect square, return the floor of the square root
	public static int sqrt(int x)
	{
		// base case
		if (x < 2) {
			return x;
		}

		// to store floor of `sqrt(x)`
		int result = 0;

		// the square root of `x` cannot be more than `x/2` for `x > 1`
		int start = 1;
		int end = x/2;

		while (start <= end)
		{
			// find the middle element
			int mid = (start + end) / 2;
			long sqr = mid*mid;

			// return `mid` if `x` is a perfect square
			if (sqr == x) {
				return mid;
			}

			// if `mid×mid` is less than `x`
			else if (sqr < x)
			{
				// discard left search space
				start = mid + 1;

				// update result since we need a floor
				result = mid;
			}

			// if `mid×mid` is more than `x`
			else {
				// discard the right search space
				end = mid - 1;
			}
		}

		// return result
		return result;
	}

	public static void main(String[] args)
	{
		for (int i = 0; i <= 16; i++) {
			System.out.printf("sqrt(%d) = %d\n", i, sqrt(i));
		}
	}
}