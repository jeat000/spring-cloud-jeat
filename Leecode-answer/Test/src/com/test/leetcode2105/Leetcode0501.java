package com.test.leetcode2105;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Leetcode0501
 * @Author chenjian
 * @Date 2021-05-06 10:31
 */
public class Leetcode0501 {
    Map<Integer, Employee> map = new HashMap<Integer, Employee>();

    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return dfs(id);
    }

    public int dfs(int id) {
        Employee employee = map.get(id);
        int total = employee.importance;
        List<Integer> subordinates = employee.subordinates;
        for (int subId : subordinates) {
            total += dfs(subId);
        }
        return total;
    }


    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }



}
