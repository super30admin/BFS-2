// Time Complexity : O(n)
// Space Complexity : O(h) -> h is the height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
 * I am using a DFS approach, incrementing the level on every recursive call. Basically, adding all the elements to my result
 * as I see them. Finally overriding them if I encounter a right node on the same level.
 */

class Solution {
    private List<Integer> result = new ArrayList<>();
    
    public List<Integer> rightSideView(TreeNode root) {
        rightSideViewHelper(root,0);
        return result;
    }
    
    private void rightSideViewHelper(TreeNode root,int level){
        
        if(root == null)
            return;
        
        if(result.size() == level)
            result.add(root.val);
        else
            result.set(level,root.val);
        
        rightSideViewHelper(root.left,level+1);
        rightSideViewHelper(root.right,level+1);
        
        
    }
}

//Time Complexity : O(n)
//Space Complexity : O(h) -> h is the height of the tree
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : no


//Your code here along with comments explaining your approach
/*
* I am using a DFS approach, maintained a class structure to hold parent of x,y and levels of x,y. Applied dfs and checked
* for each node if the value becomes equal to x or y. Stored the corresponding parent and level in the parent object.
*/
public boolean isCousins(TreeNode root, int x, int y) {        
    
    Parent p = new Parent(-1,-1,0,0);
    
    isCousinsHelper(root,x,y,-1,p,0);
    
    if(p.x!=p.y && p.x!=-1 && p.y!=-1 && p.xLevel == p.yLevel)
        return true;
    
    return false;
}

public void isCousinsHelper(TreeNode root,int x,int y,int parent,Parent p,int level){
    if(root == null)
        return;
    
    if(root.val == x){
        p.x = parent;
        p.xLevel = level;
        return;
    }
    
    if(root.val == y){
        p.y = parent;
        p.yLevel = level;
        return;
    }
    
    isCousinsHelper(root.left,x,y,root.val,p,level+1);
    isCousinsHelper(root.right,x,y,root.val,p,level+1);
}

class Parent{
    private int x;
    private int y;
    private int xLevel;
    private int yLevel;
    
    public Parent(int x,int y,int xLevel,int yLevel){
        this.x = x;
        this.y = y;
        this.xLevel = xLevel;
        this.yLevel = yLevel;
    }
    
}


