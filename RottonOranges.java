package s30Coding;
import java.util.*;
// Time Complexity :- O(n) where n is the total number of elements in the matrix
// Space Complexity :- O(n) where n is the total number of elements in the matrix

//LeetCode :- yes

public class RottonOranges {
	class ListNode {
	    int x;
	    int y;
	    int count;
	    public ListNode(int x, int y , int count){
	        this.x = x;
	        this.y = y;
	        this.count = count;
	    }
	}
	    
	    public int orangesRotting(int[][] grid) {
	        if(grid == null || grid.length == 0){
	            return -1;
	        }
	        LinkedList<ListNode> list = new LinkedList<ListNode>();
	        int freshOranges = 0;
	        for(int i = 0; i < grid.length ; i++){
	            for( int j = 0; j < grid[0].length; j++){
	                if(grid[i][j] == 2){
	                    ListNode node = new ListNode(i,j,0);
	                    list.add(node);
	                }
	                else if(grid[i][j] == 1){
	                    freshOranges++;
	                }
	            }
	        }
	        ListNode temp;
	        
	        int count = 0;
	        while(!list.isEmpty()){
	            temp = list.removeFirst();
	            if(count != temp.count){
	                count++;
	            }
	            
	            //up
	            if(((temp.x -1) >= 0) && (grid[temp.x -1][temp.y] == 1) ){
	                grid[temp.x -1][temp.y] = 2;
	                ListNode node = new ListNode(temp.x -1, temp.y, count+1);
	                list.add(node);
	                freshOranges--;
	            }
	                
	            //down
	           if(((temp.x +1) < grid.length) && (grid[temp.x +1][temp.y] == 1) ){
	               grid[temp.x +1][temp.y] = 2;
	                ListNode node = new ListNode(temp.x +1,temp.y, count+1);
	                list.add(node);
	                freshOranges--;
	            }
	                
	            //left
	            if(((temp.y - 1) >= 0) && (grid[temp.x][temp.y -1] == 1) ){
	                grid[temp.x][temp.y -1] = 2;
	                ListNode node = new ListNode(temp.x, temp.y-1, count+1);
	                 list.add(node);
	                freshOranges--;
	            }
	                
	            //right
	            if(((temp.y + 1) < grid[0].length) && (grid[temp.x][temp.y + 1] == 1) ){
	                grid[temp.x][temp.y + 1] = 2;
	                ListNode node = new ListNode(temp.x, temp.y+1, count+1);
	                 list.add(node);
	                freshOranges--;
	            }
	            
	        }
	        
	        return freshOranges == 0 ? count : -1;
	        
	        
	    }
}
