# Time Complexity : O(n)
# Space Complexity : O(d) where d is height

# Did this code successfully run on Leetcode : 
# YEs

# Any problem you faced while coding this : 

# Your code here along with comments explaining your approach



class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        level=[]
        result=[]
        queue=[root]
        while queue!=[] and root!=None:
            
        
            for n in queue:
                if n.left:
                    level.append(n.left)
                if n.right:
                    level.append(n.right)
            result.append(n.val)
            queue=level
            level=[]
        return result