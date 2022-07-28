'''

## Problem 993: Cousins in binary tree

## Author: Neha Doiphode
## Date:   07-26-2022

## Description:
    Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y,
    return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.

    Two nodes of a binary tree are cousins if they have the same depth with different parents.

    Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.

## Examples:
    Example 1:
        Input: root = [1,2,3,4], x = 4, y = 3
        Output: false

    Example 2:
        Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
        Output: true

    Example 3:
        Input: root = [1,2,3,null,4], x = 2, y = 3
        Output: false

 ## Constraints:
    The number of nodes in the tree is in the range [2, 100].
    1 <= Node.val <= 100
    Each node has a unique value.
    x != y
    x and y are exist in the tree.

## Time complexity: Please refer to respective doc-strings of the approaches used below to solve the problem.

## Space complexity: Please refer to respective doc-strings of the approaches used below to solve the problem.


'''

from typing import List, Optional
from queue import Queue


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

def to_binary_tree(items):
    if not items:
        return None

    # iter(object, sentinel [optional])
    # sentinel = special character used to represent end of the sequence.
    it = iter(items)
    root = TreeNode(next(it))
    q = [root]
    for node in q:
        val = next(it, None)
        if val is not None:
            node.left = TreeNode(val)
            q.append(node.left)
        val = next(it, None)
        if val is not None:
            node.right = TreeNode(val)
            q.append(node.right)
    return root

def get_input():
    print("Enter nodes of tree with spaces at height h, from left to right.")
    print("Input null if no left or right child to a node at height h.")
    inp_list = input()
    inp_list = inp_list.split()
    l = []
    for value in inp_list:
        if value != "null":
            l.append(int(value))
        else:
            l.append(None)

    root = to_binary_tree(l)
    if root.val == None:
        l = []
        root = None

    print("Enter the values of x and y(cousins to search in the tree)(enter 2 integers with spaces, x <space> y): ")
    nums = input()
    nums = nums.split()
    x = int(nums[0])
    y = int(nums[1])

    return l, root, x, y

class Solution:
    x_depth  = 0
    y_depth  = 0
    x_parent = None
    y_parent = None

    def isCousins_BFS(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        '''
        Approach: Breadth First Search
        Time complexity : O(n), where n is number of nodes in the tree.
                                We traverse each node once.
        Space complexity: O(n), At a time auxiliary queue will have number of nodes at level 'l'.
                                Max number of nodes will be present at the last level if all each node on the previous level
                                has left and right child both.
                                For example,
                                if a tree has 4 levels, and each node has left and right child both,
                                level 0 = 1 node(root)(2 ^ 0)
                                level 1 = 2 (2 ^ 1)
                                level 3 = 4 (2 ^ 2)
                                level 4 = 8 (2 ^ 3)

                                Total number of nodes in the tree = 1 + 2 + 4 + 8 = 15
                                Nodes at the last level           = 8 ~= n/2

                                So, at a time, at the max n/2 nodes will be present in the queue.
                                Asymptotically, we can say that space complexity is O(n/2) ~= O(n).
        '''
        if root == None or x == y:
            return False

        size = 0
        x_found = False
        y_found = False
        q = Queue()
        q.put(root)

        while not q.empty():
            size = q.qsize()
            x_found = False
            y_found = False
            for i in range(size):
                current = q.get()

                if current.val == x:
                    x_found = True
                if current.val == y:
                    y_found = True

                # Check if left and right are not None
                # check if root has both children
                # if both children from same root are x and y then they are siblings but not cousins.
                # so we can simply return False
                if current.left != None and current.right != None:
                    if (current.left.val == x and current.right.val == y) or (current.left.val == y and current.right.val == x):
                        return False

                if current.left != None:
                    q.put(current.left)

                if current.right != None:
                    q.put(current.right)

            if (x_found and y_found):
                return True

        return False

    def dfs(self, root: TreeNode, depth: int, parent: TreeNode, x: int, y: int):
        if root == None:
            return

        # Check if current root's value is equal to x
        # if it is then capture its parent and depth
        if root.val == x:
            self.x_parent = parent
            self.x_depth  = depth

        # Check if current root's value is equal to y
        # if it is then capture its parent and depth
        if root.val == y:
            self.y_parent = parent
            self.y_depth  = depth

        # start the recursion.
        # Optimization that can be introduced here to save unnecessary recursive calls would be that,
        # if one of the parent is None, then only call left recursion or right recursion.
        if self.x_parent == None or self.y_parent == None:
            #         new root, current + 1, root becomes parent,
            self.dfs(root.left, depth + 1, root, x, y)

        if self.x_parent == None or self.y_parent == None:
            self.dfs(root.right, depth + 1, root, x, y)

    def isCousins_DFS(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        '''
        Approach: Depth First Search
                  Approach makes use of pre-order tree traversal with the order root-RIGHT-left.
                  As we reach a certain level/height h of the tree, we just initiate a new list.
                  During traversal, when we reach a particular node at level l,
                  we just append value of the node to the list reated for that level.

                  We can choose in-order traversal as well.
        Time complexity : O(n), where n is number of nodes in the tree.
                                We traverse each node once.
        Space complexity: O(h), where h is the height of the tree.
        '''
        if root == None or x ==y:
            return False

        self.x_depth = 0
        self.y_depth = 0
        self.x_parent = None
        self.y_parent = None
        root_depth = 0
        root_parent = None

        self.dfs(root, root_depth, root_parent, x, y)

        return ((self.x_depth == self.y_depth) and (self.x_parent != self.y_parent))


# Driver code
solution = Solution()
l, root, x, y = get_input()
print(f"Input Tree: {l}", end = "")
print()
print(f"x = {x}, y = {y}", end = "")
print()
print(f"Approach 1: With BFS: Are x and y cousins?: {solution.isCousins_BFS(root, x, y)}")
print(f"Approach 2: With DFS: Are x and y cousins?: {solution.isCousins_DFS(root, x, y)}")
