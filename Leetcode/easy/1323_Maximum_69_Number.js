/**
 * @param {number} num
 * @return {number}
 */
var maximum69Number = function (num) {
  let arr = num.toString().split('');
  console.log(arr);
  for (let i = 0; i < arr.length; ++i) {
    if (arr[i] == '6') {
      arr[i] = 9;
      break;
    }
  }
  return arr.join('');
};

console.log(maximum69Number(9999));
