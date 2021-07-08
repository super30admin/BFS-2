// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {number[][]} grid
 * @return {number}
 */
var orangesRotting = function(grid) {
    if (grid == null || grid.length == 0) return 0;
    
    let m = grid.length,
        n = grid[0].length,
        q = [],
        fresh = 0,
        time = 0,
        dirs = [[0,1],[0,-1],[1,0],[-1,0]];
    
    for (let i = 0; i < m; i++) {
        for (let j = 0; j < n; j++) {
            if (grid[i][j] == 1) fresh++;
            if (grid[i][j] == 2) q.push([i, j]);
        }
    }
    if (fresh == 0) return 0;
    while (q.length) {
        let size = q.length;
        for (let i = 0; i < size; i++) {
            let curr = q.shift();
            for (const dir of dirs) {
                let r = dir[0] + curr[0],
                    c = dir[1] + curr[1];
                if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1) {
                    grid[r][c] = 2;
                    fresh--;
                    q.push([r, c]);
                }
            }
        }
        time++;
    }
    if (fresh > 0) return -1;
    return time > 0 ? time - 1 : 0;
};
