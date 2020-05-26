/**
 * Time complexity : O(nm)
 * Space complexity : O(nm)
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function (m, n) {
  let mx = [];
  for (let i = 0; i < n; ++i) {
    mx[i] = new Array(m).fill(0);
  }
  for (let i = 0; i < n; ++i) {
    for (let j = 0; j < m; ++j) {
      if (mx[i - 1] && mx[i - 1][j] && mx[i][j - 1]) {
        mx[i][j] = mx[i - 1][j] + mx[i][j - 1];
      } else {
        mx[i][j] = 1;
      }
    }
  }
  return mx[n - 1][m - 1];
};
