/**
 * Time complextiy : O(n)
 * Space complexity : O(n)
 * @param {number} left
 * @param {number} right
 * @return {number[]}
 */
var selfDividingNumbers = function (left, right) {
  let res = [];
  for (let i = left; i <= right; ++i) {
    if (i < 9) {
      res.push(i);
    } else {
      if (i % 10 != 0) {
        let x = i;
        let add = true;
        while (x > 0) {
          const y = x % 10;
          if (i % y != 0) {
            add = false;
            break;
          }
          x = Math.floor(x / 10);
        }
        if (add) {
          res.push(i);
        }
      }
    }
  }
  return res;
};
