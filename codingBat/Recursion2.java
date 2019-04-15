package algo.ds.codingBat;

public class Recursion2 {

	public static void main(String[] args) {
		int[] a = { 3, 5, 1 };
		System.out.println(groupSum5(0, a, 9));
	}

	static boolean groupSum5(int i, int[] nums, int target) {
		System.out.println(i + " " + target);
		if (target == 0) {
			if (i < nums.length) {
				if (nums[i] % 5 == 0) {
					return groupSum5(i + 1, nums, target - nums[i]);
				} else {
					return groupSum5(i + 1, nums, target);
				}
			} else {
				return true;
			}
		} else if (target < 0 || i >= nums.length) {
			return false;
		} else {
			if (nums[i] % 5 != 0) {
				return groupSum5(i + 1, nums, target - nums[i]) || groupSum5(i + 1, nums, target);
			} else {
				if (i + 1 < nums.length) {
					if (nums[i + 1] != 1) {
						return groupSum5(i + 1, nums, target - nums[i]);
					} else if (nums[i] == 5 && nums[i + 1] == 1) {
						return groupSum5(i + 1, nums, target - nums[i]);
					} else {
						return groupSum5(i + 2, nums, target);
					}
				} else {
					return groupSum5(i + 1, nums, target) || groupSum5(i + 1, nums, target - nums[i]);
				}
			}
		}
	}

	static boolean groupNoAdj(int i, int[] nums, int target) {
		if (target == 0) {
			return true;
		} else if (target < 0 || i >= nums.length) {
			return false;
		} else {
			return groupNoAdj(i + 2, nums, target - nums[i]) || groupNoAdj(i + 1, nums, target);
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
