package com.test.demo;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        /*List<String> strings = Arrays.asList("nihao", "hello", "wor", "welcome");
        Comparator<String> objectComparator = Comparator.comparingInt(String::length);
        Collections.sort(strings,objectComparator);
        System.out.println(strings);*/

        /*int[][]A = new int[][]{{1,1,0},{1,0,1},{0,0,0}};
        int n = A.length,m=A[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m/2; j++){
                if(A[i][j]==A[i][m-j-1]){
                    A[i][j]^= 1;
                    A[i][m-j-1]^= 1;
                }
            }
        }
        if(m%2==1){
            for(int i=0;i<n;i++){
                A[i][(m/2)] ^= 1;
            }
        }
        for(int i=0; i<3; i++){
            for (int j=0; j<3; j++)
                System.out.printf("%-5d",A[i][j]);
            //"%md"：输出格式为整形，长度为m（输出最小长度），左对齐
            System.out.println();
        }*/
        int i = minCharacters("azzzzz", "azzzzz");
    }

    public static int minCharacters(String a, String b) {
        int[]ac = new int[26];
        int[]bc = new int[26];
        int sumA=a.length(),sumB=b.length();
        for (char c : a.toCharArray()){
            ac[c-'a']++;
        }
        for (char c : b.toCharArray()){
            bc[c-'a']++;
        }
        int min =Integer.MAX_VALUE;
        int a1=0,a2=sumA;
        int b1=0,b2=sumB;
        int minTogether = Integer.MAX_VALUE;
        for (int i=0;i<25;i++){
            a1+=ac[i];
            a2-=ac[i];
            b1+=bc[i];
            b2-=bc[i];
            min = Math.min(min,Math.min(a1+b2,a2+b1));
            minTogether = Math.min(minTogether,sumA+sumB-ac[i]-bc[i]);
        }
        minTogether = Math.min(minTogether,sumA+sumB-ac[25]-bc[25]);
        return Math.min(min,minTogether);
    }
    static class Point {
        int x, y;
        Point people;

        public Point() {
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }


        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    char[][] grid;
    // 目的地
    Point target;
    // 范围边界
    boolean[][] reached;

    public int minPushBox(char[][] grid) {
        this.grid = grid;
        this.reached = new boolean[grid.length][grid[0].length];
        Point box = new Point();
        // 走过的点
        Set<Point> pres = new HashSet<>();
        pres.add(box);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '#')
                    reached[i][j] = true;
                if (grid[i][j] == 'B') {
                    box.x = i;
                    box.y = j;
                    grid[i][j] = '.' + 1;
                }
                if (grid[i][j] == 'T') {
                    target = new Point(i, j);
                    grid[i][j] = '.';
                }
                if (grid[i][j] == 'S') {
                    box.people = new Point(i, j);
                    grid[i][j] = '.';
                }
            }
        }
        return bfs(pres, 0);
    }

    private int bfs(Set<Point> pres, int times) {
        if (pres.contains(target))
            return times;

        Set<Point> curr = new HashSet<>();
        for (Point p : pres) {

            int r = p.x, c = p.y;
            //上
            if (r > 0 && grid[r - 1][c] != '#' && grid[r - 1][c] != '.' + 2 && canReach(p, r + 1, c)) {
                Point tem = new Point(r - 1, c);
                tem.people = new Point(r, c);
                if (!curr.contains(tem)) {
                    curr.add(tem);
                    grid[r - 1][c]++;
                }
            }
            //下
            if (r < grid.length - 1 && grid[r + 1][c] != '#' && grid[r + 1][c] != '.' + 2 && canReach(p, r - 1, c)) {
                Point tem = new Point(r + 1, c);
                tem.people = new Point(r, c);
                if (!curr.contains(tem)) {
                    curr.add(tem);
                    grid[r + 1][c]++;
                }

            }
            //左
            if (c > 0 && grid[r][c - 1] != '#' && grid[r][c - 1] != '.' + 2 && canReach(p, r, c + 1)) {
                Point tem = new Point(r, c - 1);
                tem.people = new Point(r, c);
                if (!curr.contains(tem)) {
                    curr.add(tem);
                    grid[r][c - 1]++;
                }

            }
            //右
            if (c < grid[0].length - 1 && grid[r][c + 1] != '#' && grid[r][c + 1] != '.' + 2 && canReach(p, r, c - 1)) {
                Point tem = new Point(r, c + 1);
                tem.people = new Point(r, c);
                if (!curr.contains(tem)) {
                    curr.add(tem);
                    grid[r][c + 1]++;
                }
            }

        }

        if (curr.isEmpty())
            return -1;

        return bfs(curr, times + 1);
    }


    private boolean canReach(Point box, int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '#')
            return false;

        reached[box.x][box.y] = true;
        reached[box.people.x][box.people.y] = true;
        Set<Point> pre = new HashSet<>();
        pre.add(box.people);
        boolean res = bfs2(pre, r, c);
        reached[box.x][box.y] = false;
        reached[box.people.x][box.people.y] = false;
        return res;
    }

    private boolean bfs2(Set<Point> pres, int r, int c) {
        if (reached[r][c])
            return true;

        Set<Point> cur = new HashSet<>();
        for (Point p : pres) {
            int row = p.x, col = p.y;
            //上
            if (row > 0 && !reached[row - 1][col]) {
                reached[row - 1][col] = true;
                cur.add(new Point(row - 1, col));
            }
            //下
            if (row < grid.length - 1 && !reached[row + 1][col]) {
                reached[row + 1][col] = true;
                cur.add(new Point(row + 1, col));
            }
            //左
            if (col > 0 && !reached[row][col - 1]) {
                reached[row][col - 1] = true;
                cur.add(new Point(row, col - 1));
            }
            //左
            if (col < grid[0].length - 1 && !reached[row][col + 1]) {
                reached[row][col + 1] = true;
                cur.add(new Point(row, col + 1));
            }
        }
        if (cur.isEmpty())
            return false;
        boolean res = bfs2(cur, r, c);
        for (Point p : cur)
            reached[p.x][p.y] = false;
        return res;
    }
}
