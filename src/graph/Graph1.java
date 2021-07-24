package graph;

import java.util.*;

public class Graph1 {

    /*DFS traversal*/
    public static void dfTraversal(int adjMat[][]) {
        boolean visited[] = new boolean[adjMat.length];

        // dfs traversal for connected graphs
        dfTraversal(adjMat, 0, visited);

        // dfs traversal for disconnected graphs
        // for (int i=0; i<adjMat.length; i++) {
        //     if (!visited[i]) {
        //         dfTraversal(adjMat, i, visited);
        //         System.out.println();
        //     }
        // }
    }

    public static void dfTraversal(int adjMat[][], int currVertex, boolean visited[]) {
        visited[currVertex] = true;
        System.out.print(currVertex + " ");

        for (int i=0; i<adjMat.length; i++) {
            // i is neighbour of current vertex
            // currentVertex -> row
            // i -> column
            if (adjMat[currVertex][i] == 1 && visited[i] == false) {
                dfTraversal(adjMat, i, visited);
            }
        }
    }

    /*BFS traversal*/
    public static void bfTraversal(int adjMat[][]) {
        Queue<Integer> pendingVertices = new LinkedList<>();
        boolean visited[] = new boolean[adjMat.length];

        // add first element to the queue
        // mark first vertex as visited
        visited[0] = true;
        pendingVertices.add(0);

        while (!pendingVertices.isEmpty()) {
            int currentVertex = pendingVertices.poll();
            System.out.print(currentVertex + " ");

            for (int i=0; i<adjMat.length; i++) {
                if (adjMat[currentVertex][i] == 1 && !visited[i]) {
                    // i is unvisited neighbour of current vertex
                    pendingVertices.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    /*Print a path from one node to another node - BFS*/
    public static List<Integer> getPath(int adjMat[][], int s, int e) {
        Queue<Integer> pendingVertices = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        boolean visited[] = new boolean[adjMat.length];

        visited[s] = true;
        // add source element to the queue
        pendingVertices.add(s);
        // parent of first vertex will be noting, so -1
        map.put(s, -1);

        boolean pathFound = false;

        while (!pendingVertices.isEmpty()) {
            int currentVertex = pendingVertices.poll();

            for (int i=0; i<adjMat.length; i++) {
                if (adjMat[currentVertex][i] == 1 && !visited[i]) {
                    // i is unvisited neighbour of current vertex
                    pendingVertices.add(i);
                    visited[i] = true;
                    map.put(i, currentVertex);

                    if (i == e) {
                        pathFound = true;
                        break;
                    }
                }
            }
        }

        if (pathFound) {
            List<Integer> path = new ArrayList<>();
            int currentVertex = e;
            while (currentVertex != -1) {
                path.add(currentVertex);
                int parent = map.get(currentVertex);
                currentVertex = parent;
            }
            return path;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // no. of vertices
        int n = sc.nextInt();
        // no. of edges
        int e = sc.nextInt();

        int adjMatrix[][] = new int[n][n];
        for (int i=0; i<e; i++) {
            // every edge will have 2 vertices
            // hence we need 2 inputs
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }

        System.out.println("\n####################################");
        System.out.println("DFS Traversal");
        dfTraversal(adjMatrix);
        System.out.println("\n####################################");
        System.out.println("BFS Traversal");
        bfTraversal(adjMatrix);
        System.out.println("\n####################################");
        System.out.println("Path from a to b");
        System.out.println(getPath(adjMatrix, 0, 5));
        System.out.println("\n####################################");
    }
}

/*
* Sample Input
5 4
0 2
0 3
2 1
3 4
*
* */
