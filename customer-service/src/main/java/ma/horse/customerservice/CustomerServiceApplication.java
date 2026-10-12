package ma.horse.customerservice;

import ma.horse.customerservice.entity.Customer;
import ma.horse.customerservice.repository.CustomerRepository;
import ma.horse.customerservice.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerService customerService) {
        return args -> {
            List<String> names= List.of("hugues","hugo","fawzi");
            names.forEach(name -> {customerService.save(Customer.builder()
                    .name(name)
                    .email(name + "@gmail.com")
                    .build());});
        };
    }
}
