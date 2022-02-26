package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main18428 {

    static String[][] graph;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new String[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = input[j];
            }
        }

        makeObject(0);
        System.out.println("NO");
    }

    static boolean checkDown(int x, int y, String[][] copyGraph) {
        if (x < 0 || x >= N) {
            return true;
        }

        if (copyGraph[x][y].equals("O")) {
            return true;
        }

        if (copyGraph[x][y].equals("S")) {
            return false;
        }

        return checkDown(x + 1, y, copyGraph);
    }

    static boolean checkUp(int x, int y, String[][] copyGraph) {
        if (x < 0 || x >= N) {
            return true;
        }

        if (copyGraph[x][y].equals("O")) {
            return true;
        }

        if (copyGraph[x][y].equals("S")) {
            return false;
        }

        return checkUp(x - 1, y, copyGraph);
    }

    static boolean checkLeft(int x, int y, String[][] copyGraph) {
        if (y < 0 || y >= N) {
            return true;
        }

        if (copyGraph[x][y].equals("O")) {
            return true;
        }

        if (copyGraph[x][y].equals("S")) {
            return false;
        }

        return checkLeft(x, y - 1, copyGraph);
    }

    static boolean checkRight(int x, int y, String[][] copyGraph) {

        if (y < 0 || y >= N) {
            return true;
        }

        if (copyGraph[x][y].equals("O")) {
            return true;
        }

        if (copyGraph[x][y].equals("S")) {
            return false;
        }

        return checkRight(x, y + 1, copyGraph);
    }

    static void makeObject(int depth) {

        if (depth == 3) {

            String[][] copyGraph = new String[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    copyGraph[i][j] = graph[i][j];
                }
            }

            boolean result = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (copyGraph[i][j].equals("T")) {
                        result = result && checkUp(i, j, copyGraph) && checkLeft(i, j, copyGraph) && checkDown(i, j, copyGraph) && checkRight(i, j, copyGraph);
                    }
                }
            }

            if (result) {
                System.out.println("YES");
                System.exit(0);
            }

            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j].equals("X")) {
                    graph[i][j] = "O";
                    makeObject(depth + 1);
                    graph[i][j] = "X";
                }
            }
        }

    }
}
