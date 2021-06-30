# Definition for a binary tree node.
from collections import deque
from typing import List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

"""
BFS solution: maintain a queue structure and pop nodes from queue. 
If node to be popped is last node (right side node), append it to result

Time Complexity: O(n)
Space Complexity: ?
"""
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        result=[]
        if root==None:
            return result

        q=deque()
        q.append(root)
        while q:
            size=len(q)
            for i in range(size):
                node=q.popleft()
                if (i==size-1): #right node is last node being added, so if i is at last node, append it to result list
                    result.append(node.val)
                if node.left!=None:
                    q.append(node.left)

                if node.right!=None:
                    q.append(node.right)

        return result

"""
With the same BFS approach you can first add the right side of the node and then left side 
of the node. So very first node(i==0) coming out to the queue will go inside the result list

 for i in range(size):
                node=q.popleft()
                if (i==0): #right node is last node being added, so if i is at last node, append it to result list
                    result.append(node.val)
                if node.right!=None:
                    q.append(node.right)
                if node.left!=None:
                    q.append(node.left)
"""

