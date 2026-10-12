package ma.horse.customerservice.service;

import ma.horse.customerservice.entity.Customer;
import ma.horse.customerservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}
