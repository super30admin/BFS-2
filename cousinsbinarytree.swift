// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
   // Take the each row from the matrix , since the elements of the each row are in sorted order so check if the target element is present in row or not by comparing it with last element in the row, it the target is less than last element in the row then apply binary search in that row.   

    func isCousins(_ root: TreeNode?, _ x: Int, _ y: Int) -> Bool {
       if root == nil {
           return true
       } 
       var queue = [(TreeNode?,Int?)]()
        queue.append((root,root?.val))
        
        while !queue.isEmpty {
            var size = queue.count
            var parentX = -1
            var parentY = -1
            
            for i in 0..<size {
                var (node,parent) = queue.removeFirst()
                if node?.val == x {
                    parentX = parent!
                } else if node?.val == y {
                    parentY = parent!
                }
                if node?.left != nil {
                    queue.append((node?.left,node?.val))
                    
                }
                if node?.right != nil {
                    queue.append((node?.right,node?.val))
                    
                }
                
            }
            if parentX != -1 && parentY != -1 && parentX != parentY {
                return true
            }
            else if ((parentX == -1 && parentY != -1) || (parentX != -1 && parentY == -1)) {
                return false
            }
            
        } 
        return false
    }
