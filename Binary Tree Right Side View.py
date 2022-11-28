# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

from queue import Queue

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        
        
        # BFS
        if not root:
            return None
        q = Queue()
        q.put(root)
        
        right_array = []
        
        while not q.empty():
            size = q.qsize()
            for i in range(size):
                a = q.get()
                if i == size - 1:
                    right_array.append(a.val)
                    
                if a.left:
                    q.put(a.left)
                if a.right:
                    q.put(a.right)
            
        return right_array
        
        # DFS
        if not root:
            return []
        self.right_array = []
        
        def getRightElements(root, level):
            if not root:
                return
            if len(self.right_array) == level:
                self.right_array.append(root.val)
            
            getRightElements(root.right, level + 1)
            getRightElements(root.left, level + 1)

        getRightElements(root, 0)
        return self.right_array
