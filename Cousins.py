# Time Complexity : O(N)
# Space Complexity : O{H)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#Create a dictionary to store the parent and the depth
#in the dfs call pass the node ,parent, x,y and depth and if either x or y = node then store it in the tracker dictionary
#Validate that the 2 nodes are at the same level and do not have the same parent

def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        tracker = {}
        def dfs(node,parent,depth,x,y):
            if not node:
                return

            dfs(node.left,node,depth+1,x,y)
            dfs(node.right,node,depth+1,x,y)

            if node.val in (x,y):
                tracker[node.val] = (parent,depth)


        dfs(root,None,0,x,y)
        cousins = tracker.get(x) and tracker.get(y) and tracker[x][1]==tracker[y][1] and tracker[x][0] != tracker[y][0]

        return cousins