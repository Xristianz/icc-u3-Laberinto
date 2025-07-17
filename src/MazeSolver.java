import java.util.List;

public interface MazeSolver {
    MazeResult getPath(boolean[][] grid,Cell star, Cell end);
    
}