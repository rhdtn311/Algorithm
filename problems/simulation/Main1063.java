package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main1063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] cols = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        int[][] graph = new int[8][8]; // 체스판
        String[] info = br.readLine().split(" ");
        char kc = info[0].charAt(0);
        int kr = Character.getNumericValue(info[0].charAt(1)) - 1;
        char sc = info[1].charAt(0);
        int sr = Character.getNumericValue(info[1].charAt(1)) - 1;
        graph[kr][kc - 65] = 1; // 왕
        graph[sr][sc - 65] = 2; // 돌
        int n = Integer.parseInt(info[2]);

        int col = kc - 65;
        int row = kr;
        while (n-- > 0) {
            String move = br.readLine();

            switch (move) {
                case "R":
                    if (col + 1 < 8) {
                        if (graph[row][col + 1] == 2) { // 만약 왕의 오른쪽에 돌이 있다면
                            if (col + 1 != 7) { // 돌이 현재 오른쪽 마지막에 있지 않다면
                                graph[row][col + 2] = 2;
                            } else {
                                break;
                            }
                        }
                        graph[row][col + 1] = 1;
                        graph[row][col] = 0;
                        col++;
                    }
                    break;

                case "L":
                    if (col - 1 >= 0) {
                        if (graph[row][col - 1] == 2) { // 만약 왕의 왼쪽에 돌이 있다면
                            if (col - 1 != 0) { // 돌이 가장 왼쪽에 있지 않다면
                                graph[row][col - 2] = 2;
                            } else {
                                break;
                            }
                        }
                        graph[row][col - 1] = 1;
                        graph[row][col] = 0;
                        col--;
                    }
                    break;

                case "B":
                    if (row - 1 >= 0) {
                        if (graph[row - 1][col] == 2) {
                            if (row - 1 != 0) {
                                graph[row - 2][col] = 2;
                            } else {
                                break;
                            }
                        }
                        graph[row - 1][col] = 1;
                        graph[row][col] = 0;
                        row--;
                    }
                    break;

                case "T":
                    if (row + 1 < 8) {
                        if (graph[row + 1][col] == 2) {
                            if (row + 1 != 7) {
                                graph[row + 2][col] = 2;
                            } else {
                                break;
                            }
                        }
                        graph[row + 1][col] = 1;
                        graph[row][col] = 0;
                        row++;
                    }
                    break;

                case "RT" :
                    if (row < 7 && col < 7) {
                        if (graph[row + 1][col + 1] == 2) {
                            if (row != 6 && col != 6) {
                                graph[row + 2][col + 2] = 2;
                            } else {
                                break;
                            }
                        }
                        graph[row + 1][col + 1] = 1;
                        graph[row][col] = 0;
                        row++; col++;
                    }
                    break;

                case "LT":
                    if (row < 7 && col > 0) {
                        if (graph[row + 1][col - 1] == 2) {
                            if (row != 6 && col != 1) {
                                graph[row + 2][col - 2] = 2;
                            } else {
                                break;
                            }
                        }
                        graph[row + 1][col - 1] = 1;
                        graph[row][col] = 0;
                        row++; col--;
                    }
                    break;

                case "RB":
                    if (row > 0 && col < 7) {
                        if (graph[row - 1][col + 1] == 2) {
                            if (row != 1 && col != 6) {
                                graph[row - 2][col + 2] = 2;
                            } else {
                                break;
                            }
                        }
                        graph[row - 1][col + 1] = 1;
                        graph[row][col] = 0;
                        row--; col++;
                    }
                    break;

                case "LB":
                    if (row > 0 && col > 0) {
                        if (graph[row - 1][col - 1] == 2) {
                            if (row != 1 && col != 1) {
                                graph[row - 2][col - 2] = 2;
                            } else {
                                break;
                            }
                        }
                        graph[row - 1][col - 1] = 1;
                        graph[row][col] = 0;
                        row--; col--;
                    }
                    break;
            }
        }

        System.out.println(cols[col] + "" + (row + 1));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (graph[i][j] == 2) {
                    System.out.println(cols[j] + "" + (i + 1));
                }
            }
        }

    }
}
