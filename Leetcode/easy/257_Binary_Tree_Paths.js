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
 * Space complexity : O(n)
 * @param {TreeNode} root
 * @return {string[]}
 */
var binaryTreePaths = function (root) {
  let store = [];
  var dfs = function (node, path) {
    if (node) {
      path = path ? path + '->' + node.val : '' + node.val;
      if (!node.left && !node.right) {
        store.push(path);
      }
      dfs(node.left, path);
      dfs(node.right, path);
    }
  };
  dfs(root, null);
  return store;
};
