/**
 * Time complexity : O(n*m)
 * Space complexity : O(1)
 * @param {number[][]} matrix
 * @return {void} Do not return anything, modify matrix in-place instead.
 */
var setZeroes = function (matrix) {
  if (matrix.length == 0) return;
  let rows = matrix.length;
  let cols = matrix[0].length;
  console.log(cols);
  let isZeroRow = false;
  let isZeroCol = false;

  for (let i = 0; i < rows; ++i) {
    if (matrix[i][0] == 0) {
      isZeroRow = true;
      break;
    }
  }

  for (let i = 0; i < cols; ++i) {
    if (matrix[0][i] == 0) {
      isZeroCol = true;
      break;
    }
  }

  for (let i = 1; i < rows; ++i) {
    for (let j = 1; j < cols; ++j) {
      if (matrix[i][j] == 0) {
        matrix[0][j] = 0;
        matrix[i][0] = 0;
      }
    }
  }

  for (let i = 1; i < rows; ++i) {
    for (let j = 1; j < cols; ++j) {
      if (matrix[0][j] == 0 || matrix[i][0] == 0) {
        matrix[i][j] = 0;
      }
    }
  }
  if (isZeroRow) {
    for (let i = 0; i < rows; ++i) {
      matrix[i][0] = 0;
    }
  }
  if (isZeroCol) {
    for (let i = 0; i < cols; ++i) {
      matrix[0][i] = 0;
    }
  }
  return matrix;
};

console.log(setZeroes([[1, 0]]));
