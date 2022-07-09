# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    
    def __init__(self):
        self.x_parent=TreeNode()
        self.y_parent=TreeNode()
        self.xht=0
        self.yht=0
    '''   
    #DFS Time Complexity: O(n) Space Complexity:O(n)
    def dfs(self, root, x, y, level, parent):
        if not root:
            return
        if root.val == x:
            self.x_parent=parent
            self.xht=level
        if root.val == y:
            self.y_parent=parent
            self.yht=level
        
        self.dfs(root.left, x, y, level+1, root)  
        self.dfs(root.right, x, y, level+1, root)'''
        
    def isCousins(self, root, x, y):
        """
        :type root: TreeNode
        :type x: int
        :type y: int
        :rtype: bool
        """

        if not root:
            return False
        '''
        #DFS
        self.dfs(root, x, y, 0, None)
        return self.x_parent!=self.y_parent and self.xht==self.yht'''
        
        #BFS
        '''Time Complexity: O(n)
        Space Complexity: O(h)'''
        
        queue=deque([root])
        while len(queue) != 0:
            size=len(queue)
            xFlag=False
            yFlag=False
            for i in range(size):
                curr=queue.popleft()
                #Check for node
                if curr.val == x :
                    xFlag=True
                if curr.val == y :
                    yFlag=True
                #Before it into the queue compare the children
                if curr.left is not None and curr.right is not None:
                    if (curr.left.val == x and curr.right.val == y) or (curr.left.val == y and curr.right.val == x) :
                        return False
                if curr.left is not None:
                    queue.append(curr.left)
                if curr.right is not None:
                    queue.append(curr.right)
            if xFlag and yFlag:
                return True
            if xFlag or yFlag:
                return False
        
