"""
# Employee info
class Employee(object):
    def __init__(self, id, importance, subordinates):
        # It's the unique id of each node.
        # unique id of this employee
        self.id = id
        # the importance value of this employee
        self.importance = importance
        # the id of direct subordinates
        self.subordinates = subordinates
"""
#leetcode 690
#space -
#time -
#alg0 : maps each employees details to their id and fetch their details accordingly as the subordinates are not apssed as objects but as just integers
#bfs
class Solution(object):
    def getImportance(self, employees, id):
        """
        :type employees: Employee
        :type id: int
        :rtype: int
        """
        # edge case
        if len(employees) == 0: return 0
        dict_emp = {}
        q = list()
        for e in employees:
            dict_emp[e.id] = e  # mapping each empoyee to a hash map and accessing it
        print(len(dict_emp))
        q.append(id)
        result = 0
        while q:
            eid = q.pop(0)
            e_1 = dict_emp[eid]
            result += e_1.importance
            for i in range(len(e_1.subordinates)):
                q.append(e_1.subordinates[i])
                i += 1
        return result

#dfs
class Solution(object):
    def getImportance(self, employees, id):
        """
        :type employees: Employee
        :type id: int
        :rtype: int
        """
        #edge case
        if (not(employees) or len(employees)==0): return 0
        dict_emp = {}
        for e in employees:
            dict_emp[e.id]=e #mapping each empoyee to a hash map and accessing it
        return self.helper_map(dict_emp,id)
    def helper_map(self,emp_map,id):
        curr = emp_map[id]
        result = curr.importance
        for i in curr.subordinates: #for each subordinate find the importance
            result += self.helper_map(emp_map,i)
        return result

