package backtracking;

public class RatInMaze {

    public static void ratInMaze(int maze[][]) {
        int n = maze.length;
        int path[][] = new int[n][n];

        printAllPaths(maze, 0, 0, path);
        // return solveMaze(maze, 0, 0, path);
    }

    public static boolean solveMaze(int maze[][], int i, int j, int path[][]) {
        int n = maze.length;

        // check if i, j cell is valid
        if (i < 0 || i >= n || j < 0 || j >= n
                || maze[i][j] == 0 || path[i][j] == 1) {
            return false;
        }

        // include the cell in current path
        path[i][j] = 1;

        // destination cell
        if (i == n - 1 && j == n - 1) {
            for (int r=0; r<n; r++) {
                for (int c=0; c<n; c++) {
                    System.out.print(path[r][c] + " ");
                }
                System.out.println();
            }
            return true;
        }

        // not a destination cell then
        // explore other directions
        // going up
        if (solveMaze(maze, i - 1, j, path)) {
            return true;
        }

        // going right
        if (solveMaze(maze, i, j + 1, path)) {
            return true;
        }

        // going down
        if (solveMaze(maze, i + 1, j, path)) {
            return true;
        }

        // going left
        if (solveMaze(maze, i, j - 1, path)) {
            return true;
        }

        return false;
    }

    public static void printAllPaths(int maze[][], int i, int j, int path[][]) {
        int n = maze.length;

        // check if i, j cell is valid
        if (i < 0 || i >= n || j < 0 || j >= n
                || maze[i][j] == 0 || path[i][j] == 1) {
            return;
        }

        // include the cell in current path
        path[i][j] = 1;

        // destination cell
        if (i == n - 1 && j == n - 1) {
            for (int r=0; r<n; r++) {
                for (int c=0; c<n; c++) {
                    System.out.print(path[r][c] + " ");
                }
                System.out.println();
            }
            System.out.println("****************");
            path[i][j] = 0;
            return;
        }

        // not a destination cell then
        // explore other directions
        // NOTE: no conditionals needed as we need to print
        //      all the possible existing paths

        // going up
        printAllPaths(maze, i - 1, j, path);

        // going right
        printAllPaths(maze, i, j + 1, path);

        // going down
        printAllPaths(maze, i + 1, j, path);

        // going left
        printAllPaths(maze, i, j - 1, path);

        path[i][j] = 0;
    }

    public static void main(String[] args) {
        int maze[][] = {{1,1,0},{1,1,0},{1,1,1}};
        System.out.println("####################################");
        ratInMaze(maze);
        System.out.println("####################################");
    }
}
