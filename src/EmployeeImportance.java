import java.util.HashMap;
import java.util.List;

/*
 * Time Complexity of the algorithm is O(V+E) where v is no. of vertices and E is no of edges.
 * space Complexity will O(v)  where v is no. of vertices.
 */

public class EmployeeImportance {

	class Employee {
		public int id;
		public int importance;
		public List<Integer> subordinates;
	};

	HashMap<Integer, Employee> map;
	int result;

	public int getImportance(List<Employee> employees, int id) {

		map = new HashMap<>();

		if (employees == null || employees.size() == 0)
			return 0;

		for (Employee e : employees) {

			map.put(e.id, e);
		}

		dfs(id);

		return result;

	}

	private void dfs(int id) {

		// base

		// logic

		Employee e = map.get(id);

		result += e.importance;

		for (int subID : e.subordinates) {

			dfs(subID);
		}

	}

//	     public int getImportance(List<Employee> employees, int id) {

//	         if(employees==null || employees.size() ==0)
//	             return 0;

//	         Queue<Integer> q= new LinkedList<>();
//	         HashMap<Integer, Employee> map = new HashMap<>();
//	         int result=0;
//	         q.add(id);

//	         for(Employee e : employees){

//	             map.put(e.id,e);
//	         }

//	         while(!q.isEmpty()){

	// // int size= q.size();

	// // for( Integer i : ){

//	                 int curr= q.poll();

//	                 Employee e= map .get(curr);
//	                 result += e.importance;

//	                 for(int subID: e.subordinates){

//	                         q.add(subID);
//	                     }

//	             // }

//	         }

//	         return result;

//	     }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
