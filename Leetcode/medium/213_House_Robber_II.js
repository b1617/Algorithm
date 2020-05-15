/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function (nums) {
  if (nums.length < 3) return 0;
  for (let i = 2; i < nums.length; ++i) {
    nums[i] = Math.max(nums[i - 1], nums[i] + nums[i - 2]);
  }
  return nums[nums.length - 1];
};

console.log(rob([2, 3, 2]));
