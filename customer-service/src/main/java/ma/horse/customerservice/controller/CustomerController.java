package ma.horse.customerservice.controller;

import ma.horse.customerservice.entity.Customer;
import ma.horse.customerservice.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customers")
    public List<Customer> findAll() {
        return customerService.findAll();
    }
    @GetMapping("customers/{id}")
    public Customer findById(@PathVariable Long id) {
        return customerService.findById(id);
    }
    @PostMapping("/save")
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }
}
