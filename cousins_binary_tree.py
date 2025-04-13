
'''
Tricky, but I found the logic of comparing, if the childern belonging to the same parent, is easy compared to other ways of solving the problem.
if((curr_root.left.val ==x and curr_root.right.val == y) or (curr_root.left.val == y and curr_root.right.val ==x)): is not very intuitive, as you have to repeat the logic two times.

TC: O(n) --> as we go through all the elements of the array
SC: O(n) --> To maintain the queue.

'''
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:


        queue = deque()

        queue.append(root)

        x_found = False
        y_found = False

        while(queue):

            k = len(queue)

            for i in range(k):

                curr_root = queue.popleft()

                if curr_root.left and curr_root.right:

                    if((curr_root.left.val ==x and curr_root.right.val == y) or (curr_root.left.val == y and curr_root.right.val ==x)):
                        return False

                if curr_root.left:
                    queue.append(curr_root.left)

                if curr_root.right:
                    queue.append(curr_root.right)

                if curr_root.val ==x:
                    x_found = True

                if curr_root.val == y:
                    y_found = True

            if ((x_found == True and y_found==False)  or (y_found == True and x_found ==False)):
                return False


        return True
