package com.gojek.bootcamp.drillv3;

public class Pattern {

    public int[][] gliderGun() {
        int[][] seedsMap = {
                {1, 5}, {2, 5}, {1, 6}, {2, 6}, {11, 5}, {11, 6}, {11, 7}, {12, 4}, {13, 3}, {14, 3},
                {12, 8}, {13, 9}, {14, 9}, {15, 6}, {16, 4}, {17, 5}, {17, 6}, {17, 7}, {18, 6}, {16, 8},
                {21, 3}, {21, 4}, {21, 5}, {22, 3}, {22, 4}, {22, 5}, {23, 2}, {23, 6}, {25, 1}, {25, 2},
                {25, 6}, {25, 7}, {35, 3}, {35, 4}, {36, 3}, {36, 4}
        };
        return seedsMap;
    }


    public int[][] blinker() {
        int[][] seedsMap = {
                {1, 2}, {2, 2}, {3, 2}
        };
        return seedsMap;
    }

    public int[][] block() {
        int[][] seedsMap = {
                {2, 3}, {3, 3}, {2, 2}, {3, 2}
        };
        return seedsMap;
    }

    public int[][] glider() {
        int[][] seedsMap = {
                {1, 1}, {2, 2}, {3, 2}, {1, 3}, {2, 3}
        };
        return seedsMap;
    }

}
