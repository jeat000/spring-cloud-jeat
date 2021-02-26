package com.test.demo;

import java.util.LinkedList;
import java.util.List;

public class Test_210125 {
    public static void main(String[] args) {
        String[] s=new String[]{"\\/","/ "};
        System.out.println(regionsBySlashes(s));

        StringBuilder stringBuilder = new StringBuilder("手机号1,手机号2,手机号3,");
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        System.out.println(stringBuilder);
    }
    public List<String> letterCombinations(String digits) {
        char[]chars=digits.toCharArray();
        List<String> res = new LinkedList<>();
        dfs(0,chars,res,new StringBuilder());
        return res;
    }

    private void dfs(int n, char[]chars, List<String> res, StringBuilder str){
        if(n==chars.length){
            res.add(String.valueOf(str.toString()));
            return;
        }
        if(n<chars.length){
            str.append(chars[n]);
            dfs(n+1,chars,res,str);
            str.deleteCharAt(str.length()-1);
        }
    }

    public static int regionsBySlashes(String[] grid) {
        int n=grid.length;
        UnionFind u=new UnionFind(4*n*n);
        for(int i=0;i<n;i++){
            char[]strs = grid[i].toCharArray();
            for(int j=0;j<n;j++){
                int index=4*(n*i+j);
                char c = strs[j];
                if('/'==c){
                    u.union(index,index+1);
                    u.union(index+2,index+3);
                }else if('\\'==strs[j]){
                    u.union(index,index+3);
                    u.union(index+2,index+1);
                }else{
                    u.union(index,index+1);
                    u.union(index+1,index+2);
                    u.union(index+2,index+3);
                }

                if(j<n-1){
                    u.union(index+2,index+4);
                }

                if(i<n-1){
                    u.union(index+3,4*(n*(i+1)+j)+1);
                }
            }
        }

        return u.getCount();
    }

    private static class UnionFind{
        private int[]parent;
        private int count;
        public UnionFind(int n){
            this.parent=new int[n];
            this.count=n;
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }

        public int getCount(){
            return this.count;
        }

        public void union(int i,int j){
            int rootI=find(i);
            int rootJ=find(j);
            if(rootI==rootJ){
                return;
            }
            parent[rootI]=rootJ;
            count--;
        }

        public int find(int i){
            if(parent[i]!=i){
                parent[i]=find(parent[i]);
            }
            return parent[i];
        }

    }
}
