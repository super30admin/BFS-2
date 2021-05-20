# Definition for a binary tree node.
from typing import List
from collections import deque
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:

    result=[]


    def rightSideView(self, root: TreeNode) -> List[int]:
        if root is None: return List[int]
        levelquue=deque()
        result=list(int)
        levelquue.append(root)
        while levelquue.__len__()>0:
            size=levelquue.__len__()

            for idx in range(size):
                emp=levelquue.popleft()

                if idx == size -1:
                    result.append(emp.val)
                if emp.left is not None: levelquue.append(emp.left)
                if emp.right is not None: levelquue.append(emp.right)

        return result

    def rightSideView(self, root: TreeNode) -> List[int]:
        if root is None: return List[int]
        self.dfs(root,0)
        return self.result



    def dfs(self,root:TreeNode, level: int) -> None:
        if root is None: return  None

        if level==len(self.result):
            self.result.append(root.val)
        self.dfs(root.right,level+1)
        self.dfs(root.left,level+1)






    # def rightSideView(self, root: TreeNode) -> List[int]:
    #     if root is None: return List[int]
    #     levelquue=deque()
    #     result=list(int)
    #     levelquue.append(root)
    #     while levelquue.__len__()>0:
    #         size=levelquue.__len__()
    #
    #         for idx in range(size):
    #             emp=levelquue.popleft()
    #
    #             if idx == size -1:
    #                 result.append(emp.val)
    #             if emp.left is not None: levelquue.append(emp.left)
    #             if emp.right is not None: levelquue.append(emp.right)
    #
    #     return result
    # Space:=O(2*n)
    # Time:-O(n)


