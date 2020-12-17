# Binary Tree Right Side View

# Time Complexity : O(N)
# Space Complexity : O(h), h is the height of the tree
# Did this code successfully run on Leetcode : Yes with Runtime: 56 ms and Memory Usage: 14.1 MB
# Any problem you faced while coding this : Initally yes, After class understanding no.
# Your code here along with comments explaining your approach
# Approach
"""
Using Recursive DFS approach in which traversing the tree level by level 
starting from rightmost child and if level and size are same than add the element 
to the stack maintained.

"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution: 
    def rightSideView(self, root: TreeNode) -> List[int]:
        if root is None: 
            return []
        result=[]
        
        
        def traverse(node:TreeNode,level:int)->None:
            if(level==len(result)):
                result.append(node.val)
            for child in [node.right,node.left]:
                if child:
                    traverse(child,level+1)
         
        traverse(root,0)
        return result