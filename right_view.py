class Solution:
            
        
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return []
        
        q = deque([root, None,])
        right= []
        curr = root
        while q:
            prev, curr= curr,q.popleft()
            
            while curr:
                if curr.left:
                    q.append(curr.left)
                    
                if curr.right:
                    q.append(curr.right)
                prev, curr = curr, q.popleft()        
            right.append(prev.val)
            
            if q:
                q.append(None)
                
        return right


    #Time complexity - O(n)  check node only once
    # space complexity -O(2^h)    h is height of the tree 
        