'''
In this problem we need to find whether if 2 elements are cousins or not.
For two elements to be cousins they have to be on the same level and should not be children of same parent.
Here I maintained 2 variables initially set to False to check if the elements exist on the level or not, and while inserting in the queue checking if both the elements share smae parent or not.
if both the variables are true then the elements are cousins.
'''
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        q = deque()
        q.append(root)
        x_found = False
        y_found = False

        while q:
            size = len(q)
            for _ in range(size):
                # popping out one node from queue
                curr = q.popleft()

                if curr.left is not None and curr.right is not None:
                    # checking if both the elements belong to same parent node
                    if curr.left.val == x and curr.right.val == y:
                        return False
                    if curr.right.val == x and curr.left.val == y:
                        return False
                
                # updating the variables if the values are found
                if curr.val == x:
                    x_found = True
                if curr.val == y:
                    y_found = True
                
                # adding the elemnts to queue
                if curr.left is not None:
                    q.append(curr.left)
                if curr.right is not None:
                    q.append(curr.right)
            # return true only if both of them belong to same level
            if x_found and y_found:
                return True
            if x_found or y_found:
                return False
                
        return True

'''
Time complexity: O(n)
we iterate through n nodes once, so time taken is O(n)
Space Complexity: O(n)
Space taken by the queue with n nodes is O(n)
'''