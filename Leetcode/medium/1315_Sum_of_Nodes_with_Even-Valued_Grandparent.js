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
 * Space complexity : O(bd)
 * @param {TreeNode} root
 * @return {number}
 */
var sumEvenGrandparent = function (root) {
  if (root.val === null) return 0;
  let sum = dfs(root, null, null);
  return sum;
};

var dfs = function (node, parent, grandParent) {
  let leftSum = 0,
    rightSum = 0;
  if (node && node.val) {
    leftSum = dfs(node.left, node, parent);
    rightSum = dfs(node.right, node, parent);
    return (
      leftSum +
      rightSum +
      (grandParent && grandParent.val % 2 == 0 ? node.val : 0)
    );
  }
  return 0;
};
