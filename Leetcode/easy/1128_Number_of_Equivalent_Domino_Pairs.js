/**
 * Time complexity : O(n)
 * Space complexity : O(n)
 * @param {number[][]} dominoes
 * @return {number}
 */
var numEquivDominoPairs = function (dominoes) {
  let map = {};
  for (let i = 0; i < dominoes.length; ++i) {
    const [x, y] = dominoes[i];
    const hash1 = x + '' + y;
    const hash2 = y + '' + x;
    if (map[hash1] == null && map[hash2] == null) {
      map[hash1] = 1;
    } else {
      if (map[hash1] != null) {
        map[hash1]++;
      } else {
        map[hash2]++;
      }
    }
  }
  let ct = 0;
  for (let el in map) {
    if (map[el] > 0) {
      ct += (map[el] * (map[el] - 1)) / 2;
    }
  }
  return ct;
};
