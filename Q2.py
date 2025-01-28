############# Cousins in a binary tree

# Time Complexity :  O(n)
# Space Complexity : O(h) where h is height
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# perform dfs and try to find the x and y nodes parents and level. Based on the level return the output.


def check_if_cousins(root,x,y):
        if not root or x==y:
            return False
        
        stack = [(root,None,0)]
        x_parent, y_parent = None, None
        x_level, y_level = -1, -1
        while stack:
            elem, parent, level = stack.pop(0)
            if elem.val == x:
                x_parent = parent
                x_level = level
            elif elem.val == y:
                y_parent = parent
                y_level = level

            if x_parent and y_parent:
                break
            
            if elem.left:
                stack.append((elem.left,elem,level+1))
            if elem.right:
                stack.append((elem.right,elem,level+1))
        
        if x_level == y_level:
            if x_parent.val!=y_parent.val:
                return True

        return False
            
            



