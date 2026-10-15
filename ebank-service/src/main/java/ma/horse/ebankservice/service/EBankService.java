package ma.horse.ebankservice.service;

import ma.horse.ebankservice.entity.BankAccount;
import ma.horse.ebankservice.feign.CustomerRestClient;
import ma.horse.ebankservice.model.Customer;
import ma.horse.ebankservice.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class EBankService {
    private BankAccountRepository bankAccountRepository;
    private CustomerRestClient customerRestClient;

    public EBankService(BankAccountRepository bankAccountRepository, CustomerRestClient customerRestClient) {
        this.bankAccountRepository = bankAccountRepository;
        this.customerRestClient = customerRestClient;
    }
    public List<BankAccount> getAll() {
        return bankAccountRepository.findAll();
    }
    public BankAccount getBankAccountById(String id) {
        BankAccount bankAccount= bankAccountRepository.findById(id)
                .orElseThrow(
                        ()->new RuntimeException("Bank account not found")
                );
        bankAccount.setCustomer(customerRestClient.getCustomerById(bankAccount.getCustomerId()));
        return bankAccount;
    }
    public BankAccount save(BankAccount bankAccount) {
        try {
            Customer customer = customerRestClient.getCustomerById(bankAccount.getCustomerId());
            bankAccount.setId(UUID.randomUUID().toString());
            bankAccount.setCreatedAt(new Date());
            return bankAccountRepository.save(bankAccount);
        } catch (Exception e) {
            throw  new RuntimeException(e.getMessage());
        }

    }
}
