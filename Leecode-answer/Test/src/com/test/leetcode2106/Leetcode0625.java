package com.test.leetcode2106;

import java.util.*;

/**
 * 别乱动我代码，水很深，你把握不住
 *
 * @ClassName Leetcode0625
 * @Author chenjian
 * @Date 2021-06-28 13:45
 */
public class Leetcode0625 {
    public int openLock(String[] deadends, String target) {
        if(target.equals("0000")){
            return 0;
        }
        Set<String> set=new HashSet<>();
        for(String str:deadends){
            set.add(str);
        }
        if(set.contains("0000")){
            return -1;
        }

        Queue<String> pre=new LinkedList<>();
        pre.add("0000");
        Queue<String> end=new LinkedList<>();
        end.add(target);
        set.add("0000");
        set.add(target);
        boolean flag=true;
        int ans=0;
        while(flag){
            flag=false;
            ans++;
            if(pre.size()>end.size()){
                Queue<String> temp=pre;
                pre=end;
                end=temp;
            }
            Set<String> targets=new HashSet<>(end);
            Queue<String> p=new LinkedList<>();
            while(!pre.isEmpty()){
                String str=pre.poll();
                for(int i=0;i<4;i++){
                    char[] chs=str.toCharArray();
                    int num=(int)chs[i]-'0';
                    int num1=(num+1+10)%10;
                    chs[i]=(char)(num1+'0');
                    String newstr=String.valueOf(chs);

                    if(targets.contains(newstr)){
                        return ans;
                    }
                    if(!set.contains(newstr)){
                        p.add(newstr);
                        set.add(newstr);
                        flag=true;
                    }
                    int num2=(num-1+10)%10;
                    chs[i]=(char)(num2+'0');
                    newstr=String.valueOf(chs);

                    if(targets.contains(newstr)){
                        return ans;
                    }
                    if(!set.contains(newstr)){
                        p.add(newstr);
                        set.add(newstr);
                        flag=true;
                    }
                }
            }
            pre=p;
        }
        return -1;
    }

    public int openLock2(String[] deadends, String target) {
        if(target=="0000") return 0;
        int deep = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Set<String> visit = new HashSet<>();
        for(String str : deadends){
            visit.add(str);
        }
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0; i<n; i++) {
                String num = queue.poll();
                if(!visit.add(num)){
                    continue;
                }
                if(target.equals(num)){
                    return deep;
                }
                for(int j=0; j<4; j++){
                    queue.offer(plusOne(num,j));
                    queue.offer(minusOne(num,j));
                }
            }
            deep++;
        }
        return -1;
    }

    public String plusOne(String str, int i){
        char[] chars = str.toCharArray();
        if(chars[i]=='9'){
            chars[i]='0';
        }else{
            chars[i] +=1;
        }
        return new String(chars);
    }

    public String minusOne(String str, int i){
        char[] chars = str.toCharArray();
        if(chars[i]=='0'){
            chars[i]='9';
        }else{
            chars[i] -=1;
        }
        return new String(chars);
    }
}
