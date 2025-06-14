// ## Problem 2

// Cousins in binary tree (https://leetcode.com/problems/cousins-in-binary-tree/)

var isCousins = function(root, x, y) {

    //Time Comexplity = O(N)
    //Space Comexplity = O(N)

    if(!root)return false
    if(root.val == x || root.val == y)return false

    let queue = [[root,null]] //[child,parent] in a queue
            let parentX = null
            let parentY = null
    while(queue.length){
        let size = queue.length
        parentX = null
        parentY = null
        for(let i=0;i<size;i++){
            let [current,parent] = queue.shift()
            
            if(current.val==x){
                parentX =parent
            }
            if(current.val ==y){
                parentY =parent
            }


            if(current.left){
                //Pushing [next left,current as parent]
                queue.push([current.left,current])
            }
            if(current.right){
                queue.push([current.right,current])

            }
        }
        if(parentX && parentY) {
            if(parentX != parentY) return true
        }        
    }
    return false
};

// function isCousins(root, x, y) {
//     //Time Complexity : O(N)
//     //Space Complexity : O(N) (2N)
//     if (!root) return false;

//     // Check if x and y are immediate children of root (siblings)
//     if (root.left && root.right) {
//         const leftVal = root.left.val;
//         const rightVal = root.right.val;
//         if ((leftVal === x && rightVal === y) ||
//             (leftVal === y && rightVal === x)) {
//             return false; // They are siblings
//         }
//     }

//     let q = [root];
//     let parentQ = [null];
//     let foundX = false, foundY = false;
//     let parentX = null, parentY = null;

//     while (q.length) {
//         let size = q.length;
//         foundX = false;
//         foundY = false;
//         parentX = null;
//         parentY = null;

//         for (let i = 0; i < size; i++) {
//             let current = q.shift();
//             let currentParent = parentQ.shift();

//             if (current.val === x) {
//                 foundX = true;
//                 parentX = currentParent;
//             }
//             if (current.val === y) {
//                 foundY = true;
//                 parentY = currentParent;
//             }

//             if (current.left) {
//                 q.push(current.left);
//                 parentQ.push(current);
//             }
//             if (current.right) {
//                 q.push(current.right);
//                 parentQ.push(current);
//             }
//         }

//         // Check after processing entire level
//         if (foundX && foundY) {
//             return parentX !== parentY; // true if different parents
//         }
//         if (foundX || foundY) {
//             // Only one found at this level - can't be cousins
//             return false;
//         }
//     }

//     return false; // Neither node found
// }