#Time Complexity :o(n)
# Space Complexity :o(h)
# Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no , Here I used DFS approach.

class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        queue = collections.deque()
        queue.append((root,0))
        dist={}
        while queue:
            node,depth = queue.popleft()
            if node.left:
                dist[node.left.val]=(node.val,depth+1)
                queue.append((node.left,depth+1))
            if node.right:
                dist[node.right.val]=(node.val,depth+1)
                queue.append((node.right,depth+1))
        if x not in dist or y not in dist: return False
        x_parent,x_depth = dist[x]
        y_parent,y_depth = dist[y]
        return x_depth == y_depth and x_parent != y_parent