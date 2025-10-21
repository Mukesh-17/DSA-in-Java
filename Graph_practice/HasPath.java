
import java.util.*;

public class HasPath {

    public static class Edge {

        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void DFS(ArrayList<Edge>[] graph, int curr, boolean vis[]) {

        System.out.print(curr + " ");
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                DFS(graph, e.dest, vis);
            }
        }
    }

    public static void printAllPaths(ArrayList<Edge>[] graph, int curr, String path, boolean vis[], int tar) {

        if (curr == tar) {
            System.out.println(path);
            return;
        }

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                vis[curr] = true;
                printAllPaths(graph, e.dest, path + e.dest, vis, tar);
                vis[curr] = false;
            }
        }
    }

    public static boolean hasPath(ArrayList<Edge>[] graph, int curr, boolean vis[], int tar) {

        if (curr == tar) {
            //System.out.println("Yes");
            return true;
        }
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                vis[curr] = true;
                boolean res = hasPath(graph, e.dest, vis, tar);
                if (res) {
                    return true;
                }
                vis[curr] = false;
            }
        }
        return false;
    }


    /* 

       1 ---- 3
     /        | \
   0          |   5 ---- 6
     \        | /
      2 ---- 4

     */
    // public static void createGraph(ArrayList<Edge>[] graph) {
    //     for (int i = 0; i < graph.length; i++) {
    //         graph[i] = new ArrayList<>();
    //     }
    //     graph[0].add(new Edge(0, 1, 1));
    //     graph[0].add(new Edge(0, 2, 1));
    //     graph[1].add(new Edge(1, 0, 1));
    //     graph[1].add(new Edge(1, 3, 1));
    //     graph[2].add(new Edge(2, 0, 1));
    //     graph[2].add(new Edge(2, 4, 1));
    //     graph[3].add(new Edge(3, 1, 1));
    //     graph[3].add(new Edge(3, 4, 1));
    //     graph[3].add(new Edge(3, 5, 1));
    //     graph[4].add(new Edge(4, 2, 1));
    //     graph[4].add(new Edge(4, 3, 1));
    //     graph[4].add(new Edge(4, 5, 1));
    //     graph[5].add(new Edge(5, 3, 1));
    //     graph[5].add(new Edge(5, 4, 1));
    //     graph[5].add(new Edge(5, 6, 1));
    //     graph[6].add(new Edge(6, 5, 1));
    // }
    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // ----- Component 1 -----
        // graph[0].add(new Edge(0, 1, 1));
        // graph[0].add(new Edge(0, 2, 1));
        // graph[1].add(new Edge(1, 0, 1));
        // graph[1].add(new Edge(1, 3, 1));
        // graph[2].add(new Edge(2, 0, 1));
        // graph[3].add(new Edge(3, 1, 1));
        // // ----- Component 2 -----
        // graph[4].add(new Edge(4, 5, 1));
        // graph[5].add(new Edge(5, 4, 1));
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 1, 1));

    }

    public static void main(String[] args) {
        int v = 3;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        boolean vis[] = new boolean[graph.length];
        //DFS(graph, 0, vis);
        String path = "0";
        //printAllPaths(graph, 0, path, vis, 5);
        System.out.println(hasPath(graph, 0, vis, 2));
    }
}
