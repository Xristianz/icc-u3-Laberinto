import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MazeSolverRecurivo implements MazeSolver {

    @Override
    public MazeResult getPath(boolean[][] grid, Cell star, Cell end) {
        List<Cell> path = new ArrayList<>();
        Set<Cell> visited = new HashSet<>();
        if (grid == null || grid.length == 0) {
            return new MazeResult(path, visited);
        }
        
        if(findPath(grid,star,end,path, visited)) {
            return new MazeResult(path, visited);
        }
        // Si no se encontró camino, path estará vacío. Devolvemos el resultado con las celdas visitadas.
        return new MazeResult(path, visited);
    }

    // Este método es un solver simple que solo se mueve hacia abajo y a la derecha.
    private boolean findPath(boolean[][] grid, Cell current, Cell end, List<Cell> path, Set<Cell> visited) {
        int row = current.row;
        int col = current.col;

        // 1. Caso base: Verificamos si la celda está fuera del laberinto, es una pared, o ya fue visitada.
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || !grid[row][col] || visited.contains(current)) {
            return false;
        }

        path.add(current);
        visited.add(current);

        // 2. Caso base: Llegamos al final.
        if(current.equals(end)){
            return true;
        }

        // 3. Paso recursivo: Intentamos movernos hacia abajo y hacia la derecha.
        if(findPath(grid, new Cell(row+1,col), end, path, visited) || findPath(grid, new Cell(row,col+1), end, path, visited)){
            return true;
        }

        // 4. Backtracking: Si ninguna dirección funcionó, removemos la celda actual del camino.
        path.remove(path.size()-1);
        return false;
    }
}