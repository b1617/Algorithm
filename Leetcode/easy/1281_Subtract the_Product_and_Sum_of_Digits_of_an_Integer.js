/**
 * Time complexity : O(n)
 * Space complexity : O(1)
 * @param {number} n
 * @return {number}
 */
var subtractProductAndSum = function (n) {
  let product = 1;
  let sum = 0;

  while (n > 9) {
    const last = n % 10;
    product *= last;
    sum += last;
    n = Math.floor(n / 10);
  }
  product *= n;
  sum += n;
  return product - sum;
};
