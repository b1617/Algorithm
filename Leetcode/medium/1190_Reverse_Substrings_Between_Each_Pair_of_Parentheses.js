/**
 * Time complexity : O(n)
 * Space complexity : O(n)
 * @param {string} s
 * @return {string}
 */
var reverseParentheses = function (s) {
  let arr = Array.from(s);
  let stack = [];
  for (let i = 0; i < arr.length; ++i) {
    const ele = arr[i];
    if (ele === ')') {
      let word = [];
      while (stack.length > 0 && stack[stack.length - 1] !== '(') {
        const removedEle = stack.pop();
        if (removedEle !== '(') {
          word.push(removedEle);
        }
      }
      stack.pop();
      stack = [...stack, ...word];
    } else {
      stack.push(ele);
    }
  }
  return stack.join('');
};
