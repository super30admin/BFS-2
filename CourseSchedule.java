// Tc : O(v+e)
// Sc : O (max(v,e))
//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    public static void main(String[] args) {
        int [][] arr ={{1,0} , {2,0} , {3,1} , {5,2} , {3,2} , {4,1}, {5,4} , {2,6}  };
        CourseSchedule obj = new CourseSchedule();
        boolean obj1 = obj.canFinish(7, arr);
        System.out.println(obj1);

    }

   public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0) return true;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] Indegrees = new int[numCourses];
        for(int[] pr : prerequisites){
            Indegrees[pr[0]]++;
            if(!map.containsKey(pr[1])){
                map.put(pr[1] ,new ArrayList<>());
                //map.put(pr[1] , new ArrayList<>());
            }
            map.get(pr[1]).add (pr[0]);
        }
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0 ; i <Indegrees.length ; i ++){
            if(Indegrees[i] == 0){
                q.add(i);
                count++;
            }
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            List<Integer> child = map.get(curr);
            if(child!=null){
               for(Integer ch : child ){
                   Indegrees[ch]--;
                   if( Indegrees[ch]==0){
                       q.add(ch);
                       count++;
                       if(count == numCourses) return true;
                   }

               }
            } 
        }
        return false;
    }
}


