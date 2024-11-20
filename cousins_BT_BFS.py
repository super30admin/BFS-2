# Time Complexity : Add - O(N)
# Space Complexity :O(2^h), h being the height of tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. I have used used BFS to check if x and y have been found in at same level without belonging to same parent

'''

def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        
    if root is None:
        return True
    
    queue = deque()
    queue.append(root)
    xFound = False
    yFound = False
    
    while queue:
        
        size = len(queue)
        
        while size > 0:
            root = queue.popleft()
            print (root.val)
            
            if (root.val == x):
                xFound = True
                # print ("xFounf")
                
            elif (root.val == y):
                yFound = True
                # print ("yFounf")
                
            
            if root.left and root.right and (((x==root.left.val) and (y==root.right.val)) or ((x==root.right.val) and (y==root.left.val))):
                return False
            
            if root.left:
                queue.append(root.left)

            if root.right:
                queue.append(root.right)
            
            size -= 1
            
        if xFound and yFound:
            return True
        
        xFound = False
        yFound = False
            
    return False