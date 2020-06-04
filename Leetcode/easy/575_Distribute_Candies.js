/**
 * Time complexity : O(n)
 * Space complexity : O(n)
 * @param {number[]} candies
 * @return {number}
 */
var distributeCandies = function (candies) {
  let set = new Set();
  for (let i = 0; i < candies.length; ++i) {
    const candy = candies[i];
    if (!set.has(candy)) {
      set.add(candy);
    }
  }
  return Math.min(set.size, candies.length / 2);
};
