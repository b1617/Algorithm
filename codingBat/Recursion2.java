package algo.ds.codingBat;

public class Recursion2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = { 2, 5, 10, 4, 2 };
		System.out.println(groupNoAdj(0, a, 7));

	}

	static boolean groupNoAdj(int i, int[] nums, int target) {
		if (target == 0) {
			return true;
		} else if (target < 0 || i >= nums.length || (i == nums.length - 1 && (target - nums[i]) != 0)) {
			return false;
		} else {
			if (i == 0) {
				return groupNoAdj(i + 2, nums, target - nums[i]) || groupNoAdj(i + 3, nums, target - nums[i + 1]);
			}
			return groupNoAdj(i + 2, nums, target - nums[i]) || groupNoAdj(i + 2, nums, target)
					|| groupNoAdj(i + 3, nums, target - nums[i]) || groupNoAdj(i + 3, nums, target);
		}

	}

	static boolean groupSum6(int i, int[] nums, int target) {
		if (target == 0) {
			if (i < nums.length) {
				if (nums[i] == 6) {
					return groupSum6(i + 1, nums, target - 6);
				} else {
					return groupSum6(i + 1, nums, target);
				}
			} else {
				return true;
			}
		} else if (target < 0 || i >= nums.length) {
			return false;
		} else {
			if (nums[i] == 6) {
				return groupSum6(i + 1, nums, target - 6);
			} else {
				return groupSum6(i + 1, nums, target - nums[i]) || groupSum6(i + 1, nums, target);
			}
		}
	}

	static boolean groupSum(int i, int[] nums, int target) {
		if (target == 0) {
			return true;
		} else if (target < 0 || i >= nums.length) {
			return false;
		} else {
			return groupSum(i + 1, nums, target - nums[i]) || groupSum(i + 1, nums, target);
		}
	}

}
