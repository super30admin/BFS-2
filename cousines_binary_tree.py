# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    '''
    Time Complexity: O(n) 
    Space Complexity: O(n)
    '''
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        # essentially you want to find out if the parents are different and if they are same level
        
        # use a queue and also go through via BFS
        queue = collections.deque([root])
        
        while queue:
            siblings = False
            cousins = False
            num_nodes = len(queue)
            
            for _ in range(num_nodes):
                
                node = queue.popleft()
                
                if node is None:
                    siblings = False
                else:
                    if node.val == x or node.val == y:
                        if not cousins:
                            siblings, cousins = True, True
                        else:
                            return not siblings
                    queue.append(node.left) if node.left else None
                    queue.append(node.right) if node.right else None
                    queue.append(None)
            
            if cousins:
                return False
        return False