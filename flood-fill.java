//Time complexity:- O(m*n) 
//space complexity:- O(1)
//Did it run on leetcode:- yes.
// what was the problem faced:- got wrong answers or null pointer exception;
//Your code with explanation:- reccursively changing pixel value following given condition and in edge cases thinking to stop reccursion.

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc]==newColor){
            return image;
        }
        int m=image.length;
        int n=image[0].length;
        modifyimage(sr,sc,newColor,image,m,n,image[sr][sc]);
        
    return image;}
    private void modifyimage(int sr,int sc,int newColor,int[][] image,int m,int n,int old){
        if(sr<0||sr>=m||sc<0||sc>=n||image[sr][sc]!=old){
            return;
        }
        image[sr][sc]=newColor;
        modifyimage(sr-1,sc,newColor,image,m,n,old);
        modifyimage(sr,sc-1,newColor,image,m,n,old);
        modifyimage(sr,sc+1,newColor,image,m,n,old);
        modifyimage(sr+1,sc,newColor,image,m,n,old);
        
    }
}