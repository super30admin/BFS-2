// ## Problem1 (https://leetcode.com/problems/cousins-in-binary-tree/)

// Recusrsive

let x_depth=-1;
let y_depth=-1;
let x_parent=null;
let y_parent=null;
let isCousins = function(root, x, y) {
   calDepthAndParent(root,x,y,0,null);
   return x_depth == y_depth && x_parent!=y_parent;
}

function calDepthAndParent(root, x, y, depth, parent){
   if(root==null) return;
   if(root.val==x) {  
       x_parent=parent;
       x_depth=depth;
   }
   if(root.val==y) {
       y_parent=parent;
       y_depth=depth;
   }
   calDepthAndParent(root.left,x,y,depth+1,root);
   calDepthAndParent(root.right,x,y,depth+1,root);
};

// Iterative 

let isCousins = function(root, x, y) {
    if(root==null) return false;
    let q = [];
    q.push(root);
    while(q.length > 0){
        let count = q.length;
        let x_is_found=false;
        let y_is_found=false;
        for(let i=0;i<count;i++){
            let node = q.shift();
            if(node.val==x) x_is_found=true;
            if(node.val==y) y_is_found=true;
            if(node.left!=null && node.right!=null){
                if(node.left.val==x && node.right.val==y) return false;
                if(node.left.val==y && node.right.val==x) return false;
            }
            if(node.left!=null) q.push(node.left);
            if(node.right!=null) q.push(node.right);
        }
        if(x_is_found && y_is_found) return true;
    }
    return false;
 }

// ## Problem2 (https://leetcode.com/problems/rotting-oranges/)

const orangesRotting = function(grid) {
    let q = [];
    let m = grid.length;
    let n = grid[0].length;
    if(m == 0) return 0;
    let fresh = 0;
    for(let i = 0; i <  m; i++){
        for(let j = 0; j < n; j++){
            if(grid[i][j] == 2) q.push([i,j]);
            if(grid[i][j] == 1) fresh++;
        }
    } 
    if(fresh == 0) return 0;
    let dirs = [[0,1], [1,0], [-1,0], [0,-1]];
    let count = 0; 
    while(q.length > 0){
        let size = q.length;
        for(let k = 0; k < size; k++){
            let rotten = q.shift();
            for(let dir of dirs){ 
                let i = dir[0] + rotten[0];
                let j = dir[1] + rotten[1];
                if(i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1){
                    q.push([i,j]);
                    grid[i][j] = 2;
                    fresh--;
                }
            }
        }
        count++;
    }
    if(fresh != 0) return -1;
    return count > 0 ? count - 1: 0;
};

// ## Problem3 : Employee importance (https://leetcode.com/problems/employee-importance/)

let GetImportance = function(employees, id) {
    let map = new Map();
    for(let e of employees){
        map.set(e.id, e);
    }
    return helper(map, id);
 }
 
 function helper (map, id){
    let result = map.get(id).importance;
    for(let sub of map.get(id).subordinates){
        result += helper(map,sub);
    }     
    return result;
 };