package escuelaing.edu.arep.parcialarep.math_service.Service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class MathService {

    /**
     * Calcula los factores de un número dado.
     * @param n Número entero positivo.
     * @return Lista de factores de n.
     */
    public List<Integer> getFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
            }
        }
        return factors;
    }

    /**
     * Calcula todos los números primos menores o iguales a n.
     * @param n Número entero positivo.
     * @return Lista de números primos hasta n.
     */
    public List<Integer> getPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    /**
     * Verifica si un número es primo.
     * @param num Número a verificar.
     * @return true si es primo, false en caso contrario.
     */
    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}