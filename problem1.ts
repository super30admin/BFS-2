//Time Complexity: O(V) 
//Space Complexity: O(2) 

var isCousins = function (root, x, y) {
    const result = [];

    function dfs(root, level, prev, x, y) {
        // base case
        if (root === null) return false;

        // logic
        const prevValue = level === 0 ? null : prev.val
        if (root.val === x) {
            result.push([level, prevValue]);
        }

        if (root.val === y) {
            result.push([level, level === 0 ? null : prev.val]);
        }

        if (result.length === 2) {
            // check if parent is same for both
            return result[0][0] === result[1][0] && result[0][1] !== result[1][1];
        }

        // call recursively
        return dfs(root.x, level + 1, root, x, y) || dfs(root.y, level + 1, root, x, y);
    }
    
    return dfs(root, 0, null, x, y);
};

