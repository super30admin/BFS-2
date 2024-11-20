# Definition for a binary tree node.

"""

    Student : Shahreen Shahjahan Psyche
    Time : O(N)
    Space : O(H)

    This code ran successfully for all the test cases in Leetcode


"""

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution: 
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        
        from collections import deque
        
        # maintaining a queue to save my nodes and as I want to go level by level, I need to pop the elements in FIFO manner. Thats
        # why I am taking an queue
        records = deque()
        records.append(root)
        # initilizing 2 tuples for saving both x and y's level and their parent value
        x_parent_val = (-1, -1)
        y_parent_val = (-1, -1)
        level = 0
       
        while(records):
            size = len(records)
            i = 0
            while(i<size):
                element = records.popleft()
                # checking whether left or right childeren is empty. If not I am adding them inside the queue
                if element.left:
                    records.append(element.left)
                    # if the left or right child is x or y, then saving the information in their
                    # corrosponding tuples
                    if element.left.val == x:
                        x_parent_val = (level + 1, element.val)
                    elif element.left.val == y:
                        y_parent_val = (level + 1, element.val)
                        
                if element.right:
                    records.append(element.right)
                    # if the left or right child is x or y, then saving the information in their
                    # corrosponding tuples
                    if element.right.val == x:
                        x_parent_val = (level+1, element.val)
                    elif element.right.val == y:
                        y_parent_val = (level+1, element.val)
                i += 1
            # At any point, if I find that x information or y information has changed then
            # I am checking the constraints and returning the result
            if x_parent_val[0] != -1 or y_parent_val[0] != -1:
                if x_parent_val[0] == y_parent_val[0] and x_parent_val[1] != y_parent_val[1]:
                    return True
                else:
                    return False
                
            level += 1
        
        return False
