package escuelaing.edu.arep.parcialarep2.Proxy_Service.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/proxy")
public class ProxyController {

    @Value("#{'${math.services}'.split(',')}")
    private List<String> mathServices;

    private final AtomicInteger counter = new AtomicInteger(0);
    private final RestTemplate restTemplate = new RestTemplate();

    private String getNextService() {
        int index = counter.getAndIncrement() % mathServices.size();
        return mathServices.get(index);
    }

    @GetMapping("/factors/{n}")
    public List<Integer> getFactors(@PathVariable int n) {
        String serviceUrl = getNextService() + "/math/factors/" + n;
        return restTemplate.getForObject(serviceUrl, List.class);
    }

    @GetMapping("/primes/{n}")
    public List<Integer> getPrimes(@PathVariable int n) {
        String serviceUrl = getNextService() + "/math/primes/" + n;
        return restTemplate.getForObject(serviceUrl, List.class);
    }
}