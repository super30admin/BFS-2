#Time complexity : O(n) i.e. n is the number of nodes in the tree
#Space complexity : O(n) i.e. number of nodes added to the queue at each level
#Did this code successfully run on Leetcode : Yes
#youtube : https://www.youtube.com/watch?v=iICZEF2BN24&ab_channel=%7BS30%7D
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        #for the null case
        if root == None:
            return result
        #creating a queue for each level traversal
        queue = deque()
        queue.append(root)
        #till the queue is not empty the while loop will be iterated
        while queue:
            size = len(queue)
            #creating for loop for iterating over all the elements at one level
            for i in range(size):
                current = queue.popleft()
                #checking if the element is the last element at the level then append that element to the result list
                if i == size-1:
                    result.append(current.val)
                #adding the left element of the tree to the queue
                if  current.left != None:
                    queue.append(current.left)
                #adding the right element of the tree to the queue
                if  current.right != None:
                    queue.append(current.right)
        return result
