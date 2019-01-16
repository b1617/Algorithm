package algo.ds.backtracking;

public class SubsetSum {

	public static void main(String[] args) throws Exception {
		
		int[] nums = { 2, 5, 10, 4, 2 };
		System.out.println(subsetSum(0, nums, 7));
	}

	// Return true if subset of the nums is equal to target
	private static boolean subsetSum(int i, int[] nums, int target) {
		if (target == 0) {
			return true;
		} else if (target < 0 || i >= nums.length) {
			return false;
		} else {
			return subsetSum(i + 1, nums, target - nums[i]) || subsetSum(i + 1, nums, target);
		}
	}
	
}
