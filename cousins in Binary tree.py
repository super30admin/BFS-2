class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        
        queue=[]
        queue=[root]
        p_queue=[None]
        x_found=False
        y_found=False
        x_parent=None
        y_parent=None

        while queue:
            s=len(queue)
            for i in range(s):
                curr=queue.pop(0)
                parent=p_queue.pop(0)
                if curr.val==x:
                    x_found=True
                    x_parent=parent
                if curr.val==y:
                    y_found=True
                    y_parent=parent
                
                if curr.left:
                    queue.append(curr.left)
                    p_queue.append(curr)
                if curr.right:
                    queue.append(curr.right)
                    p_queue.append(curr)
            if x_found and y_found:
                return x_parent!=y_parent
            if x_found or y_found:
                return False
        
        return False