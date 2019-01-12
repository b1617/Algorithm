package algo.ds.codingBat;

public class Recursion2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 2, 4, 8 };
		System.out.println(groupSum(0, a, 12));
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
