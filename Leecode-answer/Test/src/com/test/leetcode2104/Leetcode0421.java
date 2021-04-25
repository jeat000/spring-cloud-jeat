package com.test.leetcode2104;

/**
 * @ClassName Leetcode0421
 * @Author chenjian
 * @Date 2021-04-21 10:37
 */
public class Leetcode0421 {
    public static void main(String[] args) {
        Father f = new Son();
        f.showAge();
        System.out.println("age :" + f.age);
    }

    static class Son extends Father{
        public int age=3;
        public Son(){
            age=4;
            showAge();
        }
        @Override
        public void showAge(){
            System.out.println("Son age is: "+ age);
        }
    }
    static class Father{
        public int age=1;
        public Father(){
            age=2;
            showAge();
        }
        public void showAge(){
            System.out.println("father age is: "+ age);
        }
    }

    public int numDecodings(String s) {
        int n=s.length();
        if(n==0 || s.charAt(0)=='0') return 0;
        int[]db=new int[n+1];
        db[0]=1;
        db[1]=1;
        for(int i=1;i<n;i++){
            /*if(s.charAt(i)<'7' && s.charAt(i-1)<'3' && s.charAt(i-1)>'0'){*/
            if(s.charAt(i-1)!='0' && ((s.charAt(i-1)-'0')*10 + (s.charAt(i)-'0'))<27){
                db[i+1]+=db[i-1];
            }
            if(s.charAt(i)!='0'){
                db[i+1]+=db[i];
            }
        }
        return db[n];
    }
}
