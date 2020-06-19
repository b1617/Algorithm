/**
 * Time complexity : O(n)
 * Space complexity : O(1)
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function (height) {
  let max = -1;
  for (let i = 0, j = height.length - 1; i < j; ) {
    let n = j - i;
    let min = Math.min(height[i], height[j]);
    max = Math.max(max, n * min);
    if (min == height[i]) {
      ++i;
    } else {
      --j;
    }
  }
  return max;
};
