import java.util.HashMap;
import java.util.Map;

public class EjerciciosPD {
    public long getFibonacci(int n){
        
        
        if (n <= 1) {
            return n;
        }
        
       
        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }


    

    public long fibonacciPD(int n){
        Map<Long,Long> caching = new HashMap<>();
        return getFibonacciHelper(n,caching);

    }
    public long getFibonacciHelper(long n, Map<Long,Long> s) {
        if(s.containsKey(n)){
            return s.get(n);
        }
        if(n<=1){
            return n;
        }
        long resultado= getFibonacciHelper(n-1,s)+getFibonacciHelper(n-2,s);
        s.put(n, resultado);
        return resultado;
        
    }




    

}
