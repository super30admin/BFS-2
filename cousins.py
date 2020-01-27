"""
Time: O(n)
Space: O(n)
Leet : Accepted
Problems: None
"""

class Solution(object):
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        queue = [(root,0,0)] #node,level,parent
        d = {} #use dict to store level and parent of each node
        while queue:
            #BFS where we add details of all nodes to dict
            node = queue.pop(0)
            val = node[0].val
            level = node[1]
            parent = node[2]
            d[val] = [level,parent]

            if node[0].left:
                queue.append((node[0].left,level+1,val))
            if node[0].right:
                queue.append((node[0].right,level+1,val))

        if x not in d or y not in d:
            return False

        return d[x][0]==d[y][0] and d[x][1]!=d[y][1] #check cousin condition
