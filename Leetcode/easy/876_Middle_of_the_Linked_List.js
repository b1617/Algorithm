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
 * @return {ListNode}
 */
var middleNode = function (head) {
  let store = [];
  let i = 0;
  while (head) {
    store[i++] = head;
    head = head.next;
  }
  return store[parseInt(store.length / 2)];
};
