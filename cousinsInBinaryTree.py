#TimeComplexity:O(N) 
#SpaceComplexity: O(diameter)
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        queue=[root]
        output=[]
        while queue:
            queue1=[]
            for i in queue:
                if i.left: 
                    queue1.append(i.left)
                    if i.left.val==x or i.left.val==y: #compare if the given value is same and store the value along with parent
                        output.append((i.left.val,i.val))
                if i.right:
                    queue1.append(i.right)
                    if i.right.val==x or i.right.val==y:
                        output.append((i.right.val,i.val))  
                queue=queue1
            if output!=[] and len(output)!=2:
                return False
            if output!=[]:
                if output[0][1]!=output[1][1]:
                    return True
                else:
                    return False

                
        