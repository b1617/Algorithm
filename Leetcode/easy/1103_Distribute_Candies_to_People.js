/**
 * Time complexity : O(sqrt(candies))
 * Space complexity : O(n)
 * @param {number} candies
 * @param {number} num_people
 * @return {number[]}
 */
var distributeCandies = function (candies, num_people) {
  let arr = new Array(num_people).fill(0);
  for (let i = 0; candies > 0; ++i) {
    arr[i % num_people] += Math.min(candies, i + 1);
    candies -= i + 1;
  }
  return arr;
};

console.log(distributeCandies(7, 4));
