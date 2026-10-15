package ma.horse.ebankservice.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import ma.horse.ebankservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customer-breaker",fallbackMethod = "getCustomerDefault")
    Customer getCustomerById(@PathVariable Long id);

    default Customer getCustomerDefault( Long id, Exception e) {
        return Customer.builder()
                .id(id)
                .name("Not  available")
                .email("default@gmail.com")
                .build();
    }

}
