// Time Complexity : O(n)
// Space Complexity : O(n/2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// DFS Approach - more optimized, because it cuts down on traversals if level of one element is found
var isCousins = function (root, x, y) {
  let areCousins = false;
  let xLevel = -1;
  let yLevel = -1;
  let xParent;
  let yParent;
  if (root.val === x || root.val === y || !root) {
    return areCousins;
  }

  const dfs = (root, level, parent) => {
    // Base
    if (!root) {
      return;
    }

    if (root.val === x) {
      xLevel = level;
      xParent = parent;
      return;
    }

    if (root.val === y) {
      yLevel = level;
      yParent = parent;
      return;
    }

    // Logic
    dfs(root.left, level + 1, root.val);
    dfs(root.right, level + 1, root.val);
  };

  dfs(root, 0, -1);
  if (xLevel === yLevel && xParent !== yParent) {
    areCousins = true;
    return areCousins;
  }
  return areCousins;
};

// BFS Approach
var isCousins = function (root, x, y) {
  let areCousins = false;
  let xIsFound = false;
  let yIsFound = false;
  let xParent = -1;
  let yParent = -1;

  if (x === root.val || y === root.val || !root) {
    return areCousins;
  }
  const queue = [root];

  while (queue.length) {
    let length = queue.length;

    while (length--) {
      root = queue.shift();
      if (root.left !== null) {
        queue.push(root.left);
        if (root.left.val === x) {
          xIsFound = true;
          xParent = root.val;
        }
        if (root.left.val === y) {
          yIsFound = true;
          yParent = root.val;
        }
      }
      if (root.right !== null) {
        queue.push(root.right);
        if (root.right.val === x) {
          xIsFound = true;
          xParent = root.val;
        }
        if (root.right.val === y) {
          yIsFound = true;
          yParent = root.val;
        }
      }
    }
    if ((xIsFound && !yIsFound) || (!xIsFound && yIsFound)) {
      return areCousins;
    }
    if (xIsFound && yIsFound && xParent !== yParent) {
      areCousins = true;
      return areCousins;
    }
  }

  return areCousins;
};
