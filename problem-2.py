# Leetcode Execution: YES
# TimeComplexity:O(n)
# Space Complexity:O(n) 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    # we perform a bfs and try to locate x and y we then record their level and teach of their parent and we break as we found the details
    # we then check of the level are same if they are not we return false we then check if the parents are same if they are same we return false else we return True
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        levelx=None
        levely=None
        
        queue=[root]
        level=0
        count=1
        parentx=None
        parenty=None
        while(queue):
            
            while(count>0):
                node=queue.pop(0)
                
                if node.left:
                    queue.append(node.left)
                    if node.left.val==x:
                        levelx=level+1
                        parentx=node
                    if node.left.val==y:
                        levely=level+1
                        parenty=node
                if node.right:
                    queue.append(node.right)
                    if node.right.val==x:
                        levelx=level+1
                        parentx=node
                    if node.right.val==y:
                        levely=level+1
                        parenty=node
                count-=1
                
            count=len(queue)
            level+=1
            if levelx and levely:
                break
        if levelx!=levely:
            return False
        else:
            if parentx==parenty:
                return False
            else:
                return True
                    
        