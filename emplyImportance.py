"""
690. Employee Importance

Time = o(n), n = number of employees
space = O(n), n = number of employees
Successfully excecuted on leetcode


Approach --
1. Create hasmaps for employee's importance and subordinates
2. For id given, call a recursive function which counts sum of emp_importance and sunordinates' importance from respectiove hashmaps 
"""
class Importance(object):
    def getImportance(self, employees, id):
       
        def helper(id):
            res = emp_dictionary[id]
            for sub_id in sub_dictionary[id]:
                res += helper(sub_id)
            return res
        
        emp_dictionary = {}
        sub_dictionary = {}
        for employee in employees:
            emp_dictionary[employee.id] = employee.importance
            sub_dictionary[employee.id] = employee.subordinates
        return helper(id)