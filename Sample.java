// Problem 1 - Cousins in Binary Tree
// Time Complexity: O(n) where n = number of nodes
// Space Complexity: O(n) for recursive stack

// Algorithm
// 1 - initiliaze global variables
// 2 - call recursive function
// 3 - base condition to check if root is null
// 4 - condition if root.val equals either of the given values and update corresponding global variable
// 5 - recurrsion on left subtree
// 6 - recurrsion on right subtree
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  // 1
  int xLevel = -1;
  int yLevel = -1;
  TreeNode xParent = null;
  TreeNode yParent = null;

  public boolean isCousins(TreeNode root, int x, int y) {
    // 2
    recurr(root, x, y, 0, null);
    return (xLevel == yLevel) && (xParent != yParent);
  }

  private void recurr(TreeNode root, int x, int y, int level, TreeNode parent) {
    // 3
    if (root == null) {
      return;
    }
    // 4
    if (root.val == x) {
      xLevel = level;
      xParent = parent;
    }
    if (root.val == y) {
      yLevel = level;
      yParent = parent;
    }
    // 5
    recurr(root.left, x, y, level + 1, root);
    // 6
    recurr(root.right, x, y, level + 1, root);
  }
}

// Problem 2 - Rotting Oranges
// Time Complexity: O(n * m) where n = number of rows, m = number of columns
// Space Complexity: O(n * m) -> extra space for queue

// Algorithm
// 1 - get count of fresh oranges
// 2 - add position of rotten oranges to queue
// 3 - initialize directions array
// 4 - while condition
// 5 - get size of queue
// 6 - if fresh equals 0, then return minutes
// 7 - loop over size of queue
// 8 - loop over directions
// 9 - get row number and column number
// 10 - check for edge conditions and if the cell has fresh orange, change it to rotten
// 11 - increase the minutes by 1 once looped over size of queue
// 12 - finally, if fresh is greater than 0, return -1 else return minutes
class Solution {
  public int orangesRotting(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int fresh = 0;
    int minutes = 0;
    Queue<int[]> queue = new LinkedList<>();
    
    for (int i=0; i<grid.length; i++) {
      for (int j=0; j<grid[0].length; j++) {
        // 1
        if (grid[i][j] == 1) {
          fresh += 1;
        }
        // 2
        if (grid[i][j] == 2) {
          queue.add(new int[]{i, j});
        }
      }
    }
    
    // 3
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    // 4
    while (!queue.isEmpty()) {
      // 5
      int size = queue.size();
      // 6
      if (fresh == 0) {
        return minutes;
      }
      // 7
      for (int k=0; k<size; k++) {
        int[] rotten = queue.poll();
        // 8
        for (int[] dir : dirs) {
          // 9
          int i = rotten[0] + dir[0];
          int j = rotten[1] + dir[1];
          // 10
          if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            grid[i][j] = 2;
            fresh -= 1;
            queue.add(new int[]{i, j});
          }
        }
      }
      // 11
      minutes += 1;
    }
    // 12
    return fresh > 0 ? -1 : minutes;
    
  }
}

// Problem 3 - Employee Importance
// Time Complexity: O(n) where n = number of employees
// Space Complexity: O(n) -> extra space for map

// Algorithm
// 1 - store id to employee mapping into hashmap
// 2 - add given id to a queue
// 3 - while condition
// 4 - poll id from queue and add its importance
// 5 - loop over its subordinates and add them to the queue
// 6 - return importance

/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
  public int getImportance(List<Employee> employees, int id) {
    if (employees.size() == 0) {
      return 0;
    }

    int importance = 0;
    Map<Integer, Employee> map = new HashMap<>();
    
    // 1
    for (int i=0; i<employees.size(); i++) {
      map.put(employees.get(i).id, employees.get(i));
    }

    Queue<Integer> queue = new LinkedList<>();
    // 2
    queue.add(id);
    // 3
    while (!queue.isEmpty()) {
      // 4
      int empId = queue.poll();
      importance += map.get(empId).importance;
      // 5
      for (int sub :  map.get(empId).subordinates) {
        queue.add(sub);
      }
    }
    
    // 6
    return importance;
  }
}
