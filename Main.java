public class Main {
    public static void main(String[] args)
    {
        int M = 10, N = 10;

        // Initializing the grid.
        int[][] grid = { { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };

        // Displaying the grid
        System.out.println("Original Generation");
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (grid[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        nextGeneration(grid);
    }

    // Function to print next generation
    static void nextGeneration(int[][] grid)
    {
        int M= grid.length;
        int N=grid.length;
        int[][] future = new int[M][N];
        for (int l = 0; l < M; l++)
        {
            for (int m = 0; m < N; m++)
            {

int aliveNeighbours = 0;
for(int i=-1; i<2;i++){

    for(int j=-1;j<2;j++){
        if ((l+i>=0 && l+i<M) && (m+j>=0 && m+j<N))
            aliveNeighbours += grid[l + i][m + j];
    }
}

                aliveNeighbours -= grid[l][m];

              if(grid[l][m]==1 && aliveNeighbours<2 ){
                  future[l][m]=0;

              } else if (grid[l][m]==1 && aliveNeighbours>3) {
                  future[l][m]=0;
              } else if (grid[l][m]==1 && aliveNeighbours>=2 && aliveNeighbours<=3) {
                  future[l][m]=1;
              }else{
                  future[l][m]=grid[l][m];
              }
              //grid[l][m]==1 && aliveNeighbours<2? future[l][m]=0:(grid[l][m]==1 && aliveNeighbours>3)? future[l][m]=0:(grid[l][m]==1 && aliveNeighbours>=2 && aliveNeighbours<=3)?future[l][m]=1:future[l][m]=grid[l][m]

            }
        }

        System.out.println("Next Generation");
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (future[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }
}