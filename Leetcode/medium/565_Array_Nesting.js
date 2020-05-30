/**
 * Time complexity : O(n)
 * Space complexity : O(1)
 * @param {number[]} nums
 * @return {number}
 */
var arrayNesting = function (nums) {
  let max = 0;
  for (let i = 0; i < nums.length; ++i) {
    let j = i;
    let ct = 0;
    while (nums[j] != -1) {
      ++ct;
      const temp = j;
      j = nums[j];
      nums[temp] = -1;
    }
    max = Math.max(max, ct);
  }
  return max;
};

