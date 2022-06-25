class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []                
        def helper(root,level,view,visited):
            if not root:
                return
         
            level+=1
            if level not in visited:
                view.append(root.val)
            visited.add(level)

            helper(root.right,level,view,visited)
            helper(root.left,level,view,visited)

            return view
        
        return helper(root,-1,[],set())