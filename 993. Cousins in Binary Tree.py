# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    '''
    - Do a BFS traversal, while adding to queue check if both the
    - childs are the required number, if yes then return False
    - Else True if both numbers matches at same level traversal
    '''
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        queue = collections.deque()
        queue.append(root)
        foundx = False
        foundy = False
        while queue:
            for i in range(len(queue)):
                node = queue.popleft()
                if node.val == x:
                    foundx = True
                if node.val == y:2
                    foundy = True
                if node.left and node.right:
                    if (node.left.val == x and node.right.val == y) or (node.left.val == y and node.right.val == x):
                            return False
                    
                if node.left:    
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            
            if foundx == True and foundy == True:
                return True
            if foundx == True or foundy == True:
                return False