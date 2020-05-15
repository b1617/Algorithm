/**
 * Time complexity : O(n)
 * @param {number[]} nums
 * @return {number}
 */
var rob = function (nums) {
  if (nums.length === 1) {
    return nums[0];
  }
  if (nums.length === 0) return 0;
  return Math.max(robHouse(nums.slice(1)), robHouse(nums.slice(0, -1)));
};

function robHouse(nums) {
  nums[1] = Math.max(nums[0], nums[1] ? nums[1] : 0);
  for (let i = 2; i < nums.length; ++i) {
    nums[i] = Math.max(nums[i - 1], nums[i] + nums[i - 2]);
  }
  return nums[nums.length - 1];
}

