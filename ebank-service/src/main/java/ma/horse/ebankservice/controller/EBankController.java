package ma.horse.ebankservice.controller;

import ma.horse.ebankservice.entity.BankAccount;
import ma.horse.ebankservice.service.EBankService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EBankController {
    private EBankService ebankService;

    public EBankController(EBankService ebankService) {
        this.ebankService = ebankService;
    }

    @GetMapping("/accounts")
    public List<BankAccount> getAll() {
        return ebankService.getAll();
    }
    @GetMapping("/accounts/{id}")
    public BankAccount getBankAccountById(@PathVariable String id) {
        return ebankService.getBankAccountById(id);
    }
    @PostMapping("/accounts")
    public BankAccount save(@RequestBody BankAccount bankAccount) {
        return ebankService.save(bankAccount);
    }
}
