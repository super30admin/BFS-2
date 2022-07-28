'''

## Problem 119: Binary tree right side view

## Author: Neha Doiphode
## Date:   07-26-2022

## Description:
    Given the root of a binary tree, imagine yourself standing on the right side of it,
    return the values of the nodes you can see ordered from top to bottom.

## Examples:
    Example 1:
        Input: root = [1,2,3,null,5,null,4]
        Output: [1,3,4]

    Example 2:
        Input: root = [1,null,3]
        Output: [1,3]

    Example 3:
        Input: root = []
        Output: []

    Example 4:
        Input: root = [1,2,3,4]
        Output: []

## Constraints:
    The number of nodes in the tree is in the range [0, 100].
    -100 <= Node.val <= 100

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
    return l, root

class Solution:
    ## Used for DFS based solution ##
    answer = []
    def rightSideView_BFS(self, root: Optional[TreeNode]) -> List[int]:
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
        if root == None:
            return []

        q = Queue()
        size = 0
        answer = []
        q.put(root)
        size += 1
        while not q.empty():
            size = q.qsize()
            for i in range(size):
                node = q.get()
                if node.left:
                    q.put(node.left)
                if node.right:
                    q.put(node.right)
            if node != None:
                answer.append(node.val)
        return answer

    def dfs(self, root: TreeNode, level: int) -> None:
        if root == None:
            return

        if level == len(self.answer):
            self.answer.append(root.val)
            #### DO NOT RETURN, NOT A BASE CASE ####

        self.dfs(root.right, level + 1)
        self.dfs(root.left, level + 1)

    def rightSideView_DFS(self, root: Optional[TreeNode]) -> List[int]:
        '''
        Approach: Depth First Search
                  Approach makes use of pre-order tree traversal with the order root-RIGHT-left.
                  As we reach a certain level/height h of the tree, we just initiate a new list.
                  During traversal, when we reach a particular node at level l,
                  we just append value of the node to the list reated for that level.

        Time complexity : O(n), where n is number of nodes in the tree.
                                We traverse each node once.
        Space complexity: O(h), where h is the height of the tree.
        '''
        if root == None:
            return []

        self.answer = []

        level = 0
        self.dfs(root, level)
        return self.answer

# Driver code
solution = Solution()
l, root = get_input()
print(f"Input Tree: {l}", end = "")
print()
print(f"Approach 1: With BFS: Right side view: {solution.rightSideView_BFS(root)}")
print(f"Approach 2: With DFS: Right side view: {solution.rightSideView_DFS(root)}")
