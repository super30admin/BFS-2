Problem-1: Cousins in Binary tree
TC = O(n) where n is the number of nodes in the tree
SC= O(max width of the tree)
// BFS- Iterative solution using queue
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty()){
            int size=q.size();
            boolean x_found=false, y_found=false;
            
            for( int i=0; i < size; i++){
                 root = q.poll();
                
                if(root.val == x)x_found=true;
                if(root.val == y)y_found=true;
                
                if( root.left != null && root.right != null){
                    if(root.left.val == x && root.right.val == y) return false;
                    if(root.left.val == y && root.right.val == x) return false;
                }
                if(root.left != null) q.add(root.left);
                if(root.right != null) q.add(root.right);
                
            }
            if(x_found && y_found) return true;
        }
        return false;

    }
}
Problem-1: Cousins in Binary tree
TC = O(n) where n is the number of nodes in the tree
SC= O(h) where h is the height of the tree
// DFS- recursive using recursion stack
class Solution {
    int x_level, y_level;
    TreeNode y_parent, x_parent;
    public boolean isCousins(TreeNode root, int x, int y) {
        
        helper(root, x, y, 0, null);
        
        return x_level == y_level && x_parent != y_parent;
    }
    
    private void helper(TreeNode root,int x,int y, int level, TreeNode parent){
        //base
        if(root == null) return;
        
        //logic
        if(root.val == x){
            x_level=level;
            x_parent=parent;
        }
        if(root.val == y){
            y_level=level;
            y_parent=parent;
        }
        helper(root.left, x, y, level+1, root);
        helper(root.right, x, y, level+1, root);
        
        
        
    }
}

Problem-2:
TC = O(m*n) where m is rows and n is columns
SC= O 4+(min of(m and n)
// BFS- iterative using Queue
class Solution {
    public int orangesRotting(int[][] grid) {
        
        if(grid == null || grid.length==0) return 0;
        
        Queue<int []> q = new LinkedList<>();
        int fresh = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2) q.add(new int[]{i,j});
                if(grid[i][j] == 1) fresh++;
            }
        }
        if(fresh == 0) return 0;
        int time=0;
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0; i< size; i++){
                int[] cur = q.poll();   
                for(int[]dir: dirs){
                    int r = cur[0]+dir[0];
                    int c = cur[1]+dir[1];

                    if(r >=0 && r < grid.length && c >=0 && c < grid[0].length && grid[r][c] ==1){
                        grid[r][c]=2;
                        q.add(new int[]{r,c});
                        fresh--;
                    }
                }
            }
            time++;
        }
        
        System.out.println(time);
        
        return fresh == 0? time-1: -1;
    }
}
Problem-3: Employee Importance
TC = O(v+E) where v is the verices (employee) and E is edges(Subordinates)
SC= O(v+E)
// Iterative BFS solution
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        
        HashMap<Integer, Employee> map = new HashMap<>();
        
        for(Employee emp: employees){
            map.put(emp.id, emp);
        }
        
        Employee cur = map.get(id);
        
        Queue<Integer> q = new LinkedList<>();
        
        List<Integer> subs = cur.subordinates;
        
        for(int sub: subs){
            q.add(sub);
        }
        int repo = cur.importance;
        while(!q.isEmpty()){
           
            int curSub = q.poll(); //2
            
            Employee sub = map.get(curSub);
            if(sub != null){
                List<Integer> sbs = sub.subordinates;
                repo+= sub.importance;
                for(int sb: sbs){
                    q.add(sb);
                }     
            }
        }
        
        return repo;
        
    }
}
Problem-3: Employee Importance
TC = O(v+E) where v is the verices (employee) and E is edges(Subordinates)
SC= O(h) stack space

// recursive- dfs
class Solution {
    HashMap<Integer, Employee> map;
    int repo=0;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap<>();
        
        for(Employee emp: employees){
            map.put(emp.id, emp);
        }
        helper(id);
        return repo;
    }
    
    private void helper(Integer id){
        
        
        Employee curSub = map.get(id);
        repo+= curSub.importance;
    
        for(int sub: curSub.subordinates){
            helper(sub);
        }
        
    }
}
