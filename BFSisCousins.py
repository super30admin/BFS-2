#Time complexity : O(n) i.e. n is the number of nodes in the tree
#Space complexity : O(n) i.e. number of nodes added to the queue at each level and at the last level number of nodes might get to N/2
#Did this code successfully run on Leetcode : Yes
#youtube : https://www.youtube.com/watch?v=iICZEF2BN24&ab_channel=%7BS30%7DD
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        #taking two flags for element are same 
        x_flag, y_flag = False, False
        #null conditions
        if root == None:
            return False
        queue = collections.deque()
        queue.append(root)
        while queue:
            size = len(queue)
            #for loop will for all the element in queue at particular level
            for i in range(size):
                current = queue.popleft()
                #if we find the current node value as x then we will mark the boolean variable xflag as true
                if current.val == x:
                    x_flag = True
                #if we find the current node value as y then we will mark the boolean variable yflag as true
                if current.val == y:
                    y_flag = True
                #parent check of the x and y node
                #they can't be from one parent if there is only one child present either left or right
                if current.left != None and current.right != None:
                    #if the parent is same for x and y then we will return no cousin
                    if current.left.val == x and current.right.val == y:
                        return False
                    if current.left.val == y and current.right.val == x:
                        return False
                #checking the right and left children are not None if not then append them to the queue
                if current.left != None:
                    queue.append(current.left)
                if current.right != None:
                    queue.append(current.right)
            #once the level is complete it will check if the x_flag and f_flag both are found in same level if yes then it will return true else if either of one is found one level then it will return false
            if x_flag and y_flag:
                return True
            if x_flag or y_flag:
                return False
        return False
            
