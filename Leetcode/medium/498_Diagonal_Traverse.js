/**
 * Time complexity : O(n^3)
 * Space complexity : O(n)
 * @param {number[][]} matrix
 * @return {number[]}
 */
var findDiagonalOrder = function (matrix) {
  let res = [];
  const len = matrix.length;
  for (let i = 0; i < len; ++i) {
    const line = matrix[i];
    for (let j = 0; j < line.length; ++j) {
      if (line[j] !== null) {
        let currArr = [];
        currArr.push(line[j]);
        line[j] = null;
        for (let k = 0; k < j && i + k + 1 < len; ++k) {
          const currLine = matrix[i + k + 1];
          currArr.push(currLine[j - k - 1]);
          currLine[j - k - 1] = null;
        }
        if ((i + j) % 2 === 0) {
          res = [...res, ...currArr.reverse()];
        } else {
          res = [...res, ...currArr];
        }
      }
    }
  }
  return res;
};

console.log(
  findDiagonalOrder([
    [2, 5],
    [8, 4],
    [0, -1]
  ])
);
