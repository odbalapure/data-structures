package graph;

import java.util.Scanner;

public class Graph {

    /*DFS traversal code*/
    public static void dfsTraversal(int adjMat[][], int currVertex, boolean visited[]) {
        visited[currVertex] = true;
        System.out.print(currVertex + " ");

        for (int i=0; i<adjMat.length; i++) {
            if (adjMat[currVertex][i] == 1 && visited[i] == false) {
                dfsTraversal(adjMat, i, visited);
            }
        }
    }

    public static void dfsTraversal(int adjMat[][]) {
        boolean visited[] = new boolean[adjMat.length];
        dfsTraversal(adjMat, 0, visited);
    }

    /*Breadth first traversal*/
    public static void bfsTraversal(int adjMat[][]) {

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();

        int adjMatrix[][] = new int[n][n];
        for (int i=0; i<e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }

        dfsTraversal(adjMatrix);
    }
}
