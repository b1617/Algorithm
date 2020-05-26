/**
 * Time complexity : O(n^2)
 * Space complexity : O(1)
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var threeSumClosest = function (nums, target) {
  let res = nums[0] + nums[1] + nums[2];
  nums.sort((a, b) => a - b);
  for (let i = 0; i < nums.length - 2; ++i) {
    let x = i + 1;
    let y = nums.length - 1;
    while (x < y) {
      const sum = nums[i] + nums[x] + nums[y];
      if (sum > target) {
        --y;
      } else {
        ++x;
      }
      if (Math.abs(sum - target) < Math.abs(res - target)) {
        res = sum;
      }
    }
  }
  return res;
};
