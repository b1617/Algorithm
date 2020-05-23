/**
 * Time complexity : O(V+E)
 * Space complexity : O(n)
 * @param {number[]} nums
 * @return {boolean}
 */
var canJump = function (nums) {
  if (nums.length === 0) {
    return false;
  } else if (nums.length === 1) {
    return true;
  } else {
    let queue = [{ n: nums[0], index: 0 }];
    let visited = { 0: true };

    while (queue.length > 0) {
      const { n, index } = queue.shift();
      const len = index + n;
      for (let i = index + 1; i <= len && i < nums.length; ++i) {
        if (i === nums.length - 1) {
          return true;
        } else if (!visited[i]) {
          queue.push({ n: nums[i], index: i });
          visited[i] = true;
        }
      }
    }
    return false;
  }
};
