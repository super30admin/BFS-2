#O(N) TIME AND O(N) SPACE WHERE N IS NO.OF EMPLOYEES

# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates


class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        employees_dict = {e.id: e for e in employees}             
        dq = []
        dq.append(id)
        total_imp = 0
        while dq:
            current = dq.pop()
            total_imp += employees_dict[current].importance
            if employees_dict[current].subordinates:
                dq = dq+employees_dict[current].subordinates
        return total_imp


        