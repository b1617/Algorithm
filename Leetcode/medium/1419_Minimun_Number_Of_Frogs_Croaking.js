/**
 * @param {string} croakOfFrogs
 * @return {number}
 */
var minNumberOfFrogs = function (croakOfFrogs) {
  let ct = {
    c: 0,
    r: 0,
    o: 0,
    a: 0,
    k: 0
  };
  let max = 0;
  for (let i = 0; i < croakOfFrogs.length; ++i) {
    const letter = croakOfFrogs[i];
    ct[letter]++;
    if (
      ct['c'] >= ct['r'] &&
      ct['r'] >= ct['o'] &&
      ct['o'] >= ct['a'] &&
      ct['a'] >= ct['k']
    ) {
      max = Math.max(max, ct['c']);
    } else {
      return -1;
    }
    if (letter === 'k') {
      ct['c']--;
      ct['r']--;
      ct['o']--;
      ct['a']--;
      ct['k']--;
    }
  }
  for (let x in ct) {
    if (ct[x] !== 0) return -1;
  }
  return max;
};

// Time complexity : O(n)
