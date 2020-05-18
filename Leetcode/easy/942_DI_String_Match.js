/**
 * Time complexity : O(n)
 * @param {string} S
 * @return {number[]}
 */
var diStringMatch = function (S) {
  let arr = [];
  let min = 0;
  let max = S.length;
  for (let i = 0; i < S.length; ++i) {
    if (S[i] == 'I') {
      arr.push(min++);
    } else {
      arr.push(max--);
    }
  }
  arr.push(min);
  return arr;
};
