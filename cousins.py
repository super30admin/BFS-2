def isCousins(self, root, x: int, y: int) -> bool:
        queue = []
        height = 0
        queue.append((root, height))
        
        height_x = -1
        height_y = -1
        
        while queue:
            node, height = queue.pop()
            if node.val == x:
                height_x = height
            
            if node.val == y:
                height_y = height
            if node.left and node.right:
                if (node.left.val == x and node.right.val == y) or (node.left.val == y and node.right.val == x):
                    return False
                
            if node.left:
                queue.append((node.left, height+1))
            
            if node.right:
                queue.append((node.right, height+1))
                
            
            if height_x >= 0 and height_y >=0:

                return height_x == height_y
            
        return False

'''
TC:O(N)
SC:O(N)
'''