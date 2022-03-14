// Time Complexity : O(n) 
// Space Complexity : O(maximum number of levels)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
'''
1. Traverse one level at a time.
2. We need a queque,size variable and result list.
3. As we start with root in queue, size intitially will be 1
4. If size is greater than zero, process(pop) the node and add 
   its children to queue. Decrease the size 
5. when size is zero, the level has been processed. 
   append the node value result list as it is the right most 
   node at that level
'''
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        
        result=[]
        
        if root is None: return result
        
        cq=[]
        cq.append(root)
        size=1
        
        while (len(cq) != 0):
            
                node=cq.pop(0)
                size=size-1
                
                if node.left!= None:
                    cq.append(node.left)
                    
                if node.right!= None:
                    cq.append(node.right)
                    
  
                if size==0:
                    result.append(node.val)
                    size=len(cq)
                
                
        return result
        