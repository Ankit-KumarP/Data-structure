// ( 03/10/23, 20:05 )
package datastructure.Graph;

import java.util.*;
import java.lang.*;

// Edge class
class Edge {
    int src;
    int des;

    Edge(int src, int des) {
        this.src = src;
        this.des = des;
    }

}

public class Q01BasicGraph {

    // create
    static void create(ArrayList<Edge> graph[], int V) {
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        graph[6].add(new Edge(6, 5));
    }

    // bfs
    static ArrayList<Integer> bfs(ArrayList<Edge>[] graph, int src, int V) {
        ArrayList<Integer> rtn = new ArrayList<>();
        boolean flag[] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        int size = q.size();
        while (!q.isEmpty()) {
            for (int i = 0; i < size; i++) {
                int node = q.remove();
                if (!flag[node]) {
                    flag[node] = true;
                    rtn.add(node);
                    for (int j = 0; j < graph[node].size(); j++) {
                        int temp = graph[node].get(j).des;
                        q.add(temp);
                    }
                }
            }
            size = q.size();
        }

        return rtn;
    }

    // bfs2 : for disconnecte graph
    static void bfs2(ArrayList<Edge> graph[], int src, boolean[] visited, int V) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        int size = q.size();
        while (!q.isEmpty()) {
            for (int i = 0; i < size; i++) {
                int node = q.poll();
                if (!visited[node]) {
                    visited[node] = true;
                    System.out.print(node + " ");
                    for (int j = 0; j < graph[node].size(); j++) {
                        Edge edge = graph[node].get(j);
                        q.add(edge.des);
                    }
                }
            }
            size = q.size();
        }
    }

    // dfs
    static void dfs(ArrayList<Edge> graph[], int src, boolean[] visited, List<Integer> rtn) {
        if (!visited[src]) {
            visited[src] = true;
            rtn.add(src);
            for (int i = 0; i < graph[src].size(); i++) {
                Edge edge = graph[src].get(i);
                dfs(graph, edge.des, visited, rtn);
            }
        } else
            return;
    }

    // dfs2: for disconnected graph
    static void dfs2(ArrayList<Edge>[] graph, int src, boolean[] visited, List<Integer> rtn) {

        if (!visited[src]) {
            visited[src] = true;
            rtn.add(src);

            for (int i = 0; i < graph[src].size(); i++) {
                int node = graph[src].get(i).des;
                dfs2(graph, node, visited, rtn);
            }
        } else {
            return;
        }
    }

    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        create(graph, V);

        // QUES: 1 PRINTING ALL NEIGHBOUR OF 5
        // System.out.print("NEIGHBOUR OF 5 : ");
        // for (int i = 0; i < graph[5].size(); i++) {
        // Edge edge = graph[5].get(i);
        // System.out.print(edge.des + " ");
        // }
        System.out.println();

        // QUES: 2 BFS
        List<Integer> BFS = bfs(graph, 0, V);
        System.out.print("BFS : " + BFS);

        // QUES 3 BFS2 ( for disconnected graph )
        // System.out.println();
        // System.out.print("BFS FOR DISCONNECTED GRAPH : ");
        // boolean[] visited = new boolean[V];
        // for (int i = 0; i < V; i++) {
        // if (!visited[i]) {
        // bfs2(graph, i, visited, V);
        // }
        // }
        // System.out.println();

        // QUES 4 DFS
        boolean[] flag = new boolean[V];
        List<Integer> DFS = new ArrayList<>();
        dfs(graph, 0, flag, DFS);
        System.out.println("DFS : " + DFS);

        // QUES 5 DFS: For disconnected graph
        // boolean flag2[] = new boolean[V];
        // List<Integer> DFS2 = new ArrayList<>();

        // for (int i = 0; i < V; i++) {
        // if (!flag2[i]) {
        // dfs2(graph, 0, flag2, DFS2);
        // }
        // }
        // System.out.println("DFS2 : " + DFS2);
    }
}
