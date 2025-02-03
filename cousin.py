# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

# TC - O(n) , SC - O(n) -> maximum no of children
class Solution:
    def __init__(self):
        self.x_level=-1
        self.y_level=-1
        self.x_parent = None
        self.y_parent = None
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        # x_found, y_found = False, False
        # queue = deque()
        # queue.append(root)
        # while len(queue)!=0:
        #     size = len(queue)
        #     for i in range(size):
        #         element = queue.popleft()
        #         if element.val == x:
        #             x_found = True
        #         elif element.val == y:
        #             y_found = True   
                
        #         if element.left and element.right:
        #             if (element.left.val == x or element.right.val == x) and (element.left.val == y or element.right.val == y):
        #                 return False

        #         if element.right:
        #             queue.append(element.right)
        #         if element.left:
        #             queue.append(element.left)

        #     if x_found and y_found:
        #         return True
        #     elif x_found and not y_found or not x_found and y_found:
        #         return False

        self.dfs(root,None,0,x,y)
        if self.x_parent!=self.y_parent and self.x_level == self.y_level:
            return True
        else:
            return False    

    def dfs(self, root, parent,depth,x,y):
        if root == None or (self.x_level!=-1 and self.y_level!=-1):
            return 
        if root.val == x:
            self.x_parent = parent
            self.x_level = depth
        if root.val == y:
            self.y_parent = parent
            self.y_level = depth  

        self.dfs(root.left, root, depth+1,x,y)   
        self.dfs(root.right, root, depth+1,x,y)   



                           


        
