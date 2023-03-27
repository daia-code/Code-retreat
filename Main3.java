public class Main {
    public static void main(String[] args) {
       int M=3,N=3;
        int[][] grid = {{1, 0, 0},
                {0, 0, 1},
                {1, 1, 0}
        };

        for(int step = 0; step < 10; step++) {
            System.out.println(step);
            System.out.println("Original Generation");
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j] == 0)
                        System.out.print(".");
                    else
                        System.out.print("*");
                }
                System.out.println();
            }
            System.out.println();
            grid=nextGeneration(grid);


            M= grid.length*2;
            N= grid.length*2;
            int[][] doubleGrid=new int[M][N];
            for(int i = 0;i<doubleGrid.length;i++){
                for(int j = 0;j<doubleGrid.length;j++){
                    doubleGrid[i][j]=grid[i][j]
                }
            }



        }
    }
    static int [][] nextGeneration(int[][] grid)
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
        return future;
    }

    }




