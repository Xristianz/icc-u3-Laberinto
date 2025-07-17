import java.util.*;

public class MazeSolverRecursivoCompletoBT implements MazeSolver {

    private List<Cell> path;
    private Set<Cell> visited;
    private boolean[][] grid;
    private Cell end;

    

    public MazeSolverRecursivoCompletoBT() {
        this.path = new ArrayList<>();
        this.visited = new LinkedHashSet<>();
    }



    @Override
    public MazeResult getPath(boolean[][] grid, Cell star, Cell end) {
        path.clear();
        visited.clear();
        this.grid = grid;
        this.end = end;
        if(grid == null||grid.length==0) return new MazeResult(new ArrayList<>(),new LinkedHashSet<>());
        if(findPath(star)){
            System.out.println("CAMINO");
            System.out.println(path);
            System.out.println("Visitadas");
            System.out.println(visited);
            MazeResult resultado = new MazeResult(path, visited);
            return resultado;
        }

       
        return new MazeResult(new ArrayList<>(),new LinkedHashSet<>());

        
    }



    private boolean findPath(Cell current) {
        if(!isInMaze(current)){
            return false;
        }
        if(!isValid(current)) return false;

        visited.add(current);
        path.add(current);
        if(current.equals(end)){
            return true;
        } 
        if(findPath( new Cell(current.row,current.col+1)) ||
         findPath( new Cell(current.row+1,current.col)) ||
          findPath( new Cell(current.row-1,current.col))||
          findPath( new Cell(current.row,current.col-1))){
            return true;
        }

        path.remove(path.size()-1);
        return false;        
      
    }


    private boolean isValid(Cell current) {
        if(!grid[current.row][current.col] || visited.contains(current)) return false;
        return true;
    }



    private boolean isInMaze(Cell current) {
        int row = current.row;
        int col = current.col;
        if(row<0|| row >= grid.length || col<0 || col>= grid[0].length){
            return false;
        }
        return true;
    }
    
}