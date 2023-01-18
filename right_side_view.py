# Time Complexity :
# O(N)

# Space Complexity :
# O(N), 

# Did this code successfully run on Leetcode :
#Yes

#We do a level order traversal of the tree using BFS (we traverse right side first) and add them to a queue
#Every time we pop an element from the queue, we check if we have reached a new level and if we have, we add it to the return list

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root == None :
            return []
        self.queue = []
        self.return_list = []
        self.queue.append((root,0))
        depth = 0
        prev_depth = -1

        while (len(self.queue) != 0):
            queue_elem = self.queue.pop(0)
            curr_elem = queue_elem[0]
            curr_depth = queue_elem[1]

            if curr_depth != prev_depth :
                self.return_list.append(curr_elem.val)
                prev_depth = curr_depth

            if curr_elem.right != None :
                self.queue.append((curr_elem.right,curr_depth+1))
            if curr_elem.left != None :
                self.queue.append((curr_elem.left,curr_depth+1))

        return self.return_list
