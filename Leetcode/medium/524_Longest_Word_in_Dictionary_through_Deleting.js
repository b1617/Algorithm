/**
 * Time complexity : O(n^2)
 * Space complexity : O(n^2)
 * @param {string} s
 * @param {string[]} d
 * @return {string}
 */
var findLongestWord = function (s, d) {
  if (s.length == 0 || d.length == 0) return '';
  let maps = {};
  for (let i = 0; i < s.length; ++i) {
    const chr = s[i];
    if (!maps[chr]) {
      maps[chr] = { ct: 1, index: [i] };
    } else {
      maps[chr].ct++;
      maps[chr].index.push(i);
    }
  }

  let res = null;
  for (let i = 0; i < d.length; ++i) {
    let copyMaps = JSON.parse(JSON.stringify(maps));
    let lastIndex = -1;
    const word = d[i];
    let isPossible = true;
    for (let j = 0; j < word.length; ++j) {
      const chr = word[j];
      if (copyMaps[chr] && copyMaps[chr].ct > 0) {
        let indexBigger = copyMaps[chr].index.find(
          (index) => index > lastIndex
        );
        if (indexBigger != null) {
          copyMaps[chr].ct--;
          lastIndex = indexBigger;
          copyMaps[chr].index.splice(
            copyMaps[chr].index.indexOf(indexBigger),
            1
          );
        } else {
          isPossible = false;
          break;
        }
      } else {
        isPossible = false;
        break;
      }
    }
    if (isPossible && word.length > 0) {
      // check lexico size
      if (res !== null) {
        if (res.length < word.length) {
          res = word;
        } else if (res.length == word.length) {
          for (let i = 0; i < res.length; ++i) {
            if (word[i] < res[i]) {
              res = word;
            } else if (word[i] > res[i]) {
              break;
            }
          }
        }
      } else {
        res = word;
      }
    }
  }
  return res === null ? '' : res;
};
