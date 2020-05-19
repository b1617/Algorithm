/**
 * Time complexity : 0(nk)
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function (strs) {
  let obj = strs.reduce((acc, cur) => {
    let n = getWordSize(cur);
    if (!acc[n]) {
      acc[n] = [];
    }
    acc[n].push(cur);
    return acc;
  }, {});
  return Object.values(obj);
};

function getWordSize(word) {
  let hash = new Array(26).fill(0);
  for (let x of word) {
    let n = x.charCodeAt(0) - 97;
    hash[n]++;
  }
  return Object.values(hash).join('');
}

let a = groupAnagrams(['zeat', 'tea', 'tan', 'ate', 'nat', 'bat']);
console.log(a);
