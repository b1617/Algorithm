/**
 * Time complexity : O(nlogn)
 * Space complexity : O(n)
 * @param {number[]} nums
 * @return {number}
 */
var findUnsortedSubarray = function (nums) {
  let sortedNums = nums.slice(0).sort((a, b) => a - b);
  let x = null;
  let y = null;
  for (let i = 0, j = nums.length - 1; i < nums.length, j > -1; ++i, --j) {
    if (nums[i] !== sortedNums[i] && x == null) {
      x = i;
    }
    if (nums[j] !== sortedNums[j]) {
      if (nums[j] !== sortedNums[j] && y == null) {
        y = j + 1;
      }
    }
    if (x && y) {
      break;
    }
  }
  return y != null && y != null ? y - x : 0;
};
