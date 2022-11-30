# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

'''
Time Complexity -->
O(n)

Space Complexity -->
O(n)
'''
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        parent_x = None
        parent_y = None
        level_x = 0
        level_y = 0
        q = [root]
        value = 0
        while q:
            l = len(q)
            
            for i in range(l):
                s = q.pop(0)
                #print(s.val)
                if parent_x and parent_y:
                    q = []
                    break
                
                # if s.left and s.right:
                #     if s.left ==x and s.right ==y or s.left == y and s.right == x:
                #         return False
                
                if s.left:
                    if s.left.val==x:
                        level_x = value
                        parent_x = s
                        
                    if s.left.val == y:
                        level_y = value
                        parent_y = s
                    q.append(s.left)
                
                if s.right:
                    if s.right.val==x:
                        
                        level_x = value
                        parent_x = s
                        #print('Yes')
                    if s.right.val ==y:
                        level_y = value
                        parent_y = s
                        #print('Yes')
                    q.append(s.right)
            #print(q)
            value+=1
        
        #print(value)
        if parent_x==None or parent_y==None:
            return False
        if parent_x == parent_y:
            return False
        elif level_x!=level_y:
            return False
        else:
            return True
                
                    
                
                
                        
                
            
        
        