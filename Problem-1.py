# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach
def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
    if not root: return []
    right_side_view = []
    
    # BFS through the tree
    q = [root]
    while q:
        new_q = []

        # Every last item in the queue for that level, is for the right-side view
        # Add that to the right_side_view array
        right_side_view.append(q[-1].val)
        
        for cur in q:
            if cur.left: 
                new_q.append(cur.left)
            if cur.right:
                new_q.append(cur.right)
        q = new_q
        
    return right_side_view