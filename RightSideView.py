#Time Complexity : O(n)
#Space Complexity : O(n) - height of the tree
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.result = []
        self.helper(root,0)
        return self.result
    
    def helper(self,root,level):
        
        if root == None:
            return
        if(level >= len(self.result)):
            self.result.append(root.val)
        self.helper(root.right, level+1)
        self.helper(root.left, level+1)
        
