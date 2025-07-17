import java.util.*;
public class EjerciciosPD {

    public long getFibonaci(long n){
        if(n<=1) return n;
        return getFibonaci(n-1)+getFibonaci(n-2);
    }

    public long getFibonaciPD(long n){
        Map<Long, Long> cache = new HashMap<>();
        return getFibonaciPDHelper(n,cache);
    }

    private long getFibonaciPDHelper(long n,Map<Long, Long> cache){
        if(cache.containsKey(n)) return cache.get(n);

        if(n<=1){
            return n;
        }

        long resultado = getFibonaciPDHelper(n-1, cache) + getFibonaciPDHelper(n-2, cache);
        cache.put(n, resultado);
        return resultado;

      
    }
    
}