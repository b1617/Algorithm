/**
 * Time complexity : O(n)
 * @param {string} A
 * @param {string} B
 * @return {boolean}
 */
var rotateString = function (A, B) {
  if (A.length !== B.length) return false;
  let startIndex = -1;
  let j = 0;
  let i = 0;
  for (i = 0, j = 0; i < A.length && j < B.length; i++) {
    if (A[i] == B[j]) {
      ++j;
      if (startIndex == -1) {
        startIndex = i;
      }
    } else {
      j = 0;
      if (startIndex != -1) --i;
      startIndex = -1;
    }
  }
  for (j, i = 0; j < B.length && i < startIndex + 1; ++j, ++i) {
    if (A[i] !== B[j]) return false;
  }
  return j == A.length;
};
