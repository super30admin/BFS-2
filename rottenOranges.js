// Time Complexity : O(M*N)
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



var orangesRotting = function(grid) {
    if(grid == null || grid.length == 0) return 0;
    let fresh = 0, m = grid.length, n = grid[0].length;

    let q = [];
    for(let  i = 0; i < m; i++){
        for(let j = 0; j < n; j++){
            if(grid[i][j] == 1) fresh++
            if(grid[i][j] == 1){
                q.push([i,j]);

            }
        }
    }

    let time = 0
    if(fresh == 0) return 0
    while(q.length){
        let size = q.length;
        for(let i = 0; i < size; i++){
            let [x, y] = q.shift();
            if (x - 1 >= 0 && grid[x - 1][y] === 1) {
                grid[x - 1][y] = 2;
                fresh--;
                queue.push([x - 1, y]);
              }
              if (x + 1 < height && grid[x + 1][y] === 1) {
                grid[x + 1][y] = 2;
                fresh--;
                queue.push([x + 1, y]);
              }
              if (y - 1 >= 0 && grid[x][y - 1] === 1) {
                grid[x][y - 1] = 2;
                fresh--;
                queue.push([x, y - 1]);
              }
              if (y + 1 < width && grid[x][y + 1] === 1) {
                grid[x][y + 1] = 2;
                fresh--;
                queue.push([x, y + 1]);
              }
        }
        if (queue.length > 0) minute++;
    }
    return fresh === 0 ? minute : -1;
};