package ma.horse.ebankservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.horse.ebankservice.model.Customer;

import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor @Builder
public class BankAccount {
    @Id
    private String id;
    private Date createdAt;
    private double balance;
    private  String type;
    private  Long customerId;
    @Transient
    private Customer customer;

}
