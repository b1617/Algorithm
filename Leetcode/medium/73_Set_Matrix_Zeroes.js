/**
 * Time complexity : O(n*m) * (n+m)
 * Space complexity : O(1)
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var setZeroes = function (matrix) {
  if (matrix.length == 0) return;
  let rows = matrix.length;
  let cols = matrix[0].length;
  //   console.log(rows, cols
  for (let i = 0; i < rows; ++i) {
    for (let j = 0; j < cols; ++j) {
      // check 0
      const e = matrix[i][j];
      if (e === 0) {
        // top to bottom
        for (let k = 0; k < rows; ++k) {
          matrix[k][j] = matrix[k][j] !== 0 ? 'x' : 0;
        }
        // left to right
        for (let l = 0; l < cols; ++l) {
          matrix[i][l] = matrix[i][l] !== 0 ? 'x' : 0;
        }
      }
    }
  }
  for (let i = 0; i < rows; ++i) {
    for (let j = 0; j < cols; ++j) {
      if (matrix[i][j] === 'x') {
        matrix[i][j] = 0;
      }
    }
  }
  return matrix;
};

console.log(
  setZeroes([
    [0, 1, 2, 0],
    [3, 4, 5, 2],
    [1, 3, 1, 5]
  ])
);
