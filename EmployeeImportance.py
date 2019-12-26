#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Dec 26 08:53:09 2019

@author: tanvirkaur
"""

#time complexity = O(n)
# spece complexity = O(n)
class Solution:
    def getImportance(self, employees, id):
        """
        :type employees: Employee
        :type id: int
        :rtype: int
        """
        dict1 = {}
        for employee in employees:
            dict1[employee.id] = employee
        q = [(id)]
        summ = 0
        while q:
            nid = q.pop(0)
            n_employee = dict1[nid]
            summ += n_employee.importance
            q.extend((n_employee.subordinates))
        return summ
            