'''
199 Binary Tree Right Side View
https://leetcode.com/problems/binary-tree-right-side-view/description/

Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.


Example 1:
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]

Example 2:
Input: root = [1,2,3,4,null,null,null,5]
Output: [1,3,4,5]

Example 3:
Input: root = [1,null,3]
Output: [1,3]

Example 4:
Input: root = []
Output: []

Constraints:
The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

Solution:
1. Level order traversal. At each level, compute the length of the queue. That determines the no. of nodes at that level. Add the last node at that level to the result.
Time: O(N), Space: O(W) (W = width of tree = max # nodes at any level)
https://youtu.be/NKzhoocKWAw?t=2274

2. DFS (traverse Root-Left-Right)
We recursively traverse the tree, level by level.
We always update each level with the most recently seen node's value.
Since left is called before right, rightmost values overwrite earlier ones
Time: O(N), Space: O(H)
https://youtu.be/NKzhoocKWAw?t=2880

3. DFS (traverse Root-Right-Left)
We do DFS and first go to the right child before the left.
At each new level, we add the first node we encounter (which is the rightmost).
This ensures the right-side view is built correctly.
Time: O(N), Space: O(H)

'''
from binary_tree import *

def right_view(root):
    if not root:
        return []
    q = deque()
    q.append(root)
    result = []
    while q:
        sz = len(q)
        for _ in range(sz):
            curr = q.popleft()
            if curr.left:
                q.append(curr.left)
            if curr.right:
                q.append(curr.right)
        result.append(curr.val)
    return result

def right_view_dfs_left_first(root):
    def dfs(root, level):
        if not root:
            return
        N = len(result)
        if level == N:
            result.append([])
        result[level] = root.val
        dfs(root.left, level+1)
        dfs(root.right, level+1)
    if not root:
        return []
    result = []
    dfs(root, 0)
    return result

def right_view_dfs_right_first(root):
    def dfs(root, level):
        if not root:
            return
        N = len(result)
        if level == N:
            result.append([])
            result[level] = root.val
        dfs(root.right, level+1)
        dfs(root.left, level+1)
    if not root:
        return []
    result = []
    dfs(root, 0)
    return result


def run_tests():
    tests = [([1,2,3,None,5,None,4],[1,3,4]),
             ([1,2,3,4,None,None,None,5],[1,3,4,5]),
             ([1,None,3], [1,3]),
             ([],[None]),
    ]
    for test in tests:
        root, ans = test[0], test[1]
        tree = build_tree_level_order(root)
        if tree: tree.display()
        print(f"root = {root}")
        for method in ['bfs','dfs_left_first','dfs_right_first']:
            if method == 'bfs':
                view = right_view(tree)
            elif method == 'dfs_left_first':
                view = right_view_dfs_left_first(tree)
            elif method == 'dfs_right_first':
                view = right_view_dfs_right_first(tree)
            passed = (ans == view)
            print(f"Method '{method}': Right view = {view}")
            assert passed == True, f"Test case failed"
            print(f"Pass: {passed}")

    print(f"\nDONE")


run_tests()