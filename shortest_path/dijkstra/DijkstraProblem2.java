package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraProblem2 {
    // 백준 1916번 최소비용 구하기
    static int INF = (int)1e9;
    static int N, E, start, end;
    static int[] d = new int[1002];
    static ArrayList<ArrayList<City>> graph = new ArrayList<>();
    public static void dijkstra(int start) {
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.offer(new City(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()) {
            City city = pq.poll();
            int bus = city.bus;
            int cost = city.cost;

            if (d[bus] < cost) continue;

            for (int i = 0; i < graph.get(bus).size(); i++) {
                int compareCost = d[bus] + graph.get(bus).get(i).cost;
                if (d[graph.get(bus).get(i).bus] > compareCost) {
                    d[graph.get(bus).get(i).bus] = compareCost;
                    pq.offer(new City(graph.get(bus).get(i).bus, compareCost));
                }
            }
        }
    }

    public static class City implements Comparable<City> {
        private int bus;
        private int cost;

        public City(int bus, int cost) {
            this.bus = bus;
            this.cost = cost;
        }

        @Override
        public int compareTo(City c) {
            return this.cost - c.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            int z = Integer.parseInt(s[2]);
            graph.get(x).add(new City(y,z));
        }

        Arrays.fill(d, INF);

        String[] s = br.readLine().split(" ");
        start = Integer.parseInt(s[0]);
        end = Integer.parseInt(s[1]);

        dijkstra(start);

        System.out.println(Arrays.toString(d));
        System.out.println(d.length);
        System.out.println(d[end]);
    }
}
//2
//
//1 2 10
//
//1 2 20
//
//1 2