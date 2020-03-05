// Time Complexity :o(N) 
// Space Complexity :O(2N) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//
class MinStack {
   
    /** initialize your data structure here. */
   
    
     public MinStack() {
       
     }
      Stack<Integer> stack=new Stack<>();
    int min =Integer.MAX_VALUE;
    public void push(int x) {
     
        if(min >= x){
            stack.push(min);
            min =x;
            
        }
             stack.push(x);
            
    }
    
    public void pop() {
        int pop=stack.pop();
        if(pop==min){
            min=stack.pop();
        }
       
    }
    
    public int top() {
     return stack.peek();
    }
    
    public int getMin() {
   return min;
    }
}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//SOLUTION WITH TWO STACKS
//   private Stack<Integer> stack1=new Stack<>();
//        private Stack<Integer> minstack=new Stack<>();  
    
//      public MinStack() {}
    
//     public void push(int x) {
        
//        stack1.push(x);
   
//         if(minstack.isEmpty() || x <= minstack.peek()){
//            minstack.push(x); 
//         }
       
//     }
    
//     public void pop() {
//         if (stack1.peek().equals(minstack.peek())) {
//             minstack.pop();
//         }
//         stack1.pop();
       
//     }
    
//     public int top() {
//        return  stack1.peek(); 
//     }
    
//     public int getMin() {
//        return minstack.peek();
//     }
// }
