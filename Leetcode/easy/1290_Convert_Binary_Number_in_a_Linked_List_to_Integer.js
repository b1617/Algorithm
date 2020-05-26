/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * Time complexity : O(n)
 * Space complexity : O(n)
 * @param {ListNode} head
 * @return {number}
 */
var getDecimalValue = function (head) {
  let arr = [];
  while (head) {
    arr.unshift(head.val);
    head = head.next;
  }

  let sum = 0;
  for (let i = 0; i < arr.length; ++i) {
    if (arr[i] == 1) {
      sum += 2 ** i;
    }
  }
  return sum;
};
