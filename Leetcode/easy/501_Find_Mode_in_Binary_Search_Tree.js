/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * Time complexity : O(n)
 * @param {TreeNode} root
 * @return {number[]}
 */
var findMode = function (root) {
  let map = {};
  if (root) {
    dfs(root, map);
  }
  let res = [];
  let max = -1;
  for (let el in map) {
    if (map[el] > max) {
      max = map[el];
      res = [el];
    } else if (map[el] === max) {
      res.push(el);
    }
  }
  return res;
};

var dfs = function (node, map) {
  if (node) {
    dfs(node.left, map);
    dfs(node.right, map);
    if (map[node.val]) {
      map[node.val]++;
    } else {
      map[node.val] = 1;
    }
  }
};
