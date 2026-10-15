package ma.horse.ebankservice.service;

import ma.horse.ebankservice.entity.BankAccount;
import ma.horse.ebankservice.repository.BankAccountRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class EBankService {
    private BankAccountRepository bankAccountRepository;

    public EBankService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }
    public List<BankAccount> getAll() {
        return bankAccountRepository.findAll();
    }
    public BankAccount getBankAccountById(String id) {
        return bankAccountRepository.findById(id).orElse(null);
    }
    public BankAccount save(BankAccount bankAccount) {
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new Date());
        return bankAccountRepository.save(bankAccount);
    }
}
