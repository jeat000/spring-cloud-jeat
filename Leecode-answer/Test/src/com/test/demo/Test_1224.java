package com.test.demo;

import java.text.DecimalFormat;
import java.util.PriorityQueue;

public class Test_1224 extends Test_1127 {
    public Test_1224(){
        super();
    }
    public static void main (String[]args) {
        PriorityQueue<Integer> integers = new PriorityQueue<>((a, b) -> b-a);
        integers.offer(1);
        integers.offer(2);
        integers.offer(5);
        integers.offer(3);
        System.out.println(integers.poll());
        System.out.println(integers.poll());
        System.out.println(integers.poll());
        System.out.println(integers.poll());
    }

    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        int[] p = new int[n];
        p[0]=customers[0][0] + customers[0][1];
        for(int i=1; i<n; i++){
            if(customers[i][0]<p[i-1]){
                p[i]=p[i-1]+customers[i][1];
            }else {
                p[i]=customers[i][0]+customers[i][1];
            }
        }
        long sum =0;
        for(int i=0;i<n;i++){
            sum+=(p[i] - customers[i][0]);
        }
        DecimalFormat df=new DecimalFormat("0.00000");

        return Double.parseDouble(df.format((double)sum/n));
    }
}
