// # BFS-2
// ## Problem 1
// Binary Tree Right Side View (https://leetcode.com/problems/binary-tree-right-side-view/)

// var rightSideView = function(root) {
//     if(!root)return []
//     let res = []
//     let queue = [root]
//     while(queue.length){
//         let size = queue.length
//         for(let i=0;i<size;i++){
//             let current = queue.shift()
//             if(i==size-1) res.push(current.val)
//             if(current.left) queue.push(current.left)
//             if(current.right) queue.push(current.right)
//         }   
//     }
//     return res
// };

var rightSideView = function(root) {
    if(!root) return []
            //Time Complexity : O(N)
    //Space Complexity : O(N)
    let res = []
    function helper(root,level){
        if(!root)return 
        if(res[level]){
            //do nothing because ele at that level already in the ans
        }
        if(res.length == level){
            res.push(root.val)
        }
        helper(root.right,level+1)
        helper(root.left,level+1)
    }
    helper(root,0)
    return res
};