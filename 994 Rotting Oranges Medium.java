//994 Rotting Oranges Medium.java

//Time Complexity:O(n*m)
//Space Complexity:O(1)
class Solution {
    
    //creating globalgird so all function can access it and modify it
    int[][] globalgrid;
    public int orangesRotting(int[][] grid) {
        
        globalgrid = grid;
        
        int counter = 0;
        int freshCount = 0;
        for(int i = 0; i < globalgrid.length; ++i){
            for(int j = 0; j < globalgrid[0].length; ++j){
                
                int currentItem = globalgrid[i][j];
                if(currentItem == 1)
                    freshCount++;
            }   
            
        }
        if(freshCount == 0)
            return 0;
        while(true){
            
            int response = processMinute();      
            //case 1: no fresh oranges left
            //response will be -2
            counter++;
            if( response == -2){
                return counter;
            }
            //case 2: can not make any changes and there is fresh orange
            // changes == 0 return -1
            if( response == 0){
                return -1;
            }
                    
        }
        
    }
    public int processMinute(){
        int changes = 0;
        //go through all the elements
        for(int i = 0; i < globalgrid.length; ++i){
            for(int j = 0; j < globalgrid[0].length; ++j){
                
                int currentItem = globalgrid[i][j];
                if(currentItem == 2){
                    
                    changes += makeRotten(i,j+1);
                    changes += makeRotten(i,j-1);
                    changes += makeRotten(i+1,j);
                    changes += makeRotten(i-1,j);
                }
            }   
            
        }
        int freshCount = 0;
        //make all 3 ==> 2
        for(int i = 0; i < globalgrid.length; ++i){
            for(int j = 0; j < globalgrid[0].length; ++j){
                
                int currentItem = globalgrid[i][j];
                if(currentItem == 3){
                    globalgrid[i][j] = 2;
                }
                if(currentItem == 1)
                    freshCount++;
            }   
            
        }
        if(freshCount == 0)
        {
            //no fresh oranges left
            return -2;
        }
        return changes;
        
    }
    public int makeRotten(int i,int j){
        
        //check if i, j are in grid range
        if(i < 0 || i >= globalgrid.length || j < 0 || j >= globalgrid[0].length)
            return 0;
        //if was fresh then make it rotten
        if(globalgrid[i][j] == 1)
        {
    
            globalgrid[i][j] = 3;
            return 1;
        }
        return 0;
    }
}