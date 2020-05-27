/**
 * Time complexity : 0(n^2)
 * Space complexity : O(n)
 * @param {number[]} T
 * @return {number[]}
 */
var dailyTemperatures = function (T) {
  let res = [];
  for (let i = 0; i < T.length; ++i) {
    const temp = T[i];
    let flag = false;
    for (let j = i + 1; j < T.length; ++j) {
      const nextTemp = T[j];
      if (nextTemp > temp) {
        res.push(j - i);
        flag = true;
        break;
      }
    }
    if (!flag) {
      res.push(0);
    }
  }
  return res;
};
