import java.util.*;

public class MazeResult {
    private List<Cell> path;
    private Set<Cell> visited;
    
    public MazeResult(List<Cell> path, Set<Cell> visited) {
        this.path = path;
        this.visited = visited;
    }
    public List<Cell> getPath() {
        return path;
    }
    public Set<Cell> getVisited() {
        return visited;
    }
    @Override
    public String toString() {
        return " [path=" + path + ", visited=" + visited + "]";
    }

    
}