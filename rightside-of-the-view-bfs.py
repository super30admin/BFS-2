#Time Complexity O(n)
#Space Complexity O(h)

from queue import Queue 
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        if root == None: return result
        q = Queue()
        q.put(root)

        while not q.empty():
            size = q.qsize()
            # processing of level
            for i in range(size):
                curr = q.get()
                if i == size-1:
                    result.append(curr.val)
                if curr.left != None:
                    q.put(curr.left)
                if curr.right != None:
                    q.put(curr.right)
        return result

