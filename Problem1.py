"""
199. Binary Tree Right Side View
Time Complexity - O(n)
Space Complexity - O(breadth of tree)
Append root value top value to queue.Until queue is empty run loop.Calculate size of queue that indicates the level of tree.Run for loop until size of queue and append last element of that level to output and push left and right nodes of root in queue.
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        output = []
        if root == None:
            return output
        queue = []
        queue.append(root)
        while(queue):
            size = len(queue)
            for i in range(size):
                front = queue.pop(0)
                if i == size-1:
                    output.append(front.val)
                    
                if front.left != None:
                    queue.append(front.left)
                if front.right != None:
                    queue.append(front.right)
                
        return output
                    
                
        