package ma.horse.ebankservice;

import ma.horse.ebankservice.entity.BankAccount;
import ma.horse.ebankservice.repository.BankAccountRepository;
import ma.horse.ebankservice.service.EBankService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EbankServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(EBankService ebankService) {
        return args -> {
            for (int i = 1; i <=3 ; i++) {
                for (int j = 1; j <=5 ; j++) {
                    ebankService.save(BankAccount.builder()
                            .type(Math.random()>0.5?"CURRENT":"SAVING")
                            .balance(1000+Math.random()*100005)
                            .customerId((long) i)
                            .build());
                }
            }
        };
    }
}
