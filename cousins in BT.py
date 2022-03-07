# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def isCousins(self, root, x: int, y: int) -> bool:
        
        # to track parent and depth
        tracker = {}
        def dfs(node,parent,depth,x,y):
            if not node:
                return 
            
            dfs(node.left,node,depth+1,x,y)
            dfs(node.right,node,depth+1,x,y)
            
            # add a tuple of parent and depth as value to the nodes (key) 
            if node.val in (x,y):
                tracker[node.val] = (parent,depth)
                
        dfs(root,None,0,x,y)
        
        # logic to check for cousins
        cousins = tracker.get(x) and tracker.get(y) and tracker[x][1] == tracker[y][1] and tracker[x][0] != tracker[y][0]
        
        return cousins