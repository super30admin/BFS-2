// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
       
        Queue<TreeNode> q= new LinkedList();
        q.add(root);
        while(!q.isEmpty())
        {
             boolean fx=false;
             boolean fy=false;
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode n=q.poll();
                if(n==null)
                {
                    
                }
                else
                {
                if(n.left!=null&&n.right!=null)
                {if(n.left.val==x&&n.right.val==y)
                    return false;
                if(n.left.val==y&&n.right.val==x)
                    return false;
                }
                if(n.val==x)
                    fx=true;
                else if(n.val==y)
                    fy=true;
                if(fx==true&&fy==true)
                    return true;
                if(n.left!=null)
                q.add(n.left);
                if(n.right!=null)
                q.add(n.right);
                }
            }
        }
        return false;
    }
}
-----------------------------------------------------------------------------------------------------------------
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh=0;
        if(grid==null || grid.length==0) return 0;
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                    fresh++;
                if(grid[i][j]==2)  
                    q.add(new int[]{i,j});
            }
        }
        int time=0;
        int[][] dirs={{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                int[] rotten=q.poll();
                for(int[] dir:dirs)
                {
                    int r=rotten[0]+dir[0];
                    int c=rotten[1]+dir[1];
                    if(r>=0 && r<m && c>=0 && c<n && grid[r][c]==1)
                    {
                        grid[r][c]=2;
                        q.add(new int[]{r,c});
                        fresh--;
                    }
                }
                
            }
            time++;
        }
        if(fresh>0) return -1;
        return time>0 ? time-1 : 0;
    }
}
---------------------------------------------------------------------------------------------------------------------------------
// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    Map<Integer,Employee> emap;
    public int getImportance(List<Employee> employees, int id) {
        emap= new HashMap();
        for(Employee e: employees)
        {
            emap.put(e.id,e);
        }
        return dfs(id);
    }
    
    public int dfs(int eid)
    {
        Employee emp=emap.get(eid);
        int ans=emp.importance;
        for(Integer esubs:emp.subordinates)
            ans+=dfs(esubs);
    
        return ans;
        }
}
---------------------------
