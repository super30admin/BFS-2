// Time Complexity : O(n)
// Space Complexity : O(n/2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// BFS approach
var rightSideView = function (root) {
  const resultsArr = [];
  if (!root) return resultsArr;

  const queue = [root];

  while (queue.length) {
    let length = queue.length;
    while (length--) {
      let root = queue.shift();
      // if length is 0, we add the right-viewed element to our results arr.
      if (!length) {
        resultsArr.push(root.val);
      }
      root.left !== null && queue.push(root.left);
      root.right !== null && queue.push(root.right);
    }
  }
  return resultsArr;
};
