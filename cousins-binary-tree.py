'''
https://leetcode.com/problems/cousins-in-binary-tree

Did it run leetcode: Yes
Did you face anyproblem: Handling null values at each level

Time Compexity: 0(N)
Space Compelexity: 0(maxNodesAtASingleLevel)

Algorithm:
- make a bfs traversal starting from the root
- when you add new nodes to the queue create a map called parentMap where
    key=node
    value=parent
- after discovering all nodes at each level check whether you found the nodes which have value
equal to x,equal to y and their parent are not same.



'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """
        queue = [root]
        return self.bfsTraversal(queue,x,y)
    
    def bfsTraversal(self,level,x,y):
        if not level or len(level)==0:
            return False
        
        queue = []
        parentMap = {}
        xFound,yFound=None,None
        for node in level:
            left,right = node.left,node.right
            if left:
                queue.append(left)
                parentMap[left] = node
                if left.val==x:
                    xFound=left
                elif left.val==y:
                    yFound=left
                
            if right:
                queue.append(right)
                parentMap[right] = node
                if right.val==x:
                    xFound=right
                elif right.val==y:
                    yFound=right
        
        if xFound and yFound and parentMap[xFound]!=parentMap[yFound]:
            return True
        else:
            return self.bfsTraversal(queue,x,y)
        