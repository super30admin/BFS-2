"""
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

 

Example 1:


Input: root = [1,2,3,4], x = 4, y = 3
Output: false
Example 2:


Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
Example 3:



Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
 

Constraints:

The number of nodes in the tree will be between 2 and 100.
Each node has a unique integer value from 1 to 100.
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        """
        Travere Level order Traversal and store Current Value, Parent Value and its level
        Create a Hashmap and store the current value as key and parent value and its level as its value.

        Now when we found either x or y we need to check whether the remaining value is in hashmap or not. If there we need check different parents and those values are in same level.
        If not return False
        If yes Return True


        Run Time Complexity : O(N)
        Space Complexity: O(N)
        """
        queue = deque()
        hashmap = collections.defaultdict(list)
        queue.append((root, None, 0))
        hashmap[root.val] = [None, 0]
        while queue:
            for i in range(len(queue)):
                node, parent, level = queue.popleft()
                if node.val == x or node == y:
                    if node.val == x:
                        if y in hashmap:
                            y_parent, y_level = hashmap[y]
                            if parent.val != y_parent and level == y_level:
                                return True
                            else:
                                return False
                        else:
                            return False
                    if node.val == y:
                        if x in hashmap:
                            x_parent, x_level = hashmap[x]
                            if parent.val != x_parent and level == x_level:
                                return True
                            else:
                                return False
                        else:
                            return False
                if node.left:
                    queue.append((node.left, node, level+1))
                    hashmap[node.left.val] = [node.val, level+1]
                if node.right:
                    queue.append((node.right, node, level+1))
                    hashmap[node.right.val] = [node.val, level+1]

            
        