package escuelaing.edu.arep.parcialarep.math_service.Controller;

import escuelaing.edu.arep.parcialarep.math_service.Service.MathService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/math")
public class MathController {

    private final MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    /**
     * Endpoint para obtener los factores de un número.
     * @param n Número entero positivo.
     * @return Lista de factores en formato JSON.
     */
    @GetMapping("/factors/{n}")
    public List<Integer> getFactors(@PathVariable int n) {
        return mathService.getFactors(n);
    }

    /**
     * Endpoint para obtener los números primos hasta n.
     * @param n Número entero positivo.
     * @return Lista de números primos en formato JSON.
     */
    @GetMapping("/primes/{n}")
    public List<Integer> getPrimes(@PathVariable int n) {
        return mathService.getPrimes(n);
    }
}