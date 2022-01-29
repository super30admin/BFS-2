# Definition for a binary tree node.
# SC : O(N) - N number of nodes
# TC : O(N) 

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

from typing import Optional
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        def parent_of_node(node, x):
            st = []
            #print("in for ", x)
            if node:
                st.append([node,0])
            if node.val == x:
                return [TreeNode(-1),-1]
            
            while st:
                parent, height = st.pop(0)
                if parent.left:
                    if parent.left.val == x:
                        return [parent,height] 
                    st.append([parent.left, height + 1])
                if parent.right:
                    if parent.right.val == x:
                        return [parent,height] 
                    st.append([parent.right, height + 1])
                    
            
            return [-1, -1] 
        
        p_x , h_x = parent_of_node(root, x)
        p_y , h_y = parent_of_node(root, y)
        
        print(p_x,h_x)
        print(p_y,h_y)
        if p_x.val != p_y.val and h_x == h_y:
            return True
        
        return False
        
        
            
        