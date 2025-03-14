import java.util.*;

public class BFSAdjMatrix {
    private int[][] adj;
    private int v;

    public BFSAdjMatrix(int v) {
        this.v = v;
        adj = new int[v][v];
    }

    public void BFS(int start) {
        if (start < 0 || start >= v) {
            System.out.println("Invalid start vertex!");
            return;
        }

        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        System.out.print("BFS Traversal: ");
        while (!queue.isEmpty()) {
            int vis = queue.poll();
            System.out.print(vis + " ");

            for (int i = 0; i < v; i++) {
                if (!visited[i] && adj[vis][i] == 1) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int v = sc.nextInt();

        BFSAdjMatrix graph = new BFSAdjMatrix(v);
        System.out.println("Enter the adjacency matrix:");

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                graph.adj[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter the starting vertex: ");
        int start = sc.nextInt();

        graph.BFS(start);
        sc.close();
    }
}
