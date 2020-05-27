/**
 * Time complexity : 0(n)
 * Space complexity : O(w)
 * @param {number[]} T
 * @return {number[]}
 */
var dailyTemperatures = function (T) {
  let stack = [];
  let res = new Array(T.length).fill(0);
  for (let i = 0; i < T.length; i++) {
    while (stack.length && T[i] > T[stack[stack.length - 1]]) {
      const index = stack.pop();
      res[index] = i - index;
    }
    stack.push(i);
  }
  return res;
};
