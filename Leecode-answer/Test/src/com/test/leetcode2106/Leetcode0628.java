package com.test.leetcode2106;

import java.util.*;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName Leetcode0628
 * @Author chenjian
 * @Date 2021-06-28 13:45
 */
public class Leetcode0628 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (target==source) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<routes.length; i++){
            for(int j: routes[i]){
                List<Integer> list = map.getOrDefault(j,new LinkedList<>());
                list.add(i);
                map.put(j,list);
            }
        }

        Queue<Integer> q = new LinkedList<>(map.get(source));
        Set<Integer> visit = new HashSet<>(map.get(source));
        int step = 1;
        while(!q.isEmpty()) {
            int k = q.size();
            for(int i=0; i<k; i++){
                Integer temp = q.poll();
                for(int j=0; j<routes[temp].length; j++){
                    if(routes[temp][j]==target){
                        return step;
                    }
                    List<Integer> list = map.get(routes[temp][j]);
                    for(int t:list){
                        if(!visit.contains(t)){
                            visit.add(t);
                            q.add(t);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
