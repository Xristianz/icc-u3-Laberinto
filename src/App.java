import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Cristian Moscoso");
       //runEjerciciosPD();
       runMaze();
    }
    private static void runEjerciciosPD(){
        EjerciciosPD ejerciciosPD = new EjerciciosPD();
        System.out.println("Fibonacci Recursivo");
        long start = System.nanoTime();
        long resultado = ejerciciosPD.getFibonacci(100);
        long end= System.nanoTime();;
        long duration = end - start;
        System.out.println("Resultado = " + resultado + " En tiempo = " + duration);
        System.out.println("Fibonacc recursivo catching");

        start=System.nanoTime();
        resultado=ejerciciosPD.fibonacciPD(100);
        end = System.nanoTime();
        duration = end-start;
        System.out.println("Resultado = " + resultado + " En tiempo = " + duration);
    }

    public static void runMaze() {
        boolean[][] predefinedMaze = {
            { true, true, true, true },
            { false, true, true, true },
            { true, true, false, false },
            { true, true, true, true }
        };

        // Se pasa el laberinto al constructor
        Maze maze = new Maze(predefinedMaze);
        System.out.println("Laberinto cargado");
        maze.printMaze();

        Cell start = new Cell(0, 0);
        Cell end = new Cell(3, 3);
        
        List<MazeSolver> solvers = Arrays.asList(
            new MazeSolverRecursivo()
        );

        MazeSolver solver = solvers.get(0);
        List<Cell> path = solver.getPath(maze.getGrid(), start, end);

        System.out.println("\nCamino encontrado: ");
        if (path.isEmpty()) {
            System.out.println("No se encontró un camino.");
        } else {
            
            for(Cell cell : path) {
                System.out.print( " Cell: "+"(" + cell.getRow() + ", " + cell.getCol() + ")");
            }
        }
    }

}
