package ma.horse.ebankservice.service;

import ma.horse.ebankservice.entity.BankAccount;
import ma.horse.ebankservice.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EBankService {
    private BankAccountRepository bankAccountRepository;

    public EBankService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }
    public List<BankAccount> findAll() {
        return bankAccountRepository.findAll();
    }
    public BankAccount findById(String id) {
        return bankAccountRepository.findById(id).orElse(null);
    }
    public BankAccount save(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }
}
