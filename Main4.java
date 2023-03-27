public class Main {

    public static int[][][] initial(){

        return new int[][][]{{{1, 0, 0}, {0, 0, 1}, {1, 1, 0}},{{1, 0, 0}, {0, 0, 1}, {1, 1, 0}},{{1, 0, 0}, {0, 0, 1}, {1, 1, 0}}};
    }
public static void print( int [][][]grid){
        for (int i = 0; i < grid.length; i++) {
            System.out.println("Array " + i + ":");
            for (int j = 0; j < grid[i].length; j++) {
                for (int k = 0; k < grid[i][j].length; k++) {
                    if(grid[i][j][k]==1){
                        System.out.print(" rosu ");
                    }else if(grid[i][j][k]==2 ){
                        System.out.print(" verde ");
                    }else if(grid[i][j][k]==3){
                        System.out.print(" albastru ");
                    }else{
//                        String arrString = Arrays.toString();
                        System.out.print(grid[i][j][k]+" ");
                    }
                }
                System.out.println();
            }
        }

            System.out.println();
        }


        public static void main(String[] args) {
        int[][][] grid =initial();

//      testAddition(nextGeneration(grid,grid.length));
        print(grid);
        System.out.println("Next Generation");
        print(nextGeneration(grid,grid.length));



        }
    static int[][][] nextGeneration(int[][][] grid,int n)
    {
        int[][][] future = new int[n][n][n];

        // Loop through every cell
        for (int l = 0; l < n; l++)
        {
            for (int m = 0; m < n; m++)
            {
                for(int k = 0; k< n; k++){
                    // finding no Of Neighbours that are alive
                    int aliveNeighbours = 0;
                    for (int i = -1; i <= 1; i++)
                        for (int j = -1; j <= 1; j++)
                            for(int z=-1;z<=1;z++)
                             if ((l+i>=0 && l+i< n) && (m+j>=0 && m+j< n) && (k+z>=0 && k+z< n))
                                aliveNeighbours += grid[l + i][m + j][z+k];

                    // The cell needs to be subtracted from
                    // its neighbours as it was counted before
                    aliveNeighbours -= grid[l][m][k];

                    // Implementing the Rules of Life

                    // Cell is lonely and dies
                    if ((grid[l][m][k] == 1) && (aliveNeighbours < 2))
                        future[l][m][k] = 0;

                        // Cell dies due to over population
                    else if ((grid[l][m][k] == 1) && (aliveNeighbours > 5))
                        future[l][m][k] = 0;

                        // A new cell is born
                    else if ((grid[l][m][k] == 0) && (aliveNeighbours ==2))
                        future[l][m][k] = 1;

                    else if ((grid[l][m][k] == 0) && (aliveNeighbours >2 && aliveNeighbours<=4))
                        future[l][m][k] = 2;

                    else if ((grid[l][m][k] == 0) && (aliveNeighbours ==5))
                        future[l][m][k] = 3;
                        // Remains the same
                    else
                        future[l][m][k] = grid[l][m][k];
                }

            }
        }


        return future;
    }

    }

