/**
 * Time complexity : O(n)
 * Space complexity : O(n)
 * @param {number[]} nums
 * @param {number} limit
 * @return {number}
 */
var longestSubarray = function (nums, limit) {
  let count = 0;
  let result = 0;
  let current = [];
  let min = Number.MAX_SAFE_INTEGER;
  let max = Number.MIN_SAFE_INTEGER;

  for (let i = 0; i < nums.length; i++) {
    current.push(nums[i]);
    if (current.length < result) {
      continue;
    }
    min = Math.min(min, nums[i]);
    max = Math.max(max, nums[i]);
    let diff = Math.abs(max - min);

    if (diff <= limit) {
      count = current.length;
    } else {
      let ele = current.shift();
      if (ele === min) {
        min = Math.min(...current);
      } else if (ele === max) {
        max = Math.max(...current);
      }
    }
    result = Math.max(result, count);
  }
  return result;
};
