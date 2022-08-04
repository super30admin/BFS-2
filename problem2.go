// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//DFS
var x_depth int
var y_depth int
var x_parent *TreeNode
var y_parent *TreeNode

func isCousins(root *TreeNode, x int, y int) bool {
    if root == nil{
        return false
    }
    
    x_parent = nil
    y_parent = nil
    
    helper(root,0,nil,x,y)
    
    if x_depth == y_depth && x_parent != y_parent{
        return true
    }
    
    return false
}

func helper(root *TreeNode,level int , parent *TreeNode,x,y int){
    if root == nil{
        return
    }
    
    if root.Val == x {
        x_depth = level
        x_parent = parent
    }
    
    if root.Val == y {
        y_depth = level
        y_parent = parent
    }
    
    if x_parent == nil || y_parent == nil{   //this is optimization. We can simple call the helper without checking null
         helper(root.Left,level+1,root,x,y)
    }
   
    if x_parent == nil || y_parent == nil{   //this is optimization. We can simple call the helper without checking null
         helper(root.Right,level+1,root,x,y)
    }
    
}


//BFS
func isCousins(root *TreeNode, x int, y int) bool {
    if root == nil{
        return false
    }
     
    q := []*TreeNode{}
    q = append(q,root)
    x_found := false
    y_found := false
    
    var x_parent *TreeNode = nil
    var y_parent *TreeNode = nil
    
    for len(q) > 0{
        size := len(q)
        x_found = false
        y_found = false
        for i:=0;i<size;i++{
            curr := q[0]
            q = q[1:]
            
            
            if curr.Left != nil{
                if curr.Left.Val == x{
                    x_found = true
                    x_parent = curr
                }
                
                if curr.Left.Val == y{
                    y_found = true
                    y_parent = curr
                }
                
                q = append(q,curr.Left)
            }
            
            if curr.Right != nil{
                if curr.Right.Val == x{
                    x_found = true
                    x_parent = curr
                }
                
                if curr.Right.Val == y{
                    y_found = true
                    y_parent = curr
                }
                q = append(q,curr.Right)
            }
            
        }
        
        if (x_found == true && y_found == true) && (x_parent != y_parent){
            return true
        }
    }
            
    
    return false
}
