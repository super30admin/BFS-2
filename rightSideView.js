// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// DFS approach
var rightSideView = function (root) {
  const resultsArr = [];
  if (!root) return resultsArr;

  const dfs = (root, level) => {
    // base condition
    if (root === null) return;
    if (resultsArr[level] === undefined) {
      resultsArr.push(root.val);
    }
    // logic
    dfs(root.right, level + 1);
    dfs(root.left, level + 1);
  };

  dfs(root, 0);
  return resultsArr;
};

// BFS approach
// TC for this approach worse than dfs because it would be O(n+n).
// Given the first n could be removed as a constant due to the asymptotic nature
// of calculating complexities, it would become O(n), but truly it is slower if the
// constant is not removed.
var rightSideView = function (root) {
  const resultsArr = [];
  if (!root) return resultsArr;

  const queue = [root];

  while (queue.length) {
    let length = queue.length;
    while (length--) {
      // O(n) tc - looping through all elements
      let root = queue.shift(); // additional O(n) time since we have to move all elements to the left in the array
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
