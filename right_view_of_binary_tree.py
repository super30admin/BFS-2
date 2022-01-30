class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        level = []
        final_r = []
        if root:
            result.append(root)
        while result:
            level = []
            for i in range(len(result)):
                curr = result.pop(0)
                level.append(curr.val)
                if curr.left:
                    result.append(curr.left)
                if curr.right:
                    result.append(curr.right)
            final_r.append(level)
        level = []
        for i in final_r:
            level.append(i[-1])
        return level
        
    
