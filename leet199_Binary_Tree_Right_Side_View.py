# Solution

# // Time Complexity : BFS - O(N) since we are traversing all the nodes
#                      DFS - O(N) since we are traversing all the nodes
# // Space Complexity : BFS - O(N) it is actually O(N/2) since in worst case, the balanced binary tree will have n/2 leaf nodes
#                       and we are using a stack to keep the nodes of each level to be processed next
#                       DFS - O(N) since implicit stack in DFS will need space and in worst case we can have skewed binary tree
#                       where all the nodes are skewed to right or left
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# Approach is to use BFS or DFS to traverse the entire binary tree and hold on to the right most node values for the results

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


def buildLinkedList(index,n):
    if index >= n:
        return None
    
    if ar[index] == None:
        return None
    return TreeNode(ar[index],buildLinkedList(index*2 + 1,n),buildLinkedList(index*2 + 2,n))

def rightSideView(root):
        # DFS
        def helper(node,level,result):
            if node == None:
                return
            if len(result) == level:
                result.append(node.val)   
            
            helper(node.right,level+1,result)
            helper(node.left,level+1,result)

        if root == None:
            return []
        
        result = []
        helper(root,0,result)
        return result
        
        # BFS
        # if root == None:
        #     return []
        # result = []
        # nodeQueue = deque()

        # nodeQueue.append(root)
        # prevCount = 1

        # while nodeQueue:
        #     curCount = 0
        #     while prevCount > 0:
        #         node = nodeQueue.popleft()
        #         prevCount -= 1

        #         if node.left != None:
        #             nodeQueue.append(node.left)
        #             curCount += 1
                
        #         if node.right != None:
        #             nodeQueue.append(node.right)
        #             curCount += 1
                
        #         if prevCount == 0:
        #             result.append(node.val)
                
        #     prevCount = curCount
        
        # return result

if __name__ == "__main__":
    ar = [1,2,3,None,5,None,4]
    n = len(ar)
    root = TreeNode(ar[0],buildLinkedList(1,n),buildLinkedList(2,n))

    print(rightSideView(root))