# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : N/A


# Your code here along with comments explaining your approach
def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        if not root: return False
        
        q = [(root, None)]
        nodes = []
        # BFS through the tree
        while q: 

            n_q = []
            for cur, par in q:
                print(cur.val)
                if cur.val == x:
                    nodes.append((cur, par))
                    
                if cur.val == y:
                    nodes.append((cur, par))
                
                if cur.left: 
                    n_q.append((cur.left, cur))
                if cur.right: 
                    n_q.append((cur.right, cur))
            
            if nodes:
                break
            q = n_q
        
        # If both are found, they're cousins, return True        
        if len(nodes)==2 and nodes[0][1] != nodes[1][1]:
            return True
        
        return False