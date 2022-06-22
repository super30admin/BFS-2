//Time Complexity: O(V)
//Space Complexity: O(n)
var rightSideView = function(root){
    if(root === null) return [];

    const result = [];
    const queue = [root];

    for(let i=0; i<queue.length;i++){
        result.push(queue[queue.length -1].val);

        for(let j=0;j<queue.length - 1; j++){
            const node = queue.shift();
            if(node.left){
                queue.push(node.left);
            }

            if(node.right){
                queue.push(node.right);
            }
        }
    }

    return result;
}