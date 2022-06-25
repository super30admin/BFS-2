class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if not root:
            return False
        
        q=deque()
        q.append([root,-1])
        
        while q:
            size=len(q)
            
            parentX,parentY=-1,-1
            
            for i in range(0,size):
                temp=q.popleft()
                
                node=temp[0]
                parent=temp[1]
                
                if node.val==x:
                    parentX=parent
                elif node.val==y:
                    parentY=parent
                    
                if node.left!=None:
                    q.append([node.left,node.val])
                    
                if node.right!=None:
                    q.append([node.right, node.val])
                    
                print(parentX,parentY)
                print(q)
                    
            if (parentX!=-1 and parentY!=-1 and parentX!=parentY):
                return True
            elif parentX != -1 or parentY != -1:
                return False