#Time Complexity : O(N)), N being the number of nodes in the tree. 
#Space Complexity : O(N), N being the number of nodes in the tree. 
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : Minor debug where I took the ith node in the
# tree rather than the 0th node. 
#Your code here along with comments explaining your approach in three sentences only
'''Using BFS, create a queue where each level is placed into the level. Then, after placing
each level into the queue, take the last element in queue, which would be the right most element.
'''
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        #initialize values. 
        right_result=[]
        if root==None:
            return right_result
        queue=[]
        queue.append(root)
        right_result.append(root.val)
        #parse through the tree and add to queue. Then, return the result. 
        while(len(queue)>0):
            length = len(queue)
            for i in range(length):
                node = queue[0]
                queue.pop(0)
                if node.left!=None:
                    queue.append(node.left)
                if node.right!=None:
                    queue.append(node.right)
            if len(queue)>0:
                right = queue[len(queue)-1]
                right_result.append(right.val)
        return right_result