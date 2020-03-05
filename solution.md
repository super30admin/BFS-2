# Problem 1
## Time Complexity :
O(n)

## Space Complexity :
O(1)

## Did this code successfully run on Leetcode :
No. 81/103 testcases passed.

## Any problem you faced while coding this :
Yes. I could not identify my mistake.

## Your code here along with comments explaining your approach
### Solution 1: BFS.
        import queue
        class Solution:
            def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
                #Edge Case
                if not root:
                    return False
                q=queue.Queue()
                q.put(root)     #Adding root to queue
                #Checking condition
                while not q.empty():
                    x_found,y_found=False, False
                    for i in range(q.qsize()):
                        node=q.get()    #Getting first value in queue
                        if(node.val==x):
                            x_found=True
                        if(node.val==y):
                            y_found=True
                        if (node.left!=None and node.right!=None):
                            if(node.left.val==x and node.right.val==y):
                                return False
                            if(node.left.val==y and node.right.val==x):
                                return False
                    if node.left:
                        q.put(node.left)
                    if node.right:
                        q.put(node.right)
                if(x_found and y_found):
                    return True
                if(x_found or y_found):
                    return False
                return False
