package ru.itis;

import java.util.ArrayList;
import java.util.List;

public class WaveAlg {
    int width;
    int height;
    int wall = -2;
    int[][] table;
    List<Point> wave = new ArrayList<Point>();

    public WaveAlg(int width, int height) {
        this.width = width;
        this.height = height;
        table = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                table[i][j] = -1;
            }
        }

        for (int i = 0; i < width; i++) {
            table[i][0] = wall;
            table[width - 1][i] = wall;
        }
        for (int i = 0; i < height; i++) {
            table[0][i] = wall;
            table[i][height - 1] = wall;
        }
    }

    public void findPath(int x, int y, int nx, int ny) {
        if (table[y][x] == wall || table[ny][nx] == wall) {
            System.out.println("Одна из выбранных координат стена, выберите другую");
            return;
        }

        int[][] cloneMap = cloneTable(table);
        List<Point> oldWave = new ArrayList<Point>();
        oldWave.add(new Point(nx, ny));
        int nstep = 0;
        table[ny][nx] = nstep;

        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { -1, 0, 1, 0 };

        while (oldWave.size() > 0) {
            nstep++;
            wave.clear();
            for (Point i : oldWave) {
                for (int d = 0; d < 4; d++) {
                    nx = i.x + dx[d];
                    ny = i.y + dy[d];

                    if (table[ny][nx] == -1) {
                        wave.add(new Point(nx, ny));
                        table[ny][nx] = nstep;
                    }
                }
            }
            oldWave = new ArrayList<Point>(wave);
        }

        boolean flag = true;
        wave.clear();
        wave.add(new Point(x, y));
        while (table[y][x] != 0) {
            flag = true;
            for (int d = 0; d < 4; d++) {
                nx = x + dx[d];
                ny = y + dy[d];
                if (table[y][x] - 1 == table[ny][nx]) {
                    x = nx;
                    y = ny;
                    wave.add(new Point(x, y));
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Путь не найден!");
                break;
            }
        }

        table = cloneMap;

        for (Point i : wave) {
            table[i.y][i.x] = 0; 
        }
    }

    private int [][]cloneTable(int table[][]){
        int[][]cloneTable = new int[width][height];
        for (int i = 0; i < table.length; i ++){
            for (int j = 0; j < table.length; j ++){
                cloneTable[i][j] = table[i][j];
            }
        }
        return cloneTable;
    }

    private class Point {
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int x;
        public int y;
    }


    public void trace(){
        String m = null;
        for (int i = 0; i < width; i ++){
            m = i > 9 ? i + " " : i + "  ";
            for (int j = 0; j < height; j++) {
                m += table[i][j] > 9 || table[i][j] < 0 ? table[i][j] + " " : table[i][j] + "  ";
            }
            System.out.println(m);
        }
    }
}

